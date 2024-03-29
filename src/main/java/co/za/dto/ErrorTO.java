package co.za.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorTO {

    private String status;
    private int code;
    private List<ExceptionTO> errors;
    private ExceptionTO error;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ExceptionTO> getErrors() {
        return errors;
    }

    public void setErrors(List<ExceptionTO> errors) {
        this.errors = errors;
    }

    public ExceptionTO getError() {
        return error;
    }

    public void setError(ExceptionTO error) {
        this.error = error;
    }
}
