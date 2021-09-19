package co.za.domain;

import javax.persistence.*;
import java.util.List;


@Entity
public class Course {

    @Id
    private Long id;
    private String name;
    private String course_code;

    @ManyToOne
    @JoinColumn(name = "module")
    private Module module;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
