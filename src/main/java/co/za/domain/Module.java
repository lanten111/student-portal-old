package co.za.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Module {
    private int id;
    private String moduleid;
    private String modulename;
    private String modulecode;
    private Integer lecturer;
    private Date moduletime;
    private Integer course;
    private Integer modulematerials;

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
    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid;
    }

    @Basic
    @Column(name = "modulename", nullable = true, length = 100)
    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename;
    }

    @Basic
    @Column(name = "modulecode", nullable = true, length = 10)
    public String getModulecode() {
        return modulecode;
    }

    public void setModulecode(String modulecode) {
        this.modulecode = modulecode;
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
    public Date getModuletime() {
        return moduletime;
    }

    public void setModuletime(Date moduletime) {
        this.moduletime = moduletime;
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
    public Integer getModulematerials() {
        return modulematerials;
    }

    public void setModulematerials(Integer modulematerials) {
        this.modulematerials = modulematerials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return id == module.id && Objects.equals(moduleid, module.moduleid) && Objects.equals(modulename, module.modulename) && Objects.equals(modulecode, module.modulecode) && Objects.equals(lecturer, module.lecturer) && Objects.equals(moduletime, module.moduletime) && Objects.equals(course, module.course) && Objects.equals(modulematerials, module.modulematerials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moduleid, modulename, modulecode, lecturer, moduletime, course, modulematerials);
    }
}
