package co.za.repository;

import co.za.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

//    Optional<Course> findById(long id);

}