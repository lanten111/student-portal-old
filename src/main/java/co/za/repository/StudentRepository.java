package co.za.repository;

import co.za.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findAllByStudentNumber(String StudentNumber);
    Student findAllById(long id);
    boolean existsByStudentNumber(String studentNumber);
    boolean existsByIdNumber(String idNumber);
    boolean existsByEmail(String email);

}
