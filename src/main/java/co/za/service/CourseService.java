package co.za.service;

import co.za.Exceptions.CourseNotFoundException;
import co.za.dto.CoursesDto;
import co.za.entity.Courses;
import co.za.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static co.za.service.TransferService.transferCourse;
import static co.za.service.TransferService.transferCourses;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Courses getCourse(long id){
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("selected course not found"));
    }

    public CoursesDto getCourse(String id){
        return transferCourse(getCourse(Long.parseLong(id)));
    }

    public List<CoursesDto> getCourseList(){
        return transferCourses(courseRepository.findAll());
    }

    public void deleteCourse(String id){
        courseRepository.deleteById(Long.parseLong(id));
    }
}
