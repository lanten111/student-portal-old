package co.za.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
public class CourseDto implements Serializable {
    private long id;
    private String courseName;
    private String courseCode;
    private List<ModuleDto> module;
    private LocalDateTime courseDuration;
}
