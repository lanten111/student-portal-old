package co.za.service.CourseModule;

import co.za.Exception.Exceptions.BookNotFoundException;
import co.za.Exception.Exceptions.CourseNotFoundException;
import co.za.dto.CourseDto;
import co.za.dto.ModuleDto;
import co.za.entity.Course;
import co.za.entity.Module;
import co.za.repository.CourseRepository;
import co.za.repository.ModulesRepository;

import java.util.ArrayList;
import java.util.List;

import static co.za.service.ServiceMapper.*;

@org.springframework.stereotype.Service
public class CourseServiceImpl {

    private final CourseRepository courseRepository;

    private final ModulesRepository modulesRepository;

    public CourseServiceImpl(CourseRepository courseRepository, ModulesRepository modulesRepository) {
        this.courseRepository = courseRepository;
        this.modulesRepository = modulesRepository;
    }

    public Course getCourseDb(long id){
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
    }

    public CourseDto getCourse(long id){
        return mapToCourseDto(getCourseDb(id));
    }

    public void addCourses(List<CourseDto> courseDtoList){
        for (CourseDto courseDto: courseDtoList){
            Course course = mapToCourse(courseDto);
            List<Module> moduleList = new ArrayList<>();
            for(ModuleDto moduleDto : courseDto.getModule()){
                Module module = modulesRepository.findById(moduleDto.getId()).orElseThrow(() -> new BookNotFoundException(courseDto.getId()));
                moduleList.add(module);
            }
            course.setModule(moduleList);
            courseRepository.save(course);
        }
    }

    public void updateCourse(CourseDto courseDto){
        Course  course = courseRepository.findById(courseDto.getId()).orElseThrow(() -> new CourseNotFoundException(courseDto.getId()));
        course.setCourseCode(course.getCourseCode());
        course.setCourseName(course.getCourseName());
        course.setCourseDuration(course.getCourseDuration());
        courseRepository.save(course);
    }

    public List<CourseDto> getCourses(){
        return mapToCoursesDto(courseRepository.findAll());
    }

    public void delete(long id){
        courseRepository.deleteById(id);
    }

}
