package co.za.service.lecturer;

import co.za.dto.*;
import co.za.entity.Student;
import co.za.entity.StudentCourse;
import co.za.repository.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LecturerServiceImpl implements LecturerService {

    private final LecturerRepository lecturerRepository;

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    private final StudentCourseRepository studentCourseRepository;

    private final ModulesRepository modulesRepository;

    private final StudentModuleRepository studentModuleRepository;

    private final AssignmentRepository assignmentRepository;

    private final BookRepository bookRepository;

    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public void updateStudentModule(StudentModuleDto studentModuleDto) {

    }

    @Override
    public void updateStudentCourse(StudentCourseDto studentCourseDto) {
        StudentCourse studentCourse = studentCourseRepository.getOne(studentCourseDto.getId());
        studentCourse.set
        studentCourseRepository.save(studentCourse);
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        studentRepository.save(student);
    }

    @Override
    public void updateModule(ModuleDto moduleDto) {

    }

    @Override
    public void deleteModules(ModuleDto moduleDto) {

    }

    @Override
    public void addModules(ModuleDto moduleDto) {

    }

    @Override
    public void updateCourse(CourseDto courseDto) {

    }

    @Override
    public void deleteCourse(ModuleDto moduleDto) {

    }

    @Override
    public void addCourses(ModuleDto moduleDto) {

    }

    @Override
    public void addBooks(BookDto bookDto) {

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
