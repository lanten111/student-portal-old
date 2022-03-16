package co.za.repository;

import co.za.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findAllByStudentNumber(String StudentNumber);
    Optional<Student> findAllById(long id);
    boolean existsByStudentNumber(String studentNumber);
    boolean existsByIdNumber(String idNumber);
    boolean existsByEmail(String email);

}
