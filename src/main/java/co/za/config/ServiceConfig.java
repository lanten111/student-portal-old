package co.za.config;

import co.za.repository.StudentRepo;
import co.za.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public StudentService getStudentService(StudentRepo studentRepo){
        return new StudentService(studentRepo);
    }
}
