package co.za.repository;

import co.za.entity.Courses;
import co.za.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses, Long> {

}