package co.za.service;

import co.za.domain.Student;
import co.za.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudentByStudentNumber(String studentNumber){
        return studentRepo.findStudentBySurname(studentNumber);
    }

//    public static void main(String [] args){
//
//        StudentService studentService = new StudentService();
//        studentService.getStudentByStudentNumber("2020000");
//        System.out.println("");
//    }


}
