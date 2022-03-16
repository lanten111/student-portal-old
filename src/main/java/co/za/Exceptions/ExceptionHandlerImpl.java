package co.za.Exceptions;

import co.za.dto.ExceptionTO;
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

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> studentNotfound(Exception exception, HttpServletRequest httpServletRequest){
        ExceptionTO exceptionTo = new ExceptionTO();
        exceptionTo.setMessage("Student "+exception.getMessage()+" not found");
        exceptionTo.setTimeStamp(LocalDateTime.now().toString());
        return new ResponseEntity<>(exceptionTo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentWithSameStudentNumberExist.class)
    public ResponseEntity<Object> idExistException (Exception exception, HttpServletRequest httpServletRequest){
        ExceptionTO exceptionTo = new ExceptionTO();
        exceptionTo.setMessage("Student with id number "+exception.getMessage()+" already exist");
        exceptionTo.setTimeStamp(LocalDateTime.now().toString());
        return new ResponseEntity<>(exceptionTo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentWithSameEmailExist.class)
    public ResponseEntity<Object> emailExistException (Exception exception, HttpServletRequest httpServletRequest){
        ExceptionTO exceptionTo = new ExceptionTO();
        exceptionTo.setMessage("Student with email "+exception.getMessage()+" already exist");
        exceptionTo.setTimeStamp(LocalDateTime.now().toString());
        return new ResponseEntity<>(exceptionTo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> hibernateValidation (ConstraintViolationException exception, HttpServletRequest httpServletRequest){
        Set<ConstraintViolation<?>> set =  exception.getConstraintViolations();
        List<ExceptionTO> exceptionTOList = new ArrayList<>();
        for (Iterator<ConstraintViolation<?>> iterator = set.iterator(); iterator.hasNext(); ) {
            ExceptionTO exceptionTo = new ExceptionTO();
            ConstraintViolation<?> next =  iterator.next();
            exceptionTo.setMessage(((PathImpl)next.getPropertyPath()).getLeafNode().getName() +" "+next.getMessage());
            exceptionTo.setTimeStamp(LocalDateTime.now().toString());
            exceptionTOList.add(exceptionTo);
        }
        return new ResponseEntity<>(exceptionTOList, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> genericException(Exception exception, HttpServletRequest httpServletRequest){
//        ExceptionTO exceptionTo = new ExceptionTO();
//        exceptionTo.setMessage(exception.getMessage());
//        exceptionTo.setTimeStamp(LocalDateTime.now().toString());
//        return new ResponseEntity<>(exceptionTo, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
