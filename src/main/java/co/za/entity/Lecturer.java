package co.za.entity;

import co.za.enums.DEPARTMENT;

import javax.persistence.*;
import java.util.List;

@Entity
public class Lecturer extends SchoolPersonnel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DEPARTMENT")
    private DEPARTMENT department;

    @OneToMany
    @JoinColumn(name = "MODULE")
    private List<Lecturer> lecture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DEPARTMENT getDepartment() {
        return department;
    }

    public void setDepartment(DEPARTMENT department) {
        this.department = department;
    }

    public List<Lecturer> getLecture() {
        return lecture;
    }

    public void setLecture(List<Lecturer> lecture) {
        this.lecture = lecture;
    }
}
