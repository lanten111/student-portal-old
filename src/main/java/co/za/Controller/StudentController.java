package co.za.Controller;

import co.za.dto.StudentTO;
import co.za.dto.SuccessTO;
import co.za.entity.Student;
import co.za.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "studentNumber/{studentNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudentByStudentNumber(@PathVariable String studentNumber){
        return ResponseEntity.ok(studentService.getStudent(studentNumber));
    }

    @GetMapping(path = "id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudentById(@PathVariable(value ="id") long id){
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuccessTO> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @PostMapping(path = "/create-account")
    public ResponseEntity registerStudent(@RequestBody StudentTO studentTo){
        studentService.studentRegister(studentTo);
       return ResponseEntity.ok().build();
    }
}

//localhost:8080/student/student/{studentNumber}




