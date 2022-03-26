package co.za.entity;

import co.za.enums.DEPARTMENT;

import javax.persistence.*;

@Entity
public class Lecturer extends Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DEPARTMENT")
    private DEPARTMENT department;

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

}
