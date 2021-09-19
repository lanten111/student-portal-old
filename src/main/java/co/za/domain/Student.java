package co.za.domain;


import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


@Entity
public class Student {

    @Id
    private int id;

    @Column(name = "idnumber")
    private String idNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "studentnumber")
    private String studentNumber;

    @Column(name = "phonenumber")
    private Long phoneNumber;

    @ManyToOne
    @JoinColumn(name = "course")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "login")
    private Login login;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }


    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", idNumber='" + idNumber + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", course=" + course +
                ", login=" + login +
                '}';
    }
}
