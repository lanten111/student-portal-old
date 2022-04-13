package co.za.Exception.Exceptions;

public class StudentWithSameStudentNumberExist extends RuntimeException{

    public StudentWithSameStudentNumberExist(String studentNumber){
        super(studentNumber);
    }
}
