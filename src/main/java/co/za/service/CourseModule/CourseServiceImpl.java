package co.za.service.CourseModule;

import co.za.Exception.Exceptions.BookNotFoundException;
import co.za.Exception.Exceptions.CourseNotFoundException;
import co.za.dto.CourseDto;
import co.za.dto.ModuleDto;
import co.za.entity.Course;
import co.za.entity.Module;
import co.za.repository.CourseRepository;
import co.za.repository.ModulesRepository;
import co.za.service.Service;

import java.util.ArrayList;
import java.util.List;

import static co.za.service.ServiceMapper.*;

@org.springframework.stereotype.Service
public class CourseServiceImpl implements Service<CourseDto> {

    private final CourseRepository courseRepository;

    private final ModulesRepository modulesRepository;

    public CourseServiceImpl(CourseRepository courseRepository, ModulesRepository modulesRepository) {
        this.courseRepository = courseRepository;
        this.modulesRepository = modulesRepository;
    }

    public Course getCourse(long id){
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("selected course not found"));
    }

    @Override
    public CourseDto get(long id){
        return mapToCourseDto(getCourse(id));
    }

    @Override
    public void add(CourseDto courseDto){
        Course course = mapToCourse(courseDto);
        List<Module> moduleList = new ArrayList<>();
        for(ModuleDto moduleDto : courseDto.getModule()){
            Module module = modulesRepository.findById(moduleDto.getId()).orElseThrow(() -> new BookNotFoundException("Selected Module not found"));
            moduleList.add(module);
        }
        course.setModule(moduleList);
        courseRepository.save(course);
    }

    @Override
    public List<CourseDto> getList(){
        return mapToCoursesDto(courseRepository.findAll());
    }

    @Override
    public int delete(long id){
        courseRepository.deleteById(id);
        return 1;
    }

}
