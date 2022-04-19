package co.za.Exception.Exceptions;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(Long id){
        super(String.valueOf(id));
    }
}
