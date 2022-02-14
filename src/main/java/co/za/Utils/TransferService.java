package co.za.Utils;

import co.za.DTO.StudentTo;
import co.za.domain.Student;

public class TransferService {

    public static Student transferStudent(StudentTo studentTo){

        Student student = new Student();
        student.setEmail(studentTo.getEmail());
        student.setName(studentTo.getName());
        student.setSurname(studentTo.getSurname());
        student.setIdNumber(studentTo.getIdNumber());
        student.setPhoneNumber(studentTo.getPhoneNumber());
        return student;
    }
}
