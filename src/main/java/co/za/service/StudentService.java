package co.za.service;

import co.za.dto.StudentTO;
import co.za.Exceptions.StudentNotFoundException;
import co.za.Exceptions.StudentWithSameEmailExist;
import co.za.Exceptions.StudentWithSameStudentNumberExist;
import co.za.Utils.Utils;
import co.za.entity.Student;
import co.za.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

//    private final PasswordEncoder passwordEncoder;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudent(StudentTO studentTo) {
        Student student = TransferService.transferStudent(studentTo);
        studentRepository.save(student);
    }

    public Student getStudent(String studentNumber){

        return studentRepository.findAllByStudentNumber(studentNumber).orElseThrow(() -> new StudentNotFoundException(studentNumber));
    }

    public Student getStudent(Long id){
        return studentRepository.findAllById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    @Transactional
    public String studentRegister(StudentTO studentTo){

        if (studentRepository.existsByIdNumber(studentTo.getIdNumber())){
            throw new StudentWithSameStudentNumberExist(studentTo.getIdNumber());
        } else if (studentRepository.existsByEmail(studentTo.getEmail())){
            throw new StudentWithSameEmailExist(studentTo.getEmail());
        } else {
            String studentNumber = getStudentNumber(studentTo);
            return saveStudent(studentTo, studentNumber);
        }
    }

    private String saveStudent(StudentTO studentTO, String studentNumber){
        Student student = TransferService.transferStudent(studentTO);
        student.setStudentNumber(studentNumber);
//        student.setPassword(passwordEncoder.encode(studentTO.getPassword()));
        student.setDateCreated(LocalDateTime.now());
        student.setPassword(studentTO.getPassword());
        student.setDateUpdated(LocalDateTime.now());
        student.setDeleted(false);
        studentRepository.save(student);
        return studentNumber;
    }

    private String getStudentNumber(StudentTO studentTO){
        int totalStudents = (int) studentRepository.count();
         return Utils.generateStudent(studentTO.getIdNumber(), totalStudents);
    }

}
