package co.za.service.StudentModule;

import co.za.dto.*;

import java.util.List;

public interface StudentService {

    StudentDto getStudentByStudentNumber(String StudentNumeber);

    StudentResultsDto getResults(long id);

    void register(RegistrationDto registrationDto);

    void updateStudent(StudentDto studentDto);

    StudentDto getStudent(long id);

    void createStudentAccount(StudentDto studentDto);

    List<StudentDto> getStudentList();

    int deleteStudent(long id);

    List<DocumentDto> getDocuments(long id);

    void uploadDocuments(List<DocumentDto> documentDtos, long studentId);

    int deleteDocument(DocumentDto documentDto);

    void submitAssignment(AssignmentDto assignmentDto);
}
