package co.za.repository;

import co.za.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepo extends MongoRepository<Long, Student> {

//    List<Student> findAllBy
}
