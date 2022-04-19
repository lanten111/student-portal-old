package co.za.Exception;

import co.za.Exception.Exceptions.*;
import co.za.dto.ErrorTO;
import co.za.dto.ExceptionTO;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
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
    ErrorTO errorTO = null;
    ExceptionTO exceptionTo = null;

    @ExceptionHandler(StudentWithSameStudentNumberExist.class)
    public ResponseEntity<Object> idExistException (Exception exception, HttpServletRequest httpServletRequest){
        ErrorTO errorTO = buildNotFoundError("student with student number "+exception.getMessage() + " already exist");
        return new ResponseEntity<>(errorTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentWithSameEmailExist.class)
    public ResponseEntity<Object> emailExistException (Exception exception, HttpServletRequest httpServletRequest){
        ErrorTO errorTO = buildNotFoundError("student with email "+exception.getMessage() + " already exist");
        return new ResponseEntity<>(errorTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> studentNotfound(Exception exception, HttpServletRequest httpServletRequest){
        ErrorTO errorTO = buildNotFoundError("student with id "+exception.getMessage() + " Not found");
        return new ResponseEntity<>(errorTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<Object> courseNotFound(Exception exception, HttpServletRequest httpServletRequest){
        ErrorTO errorTO = buildNotFoundError("course with id "+exception.getMessage() + " Not found");
        return new ResponseEntity<>(errorTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> bookNotFound(Exception exception, HttpServletRequest httpServletRequest){
        ErrorTO errorTO = buildNotFoundError("book with id "+exception.getMessage() + " Not found");
        return new ResponseEntity<>(errorTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ModuleNotFoundException.class)
    public ResponseEntity<Object> ModuleNotFound(Exception exception, HttpServletRequest httpServletRequest){
        ErrorTO errorTO = buildNotFoundError("module with id "+exception.getMessage() + " Not found");
        return new ResponseEntity<>(errorTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LecturerNotFoundException.class)
    public ResponseEntity<Object> LecturerNotFound(Exception exception, HttpServletRequest httpServletRequest){
        ErrorTO errorTO = buildNotFoundError("lecturer with id "+exception.getMessage() + " Not found");
        return new ResponseEntity<>(errorTO, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler({TransactionSystemException.class, ConstraintViolationException.class})
    public ResponseEntity<Object> hibernateValidation (ConstraintViolationException exception, HttpServletRequest httpServletRequest){
        Set<ConstraintViolation<?>> set =  exception.getConstraintViolations();
        errorTO = new ErrorTO();
        List<ExceptionTO> exceptionTOList = new ArrayList<>();
        for (ConstraintViolation<?> constraintViolation : set) {
            ExceptionTO exceptionTo = new ExceptionTO();
            ConstraintViolation<?> next = constraintViolation;
            exceptionTo.setMessage(((PathImpl) next.getPropertyPath()).getLeafNode().getName() + " " + next.getMessage());
            exceptionTo.setTimeStamp(LocalDateTime.now().toString());
            exceptionTOList.add(exceptionTo);
        }
        errorTO.setCode(HttpStatus.BAD_REQUEST.value());
        errorTO.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorTO.setErrors(exceptionTOList);
        return new ResponseEntity<>(errorTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleNullPointer (Exception exception, HttpServletRequest httpServletRequest){
        LOGGER.log(Level.SEVERE, ExceptionUtils.getStackTrace(exception));
        errorTO = new ErrorTO();
        exceptionTo = new ExceptionTO();
        exceptionTo.setMessage(ExceptionUtils.getMessage(exception));
        exceptionTo.setTimeStamp(LocalDateTime.now().toString());
        errorTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        errorTO.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorTO.setError(exceptionTo);
        return new ResponseEntity<>(errorTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorTO buildNotFoundError(String message){
        errorTO = new ErrorTO();
        exceptionTo = new ExceptionTO();
        exceptionTo.setMessage(message);
        exceptionTo.setTimeStamp(LocalDateTime.now().toString());
        errorTO.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        errorTO.setCode(HttpStatus.NOT_FOUND.value());
        errorTO.setError(exceptionTo);
        return errorTO;
    }

    private ErrorTO buildSameDataError(String message){
        errorTO = new ErrorTO();
        exceptionTo = new ExceptionTO();
        exceptionTo.setMessage(message);
        exceptionTo.setTimeStamp(LocalDateTime.now().toString());
        errorTO.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorTO.setCode(HttpStatus.BAD_REQUEST.value());
        errorTO.setError(exceptionTo);
        return errorTO;
    }

}
