package co.za.Controller;

import co.za.dto.CourseDto;
import co.za.service.adminMOdule.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@AllArgsConstructor
public class CourseController {


    AdminService adminService;

    @PostMapping()
    public ResponseEntity<?> updateCourse(CourseDto courseDto){
        adminService.updateCourse(courseDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteCourse(CourseDto courseDto){
        adminService.deleteCourse(courseDto);
        return ResponseEntity.ok().build();
    }


}
