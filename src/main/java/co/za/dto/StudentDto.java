package co.za.dto;

import co.za.enums.GENDER;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class StudentDto implements Serializable {
    @NotEmpty
    @Length(min = 13, max = 13, message = "length must be 13 digits")
    private String idNumber;
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @NotEmpty
    private String email;
    @NotEmpty
    @Length(min = 10, max = 10, message = "length must be 10 digits")
    private String phoneNumber;
    private LocalDateTime dateCreated;
    @NotNull
    private boolean deleted = false;
    @NotNull
    private LocalDateTime dateUpdated;
    @NotEmpty
    private String password;
    @NotEmpty
    private GENDER gender;
    @NotNull
    private LocalDateTime birthday;
    @NotEmpty
    private AddressDto address;
    private long id;
    @NotEmpty
    @Length(min = 10, max = 10, message = "length must be 10 digits")
    private String studentNumber;
    private long courseId;

    public StudentDto() {
    }

    public StudentDto(String idNumber, String name, String surname, String email, String phoneNumber, LocalDateTime dateCreated, boolean deleted, LocalDateTime dateUpdated, String password, GENDER gender, LocalDateTime birthday, AddressDto address, long id, String studentNumber, long course) {
        this.idNumber = idNumber;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateCreated = dateCreated;
        this.deleted = deleted;
        this.dateUpdated = dateUpdated;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.id = id;
        this.studentNumber = studentNumber;
        this.courseId = course;
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

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean getDeleted() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

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

    public boolean isDeleted() {
        return deleted;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto entity = (StudentDto) o;
        return Objects.equals(this.idNumber, entity.idNumber) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.surname, entity.surname) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.phoneNumber, entity.phoneNumber) &&
                Objects.equals(this.dateCreated, entity.dateCreated) &&
                Objects.equals(this.deleted, entity.deleted) &&
                Objects.equals(this.dateUpdated, entity.dateUpdated) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.gender, entity.gender) &&
                Objects.equals(this.birthday, entity.birthday) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.id, entity.id) &&
                Objects.equals(this.studentNumber, entity.studentNumber) &&
                Objects.equals(this.courseId, entity.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber, name, surname, email, phoneNumber, dateCreated, deleted, dateUpdated, password, gender, birthday, address, id, studentNumber, courseId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "idNumber = " + idNumber + ", " +
                "name = " + name + ", " +
                "surname = " + surname + ", " +
                "email = " + email + ", " +
                "phoneNumber = " + phoneNumber + ", " +
                "dateCreated = " + dateCreated + ", " +
                "deleted = " + deleted + ", " +
                "dateUpdated = " + dateUpdated + ", " +
                "password = " + password + ", " +
                "gender = " + gender + ", " +
                "birthday = " + birthday + ", " +
                "address = " + address + ", " +
                "id = " + id + ", " +
                "studentNumber = " + studentNumber + ", " +
                "course = " + courseId + ")";
    }
}
