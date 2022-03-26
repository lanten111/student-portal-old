package co.za.repository;

import co.za.entity.Student;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    private static Student savedStudent = new Student();

    private static final Student student = new Student();

    @BeforeAll
    static void setUp(){
        student.setEmail("asda@asas");
        student.setIdNumber("12345345455");
        student.setName("name");
        student.setSurname("surname");
        student.setPassword("2312323");
        student.setPhoneNumber("0593454324");
    }

    @Before
    @Test
    public void saveStudent(){
        savedStudent = studentRepository.save(student);
        Assertions.assertEquals(savedStudent, student);
    }

    @Test
    void existsByStudentNumber() {
        Assertions.assertFalse(studentRepository.existsByStudentNumber(savedStudent.getStudentNumber()));
    }

    @Test
    void existsByIdNumber() {
        Assertions.assertFalse(studentRepository.existsByIdNumber(savedStudent.getIdNumber()));
    }

    @Test
    void existsByEmail() {
        Assertions.assertFalse(studentRepository.existsByEmail(savedStudent.getEmail()));
    }

//    @AfterAll
//    void disconnect(){
//        s
//    }
}