package co.za.service.admin;

import co.za.dto.*;
import co.za.service.StudentModule.StudentService;
import co.za.service.lecturer.LecturerService;

import java.util.List;

public interface AdminService {

    List<LecturerDto> getLecturers();

    void updateStudent(StudentDto studentDto);

    void updateCourse(CourseDto courseDto);

    void addCourses(List<CourseDto> courseDtoList);

    void updateModule(ModuleDto moduleDto);

    void addModules(List<ModuleDto> moduleDtoList);

    void addBooks(List<BookDto> bookDtoList);

    void updateBook(BookDto bookDto);

    void deleteModules(ModuleDto moduleDto);

    void deleteBooks(List<BookDto> bookDtoList);

    void deleteCourse(CourseDto courseDto);

    void deleteStudent(long id);

    List<DocumentDto> getDocuments(long userId);

    void uploadDocuments(List<DocumentDto> documentDtos, long studentId);

    void deleteDocument(DocumentDto documentDto);


}
