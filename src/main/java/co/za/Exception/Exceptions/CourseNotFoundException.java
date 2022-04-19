package co.za.Exception.Exceptions;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(Long id){
        super(String.valueOf(id));
    }
}
