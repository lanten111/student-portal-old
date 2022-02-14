package co.za.service;

import co.za.DTO.StudentTo;
import co.za.Utils.TransferService;
import co.za.domain.Student;
import co.za.repository.StudentRepository;
import org.springframework.stereotype.Component;

@Component
public class SaveImplementation implements SaveInterface {

    StudentRepository studentRepository;

    public SaveImplementation(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveStudent(StudentTo studentTo) {
        Student student = TransferService.transferStudent(studentTo);
        studentRepository.save(student);
    }
}
