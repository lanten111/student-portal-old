package co.za.Exception.Exceptions;

public class StudentWithSameEmailExist extends RuntimeException{

    public StudentWithSameEmailExist(String email){
        super(email);
    }
}
