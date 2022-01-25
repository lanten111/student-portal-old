package co.za.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lecturer extends SchoolPersonel {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
