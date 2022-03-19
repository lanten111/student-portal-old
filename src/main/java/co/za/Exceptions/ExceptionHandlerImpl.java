package co.za.Exceptions;

import co.za.dto.ErrorTO;
import co.za.dto.ExceptionTO;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.juli.logging.LogFactory;
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
import java.util.logging.Level;
import java.util.logging.Logger;

@RestControllerAdvice
public class ExceptionHandlerImpl {

    private final Logger LOGGER = Logger.getLogger(String.valueOf(this.getClass()));

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> studentNotfound(Exception exception, HttpServletRequest httpServletRequest){
        ErrorTO errorTO = new ErrorTO();
        ExceptionTO exceptionTo = new ExceptionTO();
        exceptionTo.setMessage("Student "+exception.getMessage()+" not found");
        exceptionTo.setTimeStamp(LocalDateTime.now().toString());
        errorTO.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        errorTO.setCode(HttpStatus.NOT_FOUND.value());
        errorTO.setError(Collections.singletonList(exceptionTo));
        return new ResponseEntity<>(errorTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentWithSameStudentNumberExist.class)
    public ResponseEntity<Object> idExistException (Exception exception, HttpServletRequest httpServletRequest){
        ErrorTO errorTO = new ErrorTO();
        ExceptionTO exceptionTo = new ExceptionTO();
        exceptionTo.setMessage("Student with id number "+exception.getMessage()+" already exist");
        exceptionTo.setTimeStamp(LocalDateTime.now().toString());
        errorTO.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorTO.setCode(HttpStatus.BAD_REQUEST.value());
        errorTO.setError(Collections.singletonList(exceptionTo));
        return new ResponseEntity<>(errorTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentWithSameEmailExist.class)
    public ResponseEntity<Object> emailExistException (Exception exception, HttpServletRequest httpServletRequest){
        ErrorTO errorTO = new ErrorTO();
        ExceptionTO exceptionTo = new ExceptionTO();
        exceptionTo.setMessage("Student with email "+exception.getMessage()+" already exist");
        exceptionTo.setTimeStamp(LocalDateTime.now().toString());
        errorTO.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorTO.setCode(HttpStatus.BAD_REQUEST.value());
        errorTO.setError(Collections.singletonList(exceptionTo));
        return new ResponseEntity<>(errorTO, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> hibernateValidation (ConstraintViolationException exception, HttpServletRequest httpServletRequest){
        Set<ConstraintViolation<?>> set =  exception.getConstraintViolations();
        ErrorTO errorTO = new ErrorTO();
        List<ExceptionTO> exceptionTOList = new ArrayList<>();
        for (Iterator<ConstraintViolation<?>> iterator = set.iterator(); iterator.hasNext(); ) {
            ExceptionTO exceptionTo = new ExceptionTO();
            ConstraintViolation<?> next =  iterator.next();
            exceptionTo.setMessage(((PathImpl)next.getPropertyPath()).getLeafNode().getName() +" "+next.getMessage());
            exceptionTo.setTimeStamp(LocalDateTime.now().toString());
            exceptionTOList.add(exceptionTo);
        }
        errorTO.setCode(HttpStatus.BAD_REQUEST.value());
        errorTO.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorTO.setError(exceptionTOList);
        return new ResponseEntity<>(errorTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleNullPointer (Exception exception, HttpServletRequest httpServletRequest){
        LOGGER.log(Level.SEVERE, ExceptionUtils.getStackTrace(exception));
        ErrorTO errorTO = new ErrorTO();
        ExceptionTO exceptionTo = new ExceptionTO();
        exceptionTo.setMessage(ExceptionUtils.getMessage(exception));
        exceptionTo.setTimeStamp(LocalDateTime.now().toString());
        errorTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        errorTO.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorTO.setError(Collections.singletonList(exceptionTo));
        return new ResponseEntity<>(errorTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
