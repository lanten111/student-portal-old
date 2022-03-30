package co.za.Controller;

import co.za.dto.CoursesDto;
import co.za.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public ResponseEntity<List<CoursesDto>> getCourseList(){
        return ResponseEntity.ok(courseService.getCourseList());
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<CoursesDto> getCourse(@PathVariable String id){
        return ResponseEntity.ok(courseService.getCourse(id));
    }

    @PutMapping("/add-course")
    public ResponseEntity<?> addNewCourse(@RequestBody CoursesDto coursesDto){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-Course/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

}
