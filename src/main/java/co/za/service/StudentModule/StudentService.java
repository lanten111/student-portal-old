package co.za.service.StudentModule;

import co.za.dto.*;
import co.za.entity.Student;

import java.util.List;

public interface StudentService {

    Student getStudentDb(long id);

    StudentDto getStudentByStudentNumber(String StudentNumeber);

    StudentResultsDto getResults(long id);

    void register(RegistrationDto registrationDto);

    void updateStudent(StudentDto studentDto);

    StudentDto getStudent(long id);

    void createStudentAccount(StudentDto studentDto);

    List<DocumentDto> getDocuments(long id);

    void uploadDocuments(List<DocumentDto> documentDtos, long studentId);

    void submitAssignment(AssignmentDto assignmentDto);
}
