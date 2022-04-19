package co.za.service.lecturer;

import co.za.dto.*;

import java.util.List;

public interface LecturerService {

    void updateStudentModule(StudentModuleDto studentModuleDto);

    void updateStudentCourse(StudentCourseDto studentCourseDto);

    void updateLecturer(LecturerDto lecturerDto);

    LecturerDto getLecturer(long id);

    StudentDto getStudent(long id);

    CourseDto getCourse(long id);

    ModuleDto getModule(long id);

    BookDto getBook(long id);

    List<CourseDto> getCourses();

    List<ModuleDto> getModules();

    List<BookDto> getBooks();

    List<StudentDto> getStudents();
}

