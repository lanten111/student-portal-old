package co.za.api;

import co.za.domain.Student;
import co.za.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentAPI {

    @Autowired
    StudentService studentService;

    private Environment environment;

    public StudentAPI(Environment environment) {
        this.environment = environment;
    }

    @GetMapping(path = "/student/{studentNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getStudent(@PathVariable(value ="studentNumber") String studentNumber){

//        List<Student> student =  studentService.getStudentByStudentNumber(studentNumber);
//        Student student1 = student.get(0);
        return "YAy it works";

    }
}

//localhost:8080/student/student/{studentNumber}