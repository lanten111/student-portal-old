package co.za.Controller;

import co.za.DTO.StudentTo;
import co.za.domain.Student;
import co.za.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    private Environment environment;

    public StudentController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping(path = "studentNumber/{studentNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentByStudentNumber(@PathVariable(value ="studentNumber") String studentNumber){
        return studentService.getStudent(studentNumber);

    }

    @GetMapping(path = "id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentById(@PathVariable(value ="id") int id){
        return studentService.getStudent(id);

    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }

    @PostMapping(path = "/insertStudent")
    public void insertStudent(@RequestBody StudentTo studentTo){
        studentService.saveStudent(studentTo);
    }
}

//localhost:8080/student/student/{studentNumber}
