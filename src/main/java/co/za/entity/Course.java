package co.za.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "course_name", nullable = false, length = 100)
    private String courseName;
    @Basic
    @Column(name = "course_code", nullable = false, length = 10)
    private String courseCode;
    @Basic
    @Column(name = "module", nullable = true)
    private Integer module;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Integer getModule() {
        return module;
    }

    public void setModule(Integer module) {
        this.module = module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && Objects.equals(courseName, course.courseName) && Objects.equals(courseCode, course.courseCode) && Objects.equals(module, course.module);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, courseCode, module);
    }
}
