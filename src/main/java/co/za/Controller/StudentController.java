package co.za.Controller;

import co.za.dto.StudentDto;
import co.za.entity.Student;
import co.za.service.StudentModule.StudentService;
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
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/{studentNumber}")
    public ResponseEntity<StudentDto> getStudentByStudentNumber(@PathVariable String studentNumber){
        return ResponseEntity.ok(studentService.getStudentByStudentNumber(studentNumber));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable String id){
        return ResponseEntity.ok(studentService.getStudent(Long.parseLong(id)));
    }

    @GetMapping()
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok(studentService.getStudents());
    }

    @PutMapping()
    public ResponseEntity<List<Student>> registerStudent(@RequestBody StudentDto studentDto){
        studentService.createStudentAccount(studentDto);
       return ResponseEntity.ok().build();
    }
}





