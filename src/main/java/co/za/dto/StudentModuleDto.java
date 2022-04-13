package co.za.dto;

import co.za.entity.Assignment;
import co.za.entity.StudentCourse;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class StudentModuleDto implements Serializable {
    private Long id;
    @NotEmpty
    private String moduleId;
    @NotEmpty
    private String moduleName;
    @NotEmpty
    private int moduleMarks;
    @NotEmpty
    private boolean completed;
    @NotEmpty
    private String moduleCode;
    private LocalDateTime moduleTime;
    @NotEmpty
    private String moduleGuideUrl;
    private List<StudentCourse> studentCourses;
    private List<Assignment> assignments;


}
