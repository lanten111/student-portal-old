package co.za.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lecturer extends SchoolPersonnel {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
