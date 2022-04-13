package co.za.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "COURSE_NAME", nullable = false, length = 100)
    private String courseName;

    @Column(name = "COURSE_CODE", nullable = false, length = 10)
    private String courseCode;

    @Column(name = "COURSE_DURATION", nullable = false)
    private LocalDateTime courseDuration;

    @OneToMany
    @JoinColumn(name = "MODULE", nullable = true)
    private List<Module> module;


}
