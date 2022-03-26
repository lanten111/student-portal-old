package co.za.Controller;

import co.za.dto.StudentDto;
import co.za.entity.Student;
import co.za.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
//@EnableSwagger2
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "studentNumber/{studentNumber}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudentByStudentNumber(@PathVariable String studentNumber){
        return ResponseEntity.ok(studentService.getStudent(studentNumber));
    }

    @GetMapping(path = "id/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudentById(@PathVariable(value ="id") long id){
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @Operation(summary = "Get list of students")
    @ApiResponse(responseCode = "200", description = "return a list of all students in the database", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Student.class))})
    @GetMapping(path = "/", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @PostMapping(path = "/create-account")
    public ResponseEntity<List<Student>> registerStudent(@RequestBody StudentDto studentDto){
        studentService.studentRegister(studentDto);
       return ResponseEntity.ok().build();
    }
}

//localhost:8080/student/student/{studentNumber}




