package co.za.Exceptions;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(String message) {
        super(message);
    }
}
