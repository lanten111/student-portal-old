package co.za.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "COURSE_NAME", nullable = false, length = 100)
    private String courseName;

    @Column(name = "COURSE_CODE", nullable = false, length = 10)
    private String courseCode;

    @OneToMany
    @JoinColumn(name = "MODULE", nullable = true)
    private List<Modules> module;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<Modules> getModule() {
        return module;
    }

    public void setModule(List<Modules> module) {
        this.module = module;
    }

}
