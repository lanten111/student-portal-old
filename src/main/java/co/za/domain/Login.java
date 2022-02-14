package co.za.domain;

import org.hibernate.validator.constraints.Length;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotEmpty
    private String username;

    @NotEmpty
    @Length(min = 4, max = 16)
    @Column
    private String password;

    @Column
    private Date lastlogin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }
}


