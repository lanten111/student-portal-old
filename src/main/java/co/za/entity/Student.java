package co.za.entity;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Entity
public class Student extends Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Length(min = 10, max = 10 , message = "length must be 10 digits")
    @Column(name = "STUDENT_NUMBER")
    private String studentNumber;

    @OneToMany
    @JoinColumn(name = "COURSE")
    private List<StudentCourse> course;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public List<StudentCourse> getCourse() {
        return course;
    }

    public void setCourse(List<StudentCourse> course) {
        this.course = course;
    }
}
