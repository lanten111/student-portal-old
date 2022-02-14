package co.za.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@MappedSuperclass
public class SchoolPersonel {

    @NotEmpty
    @Length(min = 13, max = 13, message = "length must be 13 digits")
    @Column(name = "IDNUMBER", unique = true)
    private String idNumber;

    @NotEmpty
    @Column(name = "NAME")
    private String name;

    @NotEmpty
    @Column(name = "SURNAME")
    private String surname;

    @NotEmpty
    @Column(name = "EMAIL", unique = true)
    private String email;

    @NotEmpty
    @Length(min = 10, max = 10 , message = "length must be 10 digits")
    @Column(name = "PHONENUMBER")
    private String phoneNumber;

    @Column(name = "DATE_CREATED")
    private LocalDateTime dateCreated;

    @NotNull
    @Column(name = "DELETED", columnDefinition = "boolean default false")
    private boolean deleted = false;

    @Column(name = "DATE_UPDATED")
    private LocalDateTime dateUpdated;

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
