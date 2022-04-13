package co.za.Exception.Exceptions;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String studentNumber){
        super(studentNumber);
    }

    public StudentNotFoundException(Long id){
        super(String.valueOf(id));
    }
}
