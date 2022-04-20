package co.za.service.StudentModule;

import co.za.Exception.Exceptions.StudentNotFoundException;
import co.za.Exception.Exceptions.StudentWithSameEmailExist;
import co.za.Exception.Exceptions.StudentWithSameStudentNumberExist;
import co.za.Utils.Utils;
import co.za.dto.*;
import co.za.entity.*;
import co.za.entity.Module;
import co.za.enums.SEMESTER;
import co.za.repository.*;
import co.za.service.CourseModule.CourseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static co.za.service.ServiceMapper.*;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    private final StudentCourseRepository studentCourseRepository;

    private final StudentModuleRepository studentModuleRepository;

    private final BookRepository bookRepository;

    private final DocumentRepository documentRepository;

    private final CourseService courseService;

    private final AssignmentRepository assignmentRepository;

    private final ModelMapper modelMapper = new ModelMapper();

//    private final PasswordEncoder passwordEncoder;


    @Override
    public List<StudentDto> getStudents() {
        return mapToStudentsDto(studentRepository.findAll());
    }

    public Student getStudentDb(long id){
        return studentRepository.findAllById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }


    @Override
    public StudentResultsDto getResults(long id) {
        StudentResultsDto studentResultsDto = new StudentResultsDto();
        Student student = getStudentDb(id);
        studentResultsDto.setModuleResults("");
        for (StudentCourse studentCourse: student.getStudentCourses()){
            if (!studentCourse.isCompleted()){
                for (StudentModule studentModule: studentCourse.getStudentModules()){
                    if (!studentModule.isCompleted()){
                        studentResultsDto.setModuleId(studentModule.getModuleId());
                        studentResultsDto.setModuleName(studentModule.getModuleName());
                        studentResultsDto.setModuleMark(studentModule.getModuleMarks());
                        studentResultsDto.setModuleResults("");
                    }
                }
            }
        }
        return studentResultsDto;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        Student student = getStudentDb(studentDto.getId());
        student.setStudentNumber(student.getStudentNumber()); //can't be changed
        student.setPassword(studentDto.getPassword());
        student.setAddress(mapToAddress(studentDto.getAddress()));
        student.setDateUpdated(LocalDateTime.now());
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setProfilePicture(student.getProfilePicture());
        student.setPhoneNumber(student.getPhoneNumber());
        studentRepository.save(student);
    }


    @Override
    @Transactional()
    public List<DocumentDto> getDocuments(long id) {
        return mapToDocumentsDto(getStudentDb(id).getDocuments());
    }

    @Override
    public void uploadDocuments(List<DocumentDto> documentDtos, long id) {
        Student student = getStudentDb(id);
        List<Document> documentList = new ArrayList<>();
        for  (DocumentDto documentDto: documentDtos){
            for (Document document: student.getDocuments()){
                if (documentDto.getDocumentType().equals(document.getDocumentType())){
                    documentRepository.delete(document);
                }
            }
            Document newDocument = mapToDocument(documentDto);
            documentRepository.save(newDocument);
            documentList.add(newDocument);
        }
        student.setDocuments(documentList);
        studentRepository.save(student);
    }


    @Override
    @Transactional
    public void register(RegistrationDto registrationDto) {
        Student student = getStudentDb(registrationDto.getStudentId());
        Course course = courseService.getCourseDb(registrationDto.getCourseId());
        student.setStudentCourses(Collections.singletonList(createStudentCourse(course)));
        studentRepository.save(student);
    }

    @Override
    public void submitAssignment(AssignmentDto assignmentDto) {
        Student student = getStudentDb(assignmentDto.getStudent().getId());
        Assignment assignment = new Assignment();
        assignment.setLecturer(assignmentDto.getLecturer());
        assignment.setModuleId(assignmentDto.getModuleId());
        List<Document> documents = new ArrayList<>();
        for (DocumentDto documentDto: assignmentDto.getDocuments()){
            Document document = new Document();
            document.setDocument(documentDto.getDocument());
            document.setDocumentId(documentDto.getDocumentId());
            document.setDocumentType(documentDto.getDocumentType());
            documentRepository.save(document);
            documents.add(document);
        }
        assignment.setDocuments(documents);
        assignmentRepository.save(assignment);
        student.setAssignments(Collections.singletonList(assignment));
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto getStudent(long id){
        return mapToStudentDto(studentRepository.findAllById(id).orElseThrow(() -> new StudentNotFoundException(id)));
    }

    @Override
    public StudentDto getStudentByStudentNumber(String studentNumber){
        return mapToStudentDto(studentRepository.findByStudentNumber(studentNumber).orElseThrow(() -> new StudentNotFoundException(studentNumber)));
    }


    @Override
    public void createStudentAccount(StudentDto studentDto){

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
        Student student = mapToStudent(studentDto);
        student.setStudentNumber(studentNumber);
//        student.setPassword(passwordEncoder.encode(studentTO.getPassword()));
        student.setDateCreated(LocalDateTime.now());
        student.setPassword(studentDto.getPassword());
        student.setDateUpdated(LocalDateTime.now());
    }

    private String getStudentNumber(StudentDto studentDto){
        int totalStudents = (int) studentRepository.count();
        return Utils.generateStudentNumber(studentDto.getIdNumber(), totalStudents);
    }

    public StudentCourse createStudentCourse(Course course){
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setCourseCode(course.getCourseCode());
        studentCourse.setCourseName(course.getCourseName());
        studentCourse.setDateCompleted(null);
        studentCourse.setDateEnrolled(LocalDateTime.now());
        studentCourse.setCompleted(false);
        studentCourse.setGpa(0);
        studentCourse.setSemester(SEMESTER.FIRST_SEMESTER);
        List<StudentModule> studentModuleList = new ArrayList<>();
        for (Module module : course.getModule()){
            StudentModule studentModule = new StudentModule();
            studentModule.setModuleId(module.getModuleId());
            studentModule.setModuleCode(module.getModuleCode());
            studentModule.setModuleName(module.getModuleName());
            studentModule.setModuleTime(module.getModuleTime());
            studentModule.setLecturer(studentModule.getLecturer());
            studentModule.setModuleGuideUrl(studentModule.getModuleGuideUrl());
            studentModule.setBooks(module.getBooks());
            studentModule.setSemester(SEMESTER.FIRST_SEMESTER);
            studentModuleRepository.save(studentModule);
            studentModuleList.add(studentModule);
        }
        studentCourse.setStudentModules(studentModuleList);
        studentCourseRepository.save(studentCourse);
        return studentCourse;
    }

}
