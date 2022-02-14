package co.za.domain;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;


@Entity
public class Student extends SchoolPersonel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Length(min = 10, max = 10 , message = "length must be 10 digits")
    @Column(name = "STUDENTNUMBER")
    private String studentNumber;

    @ManyToOne
    @JoinColumn(name = "COURSE")
    private Course course;

    @OneToOne
    @NotNull
    @JoinColumn(name = "LOGIN")
    private Login login;

    public long getId() {
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
