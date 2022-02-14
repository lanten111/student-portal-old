package co.za.Exceptions;

public class StudentWithSameStudentNumberExist extends RuntimeException{

    public StudentWithSameStudentNumberExist(String studentNumber){
        super(studentNumber);
    }
}
