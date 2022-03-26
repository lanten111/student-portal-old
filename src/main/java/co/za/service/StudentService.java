package co.za.service;

import co.za.Exceptions.StudentNotFoundException;
import co.za.Exceptions.StudentWithSameEmailExist;
import co.za.Exceptions.StudentWithSameStudentNumberExist;
import co.za.Utils.Utils;
import co.za.dto.StudentDto;
import co.za.entity.Course;
import co.za.entity.Student;
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

    private final CourseService courseService;

//    private final PasswordEncoder passwordEncoder;

    @Autowired
    public StudentService(StudentRepository studentRepository, CourseService courseService) {
        this.studentRepository = studentRepository;
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
        List<Course> courseList = new ArrayList<>();
        Student student = TransferService.transferStudent(studentDto);
        student.setStudentNumber(studentNumber);
//        student.setPassword(passwordEncoder.encode(studentTO.getPassword()));
        student.setDateCreated(LocalDateTime.now());
        student.setPassword(studentDto.getPassword());
        student.setDateUpdated(LocalDateTime.now());
        courseList.add(courseService.getCourse(studentDto.getCourseId()));
        student.setCourse(courseList);
        studentRepository.save(student);
    }

    private String getStudentNumber(StudentDto studentDto){
        int totalStudents = (int) studentRepository.count();
         return Utils.generateStudent(studentDto.getIdNumber(), totalStudents);
    }


}
