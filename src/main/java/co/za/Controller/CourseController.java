package co.za.Controller;

import co.za.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {


    @GetMapping("get-courses")
    public Student getCourseList(){
        return null;
    }


}
