package co.za.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="ctable")
public class Module {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    private String moduleId;
    private String name;
    private String moduleCode;
    private int lecturer;
    private String moduleTime;
    private int moduleMaterials;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public int getLecturer() {
        return lecturer;
    }

    public void setLecturer(int lecturer) {
        this.lecturer = lecturer;
    }

    public String getModuleTime() {
        return moduleTime;
    }

    public void setModuleTime(String moduleTime) {
        this.moduleTime = moduleTime;
    }

    public int getModuleMaterials() {
        return moduleMaterials;
    }

    public void setModuleMaterials(int moduleMaterials) {
        this.moduleMaterials = moduleMaterials;
    }
}
