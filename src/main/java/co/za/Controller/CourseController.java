//package co.za.Controller;
//
//import co.za.dto.CourseDto;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/courses")
//public class CourseController {
//
//    private final CourseService<CourseDto> courseService;
//
//    public CourseController(CourseService<CourseDto> courseService) {
//        this.courseService = courseService;
//    }
//
//    @GetMapping()
//    public ResponseEntity<List<CourseDto>> getCourseList(){
//        return ResponseEntity.ok(courseService.getList());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CourseDto> getCourse(@PathVariable String id){
//        return ResponseEntity.ok(courseService.get(Long.parseLong(id)));
//    }
//
//    @PutMapping()
//    public ResponseEntity<?> addCourse(@RequestBody CourseDto courseDto){
//        courseService.add(courseDto);
//        return ResponseEntity.ok().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteCourse(@PathVariable String id){
//        courseService.delete(Long.parseLong(id));
//        return ResponseEntity.ok().build();
//    }
//
//}
