package co.za.entity;

import co.za.enums.GENDER;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@MappedSuperclass
public class SchoolPersonnel {

    @NotEmpty
    @Length(min = 13, max = 13, message = "length must be 13 digits")
    @Column(name = "ID_NUMBER", unique = true)
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
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "DATE_CREATED")
    private LocalDateTime dateCreated;

    @NotNull
    @Column(name = "DELETED", columnDefinition = "boolean default false")
    private boolean deleted = false;

    @NotNull
    @Column(name = "DATE_UPDATED")
    private LocalDateTime dateUpdated;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "GENDER")
    private GENDER gender;

//    @NotNull
    @Column(name = "BIRTHDAY")
    private LocalDateTime birthday;

    @JoinColumn(name = "ADDRESS")
    @OneToOne(fetch = FetchType.EAGER)
    private Address address;

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
