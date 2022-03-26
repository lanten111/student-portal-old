package co.za.response;

import co.za.entity.Course;
import co.za.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseResponse {

    private String status;
    private int code;
    private List<Course> datas;

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

    public List<Course> getDatas() {
        return datas;
    }

    public void setDatas(List<Course> datas) {
        this.datas = datas;
    }
}
