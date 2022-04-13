package co.za.Controller;

import co.za.dto.CourseDto;
import co.za.service.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final Service<CourseDto> service;

    public CourseController(Service<CourseDto> service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<CourseDto>> getCourseList(){
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourse(@PathVariable String id){
        return ResponseEntity.ok(service.get(Long.parseLong(id)));
    }

    @PutMapping()
    public ResponseEntity<?> addCourse(@RequestBody CourseDto courseDto){
        service.add(courseDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable String id){
        service.delete(Long.parseLong(id));
        return ResponseEntity.ok().build();
    }

}
