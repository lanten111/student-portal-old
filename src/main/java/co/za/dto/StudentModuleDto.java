package co.za.dto;

import co.za.entity.Assignment;
import co.za.entity.StudentCourse;
import co.za.enums.SEMESTER;
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
    private String moduleId;
    private String moduleName;
    private int moduleMarks;
    private boolean completed;
    private String moduleCode;
    private LocalDateTime moduleTime;
    private String moduleGuideUrl;
    private List<StudentCourse> studentCourses;
    private List<Assignment> assignments;
    private SEMESTER semester;
    private boolean isActive;


}
