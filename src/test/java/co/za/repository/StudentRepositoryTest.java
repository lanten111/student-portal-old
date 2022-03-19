package co.za.repository;

import co.za.dto.StudentTO;
import co.za.entity.Student;
import co.za.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void testStudent(){

        StudentService studentService = new StudentService(studentRepository);
        Student student = new Student();
        student.setEmail("asda@asas");
        student.setIdNumber("12345345455");
        student.setName("name");
        student.setSurname("surname");
        student.setPassword("2312323");
        student.setPhoneNumber("0593454324");
        Student savedStudent = studentRepository.save(student);

        Assertions.assertEquals(savedStudent.getStudentNumber(), student.getStudentNumber());
        Assertions.assertEquals(savedStudent.getIdNumber(), student.getIdNumber());
        Assertions.assertEquals(savedStudent.getEmail(), student.getEmail());
        Assertions.assertEquals(savedStudent.getPhoneNumber(), student.getPhoneNumber());
        Assertions.assertEquals(savedStudent.getName(), student.getName());
        Assertions.assertEquals(savedStudent.getSurname(), student.getSurname());
        Assertions.assertEquals(savedStudent.getCourse(), student.getCourse());

    }

}