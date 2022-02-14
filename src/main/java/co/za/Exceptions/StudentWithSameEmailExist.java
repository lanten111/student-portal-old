package co.za.Exceptions;

public class StudentWithSameEmailExist extends RuntimeException{

    public StudentWithSameEmailExist(String email){
        super(email);
    }
}
