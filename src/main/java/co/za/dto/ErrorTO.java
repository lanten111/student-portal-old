package co.za.dto;

import java.util.List;

public class ErrorTO {

    private String status;
    private int code;
    private List<ExceptionTO> errors;

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

    public List<ExceptionTO> getError() {
        return errors;
    }

    public void setError(List<ExceptionTO> error) {
        this.errors = error;
    }
}
