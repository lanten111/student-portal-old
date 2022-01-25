package co.za.service;

import co.za.DTO.StudentTo;
import co.za.domain.Student;
import co.za.repository.StudentRepo;
import org.springframework.stereotype.Component;

@Component
public class SaveImplementation implements SaveInterface {

    StudentRepo studentRepo;

    public SaveImplementation(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    @Override
    public void saveStudent(StudentTo studentTo) {
        Student student = TransferService.transferStudent(studentTo);
        studentRepo.save(student);
    }
}
