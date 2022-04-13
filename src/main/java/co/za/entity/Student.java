package co.za.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Entity
@Data
public class Student extends Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NotEmpty
    @Length(min = 10, max = 10 , message = "length must be 10 digits")
    private String studentNumber;

    @Column
    private Boolean registered;

    @Column
    @OneToMany
    private List<StudentCourse> studentCourses;

    @Column
    @OneToMany
    private List<Assignment> assignments;
}
