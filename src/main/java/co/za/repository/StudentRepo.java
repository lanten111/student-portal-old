package co.za.repository;

import co.za.domain.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface StudentRepo extends MongoRepository<Student, BigInteger> {

    List<Student> findStudentByIdNumber(String studentNumber);

    List<Student> findStudentBySurname(String studentNumber);
}
