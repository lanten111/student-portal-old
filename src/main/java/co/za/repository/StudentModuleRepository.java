package co.za.repository;

import co.za.entity.StudentModule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentModuleRepository extends JpaRepository<StudentModule, Long> {
}