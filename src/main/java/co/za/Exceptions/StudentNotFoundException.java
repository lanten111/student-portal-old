package co.za.Exceptions;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String id){
        super("Student was not found " + id);
    }
}
