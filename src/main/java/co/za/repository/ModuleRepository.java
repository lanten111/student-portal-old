package co.za.repository;

import co.za.entity.Modules;
import co.za.entity.StudentModule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Modules, Long> {
}