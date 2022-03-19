package co.za.entity;

import com.sun.org.apache.xpath.internal.operations.Mod;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "COURSE_NAME", nullable = false, length = 100)
    private String courseName;

    @Column(name = "COURSE_CODE", nullable = false, length = 10)
    private String courseCode;

    @ManyToMany
    @JoinColumn(name = "MODULE", nullable = true)
    private List<Module> module;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public List<Module> getModule() {
        return module;
    }

    public void setModule(List<Module> module) {
        this.module = module;
    }
}
