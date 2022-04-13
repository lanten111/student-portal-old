package co.za.service.lecturer;

import co.za.dto.*;
import co.za.entity.StudentCourse;

import java.util.List;

public interface LecturerService {

    void updateStudentModule(StudentModuleDto studentModuleDto);

    void updateStudentCourse(StudentCourseDto studentCourseDto);

    void updateStudent(StudentDto studentDto);

    void updateModule(ModuleDto moduleDto);

    void deleteModules(ModuleDto moduleDto);

    void addModules(ModuleDto moduleDto);

    void updateCourse(CourseDto courseDto);

    void deleteCourse(ModuleDto moduleDto);

    void addCourses(ModuleDto moduleDto);

    void addBooks(BookDto bookDto);

    void deleteBooks(BookDto bookDto);

    List<StudentDto> getStudents();

    StudentDto getStudent();
}
