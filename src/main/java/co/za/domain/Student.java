package co.za.domain;


import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


@Entity
public class Student extends SchoolPersonel {

    @Id
    private int id;

    @Column(name = "studentnumber")
    private String studentNumber;

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

}
