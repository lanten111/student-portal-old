package co.za.Controller;

import co.za.dto.*;
import co.za.service.adminMOdule.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/student")
    public ResponseEntity<List<LecturerDto>> getLecturers(){
        return ResponseEntity.ok(adminService.getLecturers());
    }

    @PostMapping("/lecturer")
    public ResponseEntity<?> updateLecturer(LecturerDto lecturerDto){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/student")
    public ResponseEntity<?> updateStudent(StudentDto studentDto){
        adminService.updateStudent(studentDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/student")
    public ResponseEntity<?> deleteStudent(long id){
        adminService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/lecturer")
    public ResponseEntity<?> deleteLecturer(long id){
        return ResponseEntity.ok().build();
    }



}
