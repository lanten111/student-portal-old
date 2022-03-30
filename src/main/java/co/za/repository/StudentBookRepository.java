package co.za.repository;

import co.za.entity.StudentBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBookRepository extends JpaRepository<StudentBook, Long> {
}