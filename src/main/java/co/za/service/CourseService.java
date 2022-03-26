package co.za.service;

import co.za.Exceptions.CourseNotFoundException;
import co.za.entity.Course;
import co.za.repository.CourseRepository;
import co.za.response.CourseResponse;
import org.springframework.stereotype.Service;

import static co.za.Utils.Utils.generateResponse;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course getCourse(long id){
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("selected course not found"));
    }
}
