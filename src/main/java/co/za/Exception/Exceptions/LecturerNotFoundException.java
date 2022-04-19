package co.za.Exception.Exceptions;

public class LecturerNotFoundException extends RuntimeException{

    public LecturerNotFoundException(Long id){
        super(String.valueOf(id));
    }
}
