package co.za.repository;

import co.za.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModulesRepository extends JpaRepository<Module, Long> {
}