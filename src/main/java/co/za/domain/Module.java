package co.za.domain;

import javax.persistence.*;

@Entity
//@Table(name="ctable")
public class Module {

    @Id
    private Long id;
    private String name;
    private String modulecode;
    private String moduletime;

    @ManyToOne
    @JoinColumn(name = "lecturer")
    private Lecturer lecturer;

//    @ManyToOne
//    @JoinColumn(name = "modulematerials")
//    private ModuleMaterials modulematerials;

    public String getModulecode() {
        return modulecode;
    }

    public void setModulecode(String modulecode) {
        this.modulecode = modulecode;
    }

    public String getModuletime() {
        return moduletime;
    }

    public void setModuletime(String moduletime) {
        this.moduletime = moduletime;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
