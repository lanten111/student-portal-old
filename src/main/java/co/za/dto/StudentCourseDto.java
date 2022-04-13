package co.za.dto;

import co.za.entity.Student;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
public class StudentCourseDto implements Serializable {
    private long id;
    private String courseName;
    private String courseCode;
    private boolean completed;
    private LocalDateTime dateCompleted;
    private LocalDateTime dateEnrolled;
    private int gpa;
    private List<StudentModuleDto> module;
    private Student student;
}
