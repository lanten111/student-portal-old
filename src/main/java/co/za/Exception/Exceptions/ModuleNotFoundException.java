package co.za.Exception.Exceptions;

public class ModuleNotFoundException extends RuntimeException{

    public ModuleNotFoundException(Long id){
        super(String.valueOf(id));
    }
}
