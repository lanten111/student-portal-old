package co.za.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(name = "MODULE_ID")
    private String moduleId;

    @NotEmpty
    @Column(name = "MODULE_NAME")
    private String moduleName;

    @NotEmpty
    @Column(name = "MODULE_CODE", length = 10)
    private String moduleCode;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "LECTURE")
    private Lecturer lecturer;

    @NotEmpty
    @Column(name = "MODULE_TIME", nullable = true)
    private LocalDateTime moduleTime;

    @NotEmpty
    @JoinColumn(name = "COURSE_ID")
    private Long courseId;

    @NotEmpty
    @OneToMany
    @JoinColumn(name = "MODULE_MATERIALS_ID", nullable = true)
    private List<ModuleMaterials> moduleMaterialId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public LocalDateTime getModuleTime() {
        return moduleTime;
    }

    public void setModuleTime(LocalDateTime moduleTime) {
        this.moduleTime = moduleTime;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public List<ModuleMaterials> getModuleMaterialId() {
        return moduleMaterialId;
    }

    public void setModuleMaterialId(List<ModuleMaterials> moduleMaterialId) {
        this.moduleMaterialId = moduleMaterialId;
    }


}
