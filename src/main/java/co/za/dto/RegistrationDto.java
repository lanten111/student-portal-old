package co.za.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegistrationDto {

    private long studentId;
    private String studentNumber;
    private LocalDateTime yearOfStudy;
    private Long CourseId;
    private String campus;

}
