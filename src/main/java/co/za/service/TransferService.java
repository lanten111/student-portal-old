package co.za.service;

import co.za.dto.StudentTO;
import co.za.entity.Student;

public class TransferService {

    public static Student transferStudent(StudentTO studentTo){

        Student student = new Student();
        student.setEmail(studentTo.getEmail());
        student.setName(studentTo.getName());
        student.setSurname(studentTo.getSurname());
        student.setIdNumber(studentTo.getIdNumber());
        student.setPhoneNumber(studentTo.getPhoneNumber());
        return student;
    }
}
