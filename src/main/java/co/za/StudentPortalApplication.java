package co.za;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("co.za.repository")
public class StudentPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentPortalApplication.class, args);
    }

}
