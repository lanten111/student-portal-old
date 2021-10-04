package co.za.config;

import co.za.api.StudentAPI;
import co.za.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Profile("local")
@Configuration
public class ServiceConfig {

//    @Bean
//    public StudentService studentService(StudentRepo studentRepo){
//        return new StudentService();
//    }

    @Bean
    public StudentAPI studentAPI(Environment environment){
        return new StudentAPI(environment);
    }

//    @Bean
//    public StudentAPI studentAPI(Environment environment){
//        return new StudentAPI(environment);
//    }

//    @Bean
//    public DataSource getDatasoruce(){
//        return DataSource.;
//    }
}
