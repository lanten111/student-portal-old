package co.za.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Module {
    private int id;
    private String moduleId;
    private String moduleName;
    private String moduleCode;
    private Integer lecturer;
    private LocalDateTime moduleTime;
    private Integer course;
    private Integer moduleMaterials;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "moduleid", nullable = true, length = 100)
    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleid) {
        this.moduleId = moduleid;
    }

    @Basic
    @Column(name = "modulename", nullable = true, length = 100)
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String modulename) {
        this.moduleName = modulename;
    }

    @Basic
    @Column(name = "modulecode", nullable = true, length = 10)
    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String modulecode) {
        this.moduleCode = modulecode;
    }

    @Basic
    @Column(name = "lecturer", nullable = true)
    public Integer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Integer lecturer) {
        this.lecturer = lecturer;
    }

    @Basic
    @Column(name = "moduletime", nullable = true)
    public LocalDateTime getModuleTime() {
        return moduleTime;
    }

    public void setModuleTime(LocalDateTime moduletime) {
        this.moduleTime = moduletime;
    }

    @Basic
    @Column(name = "course", nullable = true)
    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    @Basic
    @Column(name = "modulematerials", nullable = true)
    public Integer getModuleMaterials() {
        return moduleMaterials;
    }

    public void setModuleMaterials(Integer modulematerials) {
        this.moduleMaterials = modulematerials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return id == module.id && Objects.equals(moduleId, module.moduleId) && Objects.equals(moduleName, module.moduleName) && Objects.equals(moduleCode, module.moduleCode) && Objects.equals(lecturer, module.lecturer) && Objects.equals(moduleTime, module.moduleTime) && Objects.equals(course, module.course) && Objects.equals(moduleMaterials, module.moduleMaterials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moduleId, moduleName, moduleCode, lecturer, moduleTime, course, moduleMaterials);
    }
}
