package co.za.service;

import co.za.Exceptions.StudentNotFoundException;
import co.za.Exceptions.StudentWithSameEmailExist;
import co.za.Exceptions.StudentWithSameStudentNumberExist;
import co.za.Utils.Utils;
import co.za.dto.StudentDto;
import co.za.entity.*;
import co.za.repository.StudentBookRepository;
import co.za.repository.StudentCourseRepository;
import co.za.repository.StudentModuleRepository;
import co.za.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final StudentCourseRepository studentCourseRepository;

    private final StudentModuleRepository studentModuleRepository;

    private final StudentBookRepository studentBookRepository;

    private final CourseService courseService;

//    private final PasswordEncoder passwordEncoder;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentCourseRepository studentCourseRepository, StudentModuleRepository studentModuleRepository, StudentBookRepository studentBookRepository, CourseService courseService) {
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
        this.studentModuleRepository = studentModuleRepository;
        this.studentBookRepository = studentBookRepository;
        this.courseService = courseService;
    }

    public void saveStudent(StudentDto studentDto) {
        Student student = TransferService.transferStudent(studentDto);
        studentRepository.save(student);
    }

    public Student getStudent(String studentNumber){

        return studentRepository.findAllByStudentNumber(studentNumber).orElseThrow(() -> new StudentNotFoundException(studentNumber));
    }

    public Student getStudent(Long id){
        return studentRepository.findAllById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    @Transactional
    public void studentRegister(StudentDto studentDto){

        if (studentRepository.existsByIdNumber(studentDto.getIdNumber())){
            throw new StudentWithSameStudentNumberExist(studentDto.getIdNumber());
        } else if (studentRepository.existsByEmail(studentDto.getEmail())){
            throw new StudentWithSameEmailExist(studentDto.getEmail());
        } else {
            String studentNumber = getStudentNumber(studentDto);
            saveStudent(studentDto, studentNumber);
        }
    }

    private void  saveStudent(StudentDto studentDto, String studentNumber){
        List<StudentCourse> studentCourseList = new ArrayList<>();
        Student student = TransferService.transferStudent(studentDto);
        student.setStudentNumber(studentNumber);
//        student.setPassword(passwordEncoder.encode(studentTO.getPassword()));
        student.setDateCreated(LocalDateTime.now());
        student.setPassword(studentDto.getPassword());
        student.setDateUpdated(LocalDateTime.now());
        StudentCourse studentCourse = transferCourse(courseService.getCourse(studentDto.getCourseId()));
        studentCourseList.add(studentCourse);
        student.setCourse(studentCourseList);
        studentRepository.save(student);
    }

    private String getStudentNumber(StudentDto studentDto){
        int totalStudents = (int) studentRepository.count();
         return Utils.generateStudent(studentDto.getIdNumber(), totalStudents);
    }

    @Transactional
    public StudentCourse transferCourse(Courses course){
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setCourseCode(course.getCourseCode());
        studentCourse.setCourseName(course.getCourseName());
        studentCourse.setDateCompleted(null);
        studentCourse.setDateEnrolled(LocalDateTime.now());
        studentCourse.setCompleted(false);
        studentCourse.setGpa(0);

        List<StudentModule> studentModuleList = new ArrayList<>();
        for (Modules modules: course.getModule()){
            StudentModule studentModule = new StudentModule();
            studentModule.setModuleId(modules.getModuleId());
            studentModule.setModuleCode(modules.getModuleCode());
            studentModule.setModuleName(modules.getModuleName());
            studentModule.setModuleTime(modules.getModuleTime());
            studentModule.setLecturer(studentModule.getLecturer());
            studentModule.setModuleGuideUrl(studentModule.getModuleGuideUrl());
            List<StudentBook> studentBookList = new ArrayList<>();
            for (Books books : modules.getBooks()){
                StudentBook studentBook = new StudentBook();
                studentBook.setBookName(books.getBookName());
                studentBook.setAuthor(books.getAuthor());
                studentBook.setEdition(books.getEdition());
                studentBook.setReleased(books.getReleased());
                studentBook.setIsbn(books.getIsbn());
                studentBookList.add(studentBook);
                studentBookRepository.save(studentBook);
            }
            studentModule.setBooks(studentBookList);
            studentModuleRepository.save(studentModule);
            studentModuleList.add(studentModule);
        }
        studentCourse.setModule(studentModuleList);
        studentCourseRepository.save(studentCourse);
        return studentCourse;
    }


}
