package co.za.service.admin;

import co.za.Exception.Exceptions.BookNotFoundException;
import co.za.dto.*;
import co.za.entity.Book;
import co.za.entity.Student;
import co.za.repository.*;
import co.za.service.CourseModule.CourseServiceImpl;
import lombok.AllArgsConstructor;

import java.util.List;

import static co.za.service.ServiceMapper.*;

@AllArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final StudentRepository studentRepository;

    private final StudentCourseRepository studentCourseRepository;

    private final StudentModuleRepository studentModuleRepository;

    private final BookRepository bookRepository;

    private final DocumentRepository documentRepository;

    private final CourseServiceImpl courseServiceImpl;

    private final AssignmentRepository assignmentRepository;

    @Override
    public Student getStudentDb(long id) {
        return null;
    }

    @Override
    public StudentDto getStudentByStudentNumber(String StudentNumeber) {
        return null;
    }

    @Override
    public StudentResultsDto getResults(long id) {
        return null;
    }

    @Override
    public void register(RegistrationDto registrationDto) {

    }

    @Override
    public void createStudentAccount(StudentDto studentDto) {

    }

    @Override
    public void submitAssignment(AssignmentDto assignmentDto) {

    }

    @Override
    public List<LecturerDto> getLecturers() {
        return null;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {

    }

    @Override
    public void updateCourse(CourseDto courseDto) {

    }

    @Override
    public void addCourses(List<CourseDto> courseDtoList) {

    }

    @Override
    public void updateModule(ModuleDto moduleDto) {

    }

    @Override
    public void addModules(List<ModuleDto> moduleDtoList) {

    }

    @Override
    public void addBooks(List<BookDto> bookDtoList) {

    }

    @Override
    public void updateBooks(BookDto bookDto) {

    }

    @Override
    public void deleteModules(ModuleDto moduleDto) {

    }

    @Override
    public void deleteBooks(List<BookDto> bookDtoList) {

    }

    @Override
    public void deleteCourse(CourseDto courseDto) {

    }

    @Override
    public void deleteStudent(long id) {

    }

    @Override
    public List<DocumentDto> getDocuments(long id) {
        return null;
    }

    @Override
    public void uploadDocuments(List<DocumentDto> documentDtos, long studentId) {

    }

    @Override
    public void deleteDocument(DocumentDto documentDto) {

    }

    @Override
    public void updateStudentModule(StudentModuleDto studentModuleDto) {

    }

    @Override
    public void updateStudentCourse(StudentCourseDto studentCourseDto) {

    }

    @Override
    public void updateLecturer(LecturerDto lecturerDto) {

    }

    @Override
    public LecturerDto getLecturer(long id) {
        return null;
    }

    @Override
    public StudentDto getStudent(long id) {
        return null;
    }

    @Override
    public CourseDto getCourse(long id) {
        return null;
    }

    @Override
    public ModuleDto getModule(long id) {
        return null;
    }

    @Override
    public BookDto getBook(long id) {
        return null;
    }

    @Override
    public List<CourseDto> getCourses() {
        return null;
    }

    @Override
    public List<ModuleDto> getModules() {
        return null;
    }

    @Override
    public List<BookDto> getBooks() {
        return null;
    }

    @Override
    public List<StudentDto> getStudents() {
        return null;
    }
}
