package co.za.service.lecturer;

import co.za.Exception.Exceptions.LecturerNotFoundException;
import co.za.dto.*;
import co.za.entity.*;
import co.za.repository.*;
import co.za.service.CourseModule.BookService;
import co.za.service.CourseModule.CourseService;
import co.za.service.CourseModule.ModuleService;
import co.za.service.StudentModule.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static co.za.service.ServiceMapper.*;

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

    private final StudentService studentService;

    private final BookService bookService;

    private final CourseService courseService;

    private final ModuleService moduleService;

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
    public void updateLecturer(LecturerDto lecturerDto) {
        Lecturer lecturer = lecturerRepository.findById(lecturerDto.getId()).orElseThrow(() -> new LecturerNotFoundException(lecturerDto.getId()));
        lecturer.setName(lecturerDto.getName());
        lecturer.setAddress(mapToAddress(lecturerDto.getAddress()));
        lecturer.setPhoneNumber(lecturerDto.getPhoneNumber());
        lecturer.setGender(lecturerDto.getGender());
        lecturer.setIdNumber(lecturerDto.getIdNumber());
        lecturer.setDateUpdated(LocalDateTime.now());
    }

    @Override
    public LecturerDto getLecturer(long id) {
        return mapToLectureDto(lecturerRepository.findById(id).orElseThrow(() -> new LecturerNotFoundException(id)));
    }


    @Override
    public StudentDto getStudent(long id) {
       return studentService.getStudent(id);
    }

    @Override
    public CourseDto getCourse(long id) {
        return courseService.getCourse(id);
    }

    @Override
    public ModuleDto getModule(long id) {
        return moduleService.getModule(id);
    }

    @Override
    public BookDto getBook(long id) {
        return bookService.getBook(id);
    }

    @Override
    public List<CourseDto> getCourses() {
        return courseService.getCourses();
    }

    @Override
    public List<ModuleDto> getModules() {
        return moduleService.getModules();
    }

    @Override
    public List<BookDto> getBooks() {
        return bookService.getBooks();
    }

    @Override
    public List<StudentDto> getStudents() {
       return mapToStudentsDto(studentRepository.findAll());
    }
}
