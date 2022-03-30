package co.za.dto;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

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

    public StudentModuleDto() {
    }

    public StudentModuleDto(Long id, String moduleId, String moduleName, int moduleMarks, boolean completed, String moduleCode, LocalDateTime moduleTime, String moduleGuideUrl) {
        this.id = id;
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.moduleMarks = moduleMarks;
        this.completed = completed;
        this.moduleCode = moduleCode;
        this.moduleTime = moduleTime;
        this.moduleGuideUrl = moduleGuideUrl;
    }

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

    public int getModuleMarks() {
        return moduleMarks;
    }

    public void setModuleMarks(int moduleMarks) {
        this.moduleMarks = moduleMarks;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public LocalDateTime getModuleTime() {
        return moduleTime;
    }

    public void setModuleTime(LocalDateTime moduleTime) {
        this.moduleTime = moduleTime;
    }

    public String getModuleGuideUrl() {
        return moduleGuideUrl;
    }

    public void setModuleGuideUrl(String moduleGuideUrl) {
        this.moduleGuideUrl = moduleGuideUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentModuleDto entity = (StudentModuleDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.moduleId, entity.moduleId) &&
                Objects.equals(this.moduleName, entity.moduleName) &&
                Objects.equals(this.moduleMarks, entity.moduleMarks) &&
                Objects.equals(this.completed, entity.completed) &&
                Objects.equals(this.moduleCode, entity.moduleCode) &&
                Objects.equals(this.moduleTime, entity.moduleTime) &&
                Objects.equals(this.moduleGuideUrl, entity.moduleGuideUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moduleId, moduleName, moduleMarks, completed, moduleCode, moduleTime, moduleGuideUrl);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "moduleId = " + moduleId + ", " +
                "moduleName = " + moduleName + ", " +
                "moduleMarks = " + moduleMarks + ", " +
                "completed = " + completed + ", " +
                "moduleCode = " + moduleCode + ", " +
                "moduleTime = " + moduleTime + ", " +
                "moduleGuideUrl = " + moduleGuideUrl + ")";
    }
}
