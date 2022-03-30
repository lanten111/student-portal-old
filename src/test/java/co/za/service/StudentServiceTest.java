package co.za.service;

import co.za.Exceptions.StudentNotFoundException;
import co.za.Exceptions.StudentWithSameEmailExist;
import co.za.Exceptions.StudentWithSameStudentNumberExist;
import co.za.dto.AddressDto;
import co.za.dto.StudentDto;
import co.za.entity.Student;
import co.za.repository.*;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static co.za.service.TransferService.transferStudent;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


class StudentServiceTest {

    StudentRepository studentRepository =  Mockito.mock(StudentRepository.class);
    CourseRepository courseRepository = Mockito.mock(CourseRepository.class);
    StudentCourseRepository studentCourseRepository = Mockito.mock(StudentCourseRepository.class);
    StudentBookRepository studentBookRepository = Mockito.mock(StudentBookRepository.class);
    StudentModuleRepository studentModuleRepository = Mockito.mock(StudentModuleRepository.class);

    StudentService studentService;

    CourseService courseService;

    private static final Student student = new Student();
    private static final StudentDto studentTO = new StudentDto();

    @BeforeAll
    static void beforeAll() {

        student.setId(1L);
        student.setEmail("asda@asas");
        student.setIdNumber("12345345455");
        student.setName("name");
        student.setSurname("surname");
        student.setPassword("2312323");
        student.setPhoneNumber("0593454324");

        studentTO.setEmail("asda@asas");
        studentTO.setIdNumber("12345345455");
        studentTO.setName("name");
        studentTO.setSurname("surname");
        studentTO.setPassword("2312323");
        studentTO.setPhoneNumber("0593454324");

        AddressDto addressDto = new AddressDto();
        addressDto.setCity("sdasds");
        addressDto.setZipCode("sads");
        addressDto.setCountry("sdasad");
        addressDto.setStreetName("dfsadsd");

        studentTO.setAddress(addressDto);
    }

    @BeforeEach
    public void setUp(){
        studentService = new StudentService(studentRepository, studentCourseRepository, studentModuleRepository, studentBookRepository, courseService);
    }

    @Test
    void testTransferService() {
        Student TrStudent = transferStudent(studentTO);
        Assertions.assertEquals(studentTO.getIdNumber(), TrStudent.getIdNumber());
        Assertions.assertEquals(studentTO.getEmail(), TrStudent.getEmail());
        Assertions.assertEquals(studentTO.getPhoneNumber(), TrStudent.getPhoneNumber());
        Assertions.assertEquals(studentTO.getName(), TrStudent.getName());
        Assertions.assertEquals(studentTO.getSurname(), TrStudent.getSurname());
    }

    @Test
    public void testGetStudent() {
        Mockito.when(studentRepository.save(student)).thenReturn(student);
        Student CurentStudent = studentService.getStudent(student.getId());
        Assertions.assertEquals(student, CurentStudent);
    }

    @Test
    public void willThrowWHenIDTaken(){
        Mockito.when(studentRepository.existsByIdNumber(studentTO.getIdNumber())).thenReturn(true);
        Assertions.assertThrows(StudentWithSameStudentNumberExist.class, () -> {studentService.studentRegister(studentTO);});
        verify(studentRepository, never()).save(any());
    }

    @Test
    public void willThrowWHenEmailIsTaken(){
        Mockito.when(studentRepository.existsByEmail(studentTO.getEmail())).thenReturn(true);
        Assertions.assertThrows(StudentWithSameEmailExist.class, () -> {studentService.studentRegister(studentTO);});
        verify(studentRepository, never()).save(any());
    }

    @Test
    public void willThrowWHenStudentNotFound(){
        Assertions.assertThrows(StudentNotFoundException.class, () -> {studentService.getStudent(18L);});
    }

}