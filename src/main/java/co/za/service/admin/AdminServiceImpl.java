package co.za.service.admin;

import co.za.Exception.Exceptions.CourseNotFoundException;
import co.za.Exception.Exceptions.LecturerNotFoundException;
import co.za.Exception.Exceptions.ModuleNotFoundException;
import co.za.dto.*;
import co.za.entity.*;
import co.za.entity.Module;
import co.za.repository.*;
import co.za.service.CourseModule.BookService;
import co.za.service.CourseModule.CourseService;
import co.za.service.CourseModule.ModuleService;
import co.za.service.StudentModule.StudentService;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static co.za.service.ServiceMapper.*;

@AllArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final StudentRepository studentRepository;

    private final StudentCourseRepository studentCourseRepository;

    private final StudentModuleRepository studentModuleRepository;

    private final BookRepository bookRepository;

    private final DocumentRepository documentRepository;

    private final AssignmentRepository assignmentRepository;

    private final StudentService studentService;

    private final ModulesRepository modulesRepository;

    private final CourseRepository courseRepository;

    private final LecturerRepository lecturerRepository;

    private BookService bookService;

    private CourseService courseService;

    private ModuleService moduleService;



    @Override
    public List<LecturerDto> getLecturers() {
        return null;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        Student student = studentService.getStudentDb(studentDto.getId());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setSurname(studentDto.getSurname());
        student.setName(studentDto.getName());
        student.setProfilePicture(studentDto.getProfilePicture());
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
    public void deleteBooks(List<BookDto> bookDtoList) {
        bookService.deleteBooks(bookDtoList);
    }

    @Override
    public void addModules(List<ModuleDto> moduleDtoList) {
        for (ModuleDto moduleDto: moduleDtoList){
            List<Book> bookList = new ArrayList<>();
            for (BookDto book: moduleDto.getBooks()){
                Book books = bookRepository.findById(book.getId()).orElseThrow(() -> new ModuleNotFoundException(moduleDto.getId()));
                bookRepository.save(books);
                bookList.add(books);
            }
            Lecturer lecturer = lecturerRepository.findById(moduleDto.getId()).orElseThrow(() -> new LecturerNotFoundException(moduleDto.getId()));
            Module module = mapToModule(moduleDto);
            module.setBooks(bookList);
            module.setLecturer(lecturer);
            modulesRepository.save(module);
        }
    }

    @Override
    public void addBooks(List<BookDto> bookDtoList) {
        bookService.addBooks(bookDtoList);
    }

    @Override
    public void updateBook(BookDto bookDto) {
        bookService.updateBook(bookDto);
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
    public void deleteStudent(long id) {
        studentService.deleteStudent(id);
    }

    @Override
    public List<DocumentDto> getDocuments(long userId) {
        return mapToDocumentsDto(documentRepository.findAllById(Collections.singletonList(userId)));
    }

    @Override
    public void uploadDocuments(List<DocumentDto> documentDtos, long studentId) {

    }

    @Override
    public void deleteDocument(DocumentDto documentDto) {

    }

    @Override
    public void addCourses(List<CourseDto> courseDtoList) {
        for (CourseDto courseDto: courseDtoList){
            Course course = mapToCourse(courseDto);
            courseRepository.save(course);
        }
    }

}
