package co.za.dto;

import co.za.entity.Assignment;
import co.za.entity.StudentCourse;
import co.za.enums.GENDER;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
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
    private Byte[] profilePicture;
    @NotEmpty
    @Length(min = 10, max = 10, message = "length must be 10 digits")
    private String studentNumber;
    private long courseId;
    private List<Assignment> assignments;
    private List<StudentCourse> studentCourses;

}
