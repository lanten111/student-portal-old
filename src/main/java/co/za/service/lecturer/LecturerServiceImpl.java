package co.za.service.lecturer;

import co.za.Exception.Exceptions.CourseNotFoundException;
import co.za.dto.*;
import co.za.entity.*;
import co.za.entity.Module;
import co.za.repository.*;
import co.za.service.StudentModule.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static co.za.service.ServiceMapper.*;

@Service
@AllArgsConstructor
public class LecturerServiceImpl implements LecturerService<StudentDto> {

    private final LecturerRepository lecturerRepository;

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    private final StudentCourseRepository studentCourseRepository;

    private final ModulesRepository modulesRepository;

    private final StudentModuleRepository studentModuleRepository;

    private final AssignmentRepository assignmentRepository;

    private final BookRepository bookRepository;

    private final StudentService studentService;

    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public void updateStudentModule(StudentModuleDto studentModuleDto) {
        StudentModule studentModule = studentModuleRepository.getOne(studentModuleDto.getId());
        studentModule.setModuleMarks(studentModuleDto.getModuleMarks());
        studentModule.setActive(studentModuleDto.isActive());
        studentModule.setCompleted(studentModuleDto.isCompleted());
        studentModuleRepository.save(studentModule);
    }

    @Override
    public void updateStudentCourse(StudentCourseDto studentCourseDto) {
        StudentCourse studentCourse = studentCourseRepository.getOne(studentCourseDto.getId());
        studentCourse.setGpa(studentCourseDto.getGpa());
        studentCourse.setCompleted(studentCourseDto.isCompleted());
        studentCourseRepository.save(studentCourse);
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        Student student = studentService.getStudentDb(studentDto.getId());
        studentRepository.save(student);
    }

    @Override
    public void updateModule(ModuleDto moduleDto) {
        Module module = modulesRepository.getOne(moduleDto.getId());
        module.setModuleGuideUrl(moduleDto.getModuleGuideUrl());
        module.setModuleName(module.getModuleName());
        module.setModuleTime(moduleDto.getModuleTime());
    }

    @Override
    public void deleteModules(ModuleDto moduleDto) {
        modulesRepository.deleteById(moduleDto.getId());
    }

    @Override
    public void addModules(ModuleDto moduleDto) {
        Module module = mapToModule(moduleDto);
        modulesRepository.save(module);
    }

    @Override
    public void updateCourse(CourseDto courseDto) {
        Course course = courseRepository.findById(courseDto.getId()).orElseThrow(() -> new CourseNotFoundException(courseDto.getId()));
        course.setCourseCode(course.getCourseCode());
        course.setCourseName(course.getCourseName());
        course.setCourseDuration(courseDto.getCourseDuration());
    }

    @Override
    public void deleteCourse(CourseDto courseDto) {
        courseRepository.deleteById(courseDto.getId());
    }

    @Override
    public void addCourses(CourseDto courseDto) {
        Course course = mapToCourse(courseDto);
        courseRepository.save(course);
    }

    @Override
    public void addBooks(BookDto bookDto) {
//        Book book =
    }

    @Override
    public void deleteBooks(BookDto bookDto) {

    }

    @Override
    public List<StudentDto> getStudents() {
        return null;
    }

    @Override
    public StudentDto getStudent() {
        return null;
    }
}
