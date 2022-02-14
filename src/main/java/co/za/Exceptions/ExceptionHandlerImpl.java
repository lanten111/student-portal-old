package co.za.Exceptions;

import co.za.DTO.ExceptionTo;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.*;

@RestControllerAdvice
public class ExceptionHandlerImpl {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> genericException(Exception exception, HttpServletRequest httpServletRequest){
        ExceptionTo exceptionTo = new ExceptionTo();
        exceptionTo.setMessage(exception.getMessage());
        exceptionTo.setTimeStamp(LocalDateTime.now().toString());
        return new ResponseEntity<>(exceptionTo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> studentNotfound(Exception exception, HttpServletRequest httpServletRequest){
        ExceptionTo exceptionTo = new ExceptionTo();
        exceptionTo.setMessage("Student "+exception.getMessage()+" not found");
        exceptionTo.setTimeStamp(LocalDateTime.now().toString());
        return new ResponseEntity<>(exceptionTo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentWithSameStudentNumberExist.class)
    public ResponseEntity<Object> idExistException (Exception exception, HttpServletRequest httpServletRequest){
        ExceptionTo exceptionTo = new ExceptionTo();
        exceptionTo.setMessage("Student with id number "+exception.getMessage()+" already exist");
        exceptionTo.setTimeStamp(LocalDateTime.now().toString());
        return new ResponseEntity<>(exceptionTo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentWithSameEmailExist.class)
    public ResponseEntity<Object> emailExistException (Exception exception, HttpServletRequest httpServletRequest){
        ExceptionTo exceptionTo = new ExceptionTo();
        exceptionTo.setMessage("Student with email "+exception.getMessage()+" already exist");
        exceptionTo.setTimeStamp(LocalDateTime.now().toString());
        return new ResponseEntity<>(exceptionTo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> hibernateValidation (ConstraintViolationException exception, HttpServletRequest httpServletRequest){
        Set<ConstraintViolation<?>> set =  exception.getConstraintViolations();
        List<ExceptionTo> exceptionToList = new ArrayList<>();
        for (Iterator<ConstraintViolation<?>> iterator = set.iterator(); iterator.hasNext(); ) {
            ExceptionTo exceptionTo = new ExceptionTo();
            ConstraintViolation<?> next =  iterator.next();
            exceptionTo.setMessage(((PathImpl)next.getPropertyPath()).getLeafNode().getName() +" "+next.getMessage());
            exceptionTo.setTimeStamp(LocalDateTime.now().toString());
            exceptionToList.add(exceptionTo);
        }
        return new ResponseEntity<>(exceptionToList, HttpStatus.BAD_REQUEST);
    }

}
