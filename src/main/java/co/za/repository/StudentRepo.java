package co.za.repository;

import co.za.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    List<Student> findStudentByIdNumber(String studentIdNumber);

    Student findAllByStudentNumber(String StudentNumber);
    Student findAllById(int id);

}
