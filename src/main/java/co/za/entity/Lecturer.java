package co.za.entity;

import co.za.enums.DEPARTMENT;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Lecturer extends Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DEPARTMENT")
    private DEPARTMENT department;

}
