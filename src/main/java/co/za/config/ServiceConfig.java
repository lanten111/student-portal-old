package co.za.config;

import co.za.Controller.StudentController;
import co.za.repository.LoginRepository;
import co.za.repository.StudentRepository;
import co.za.service.SaveInterface;
import co.za.service.SaveImplementation;
import co.za.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Profile("local")
@EnableJpaRepositories
@Configuration
public class ServiceConfig {

    @Bean
    public StudentController studentAPI(Environment environment){
        return new StudentController(environment);
    }

    @Bean
    public SaveInterface saveInterface(StudentRepository studentRepository){
        return new SaveImplementation(studentRepository);
    }

    @Bean
    public StudentService studentService(StudentRepository studentRepository, SaveInterface saveInterface, LoginRepository loginRepository){
        return new StudentService(studentRepository, saveInterface, loginRepository);
    }

}
