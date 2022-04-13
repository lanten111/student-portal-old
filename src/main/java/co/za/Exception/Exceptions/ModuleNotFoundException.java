package co.za.Exception.Exceptions;

public class ModuleNotFoundException extends RuntimeException{

    public ModuleNotFoundException(String message) {
        super(message);
    }
}
