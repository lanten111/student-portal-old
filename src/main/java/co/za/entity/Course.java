package co.za.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String courseName;

    @Column( nullable = false, length = 10)
    private String courseCode;

    @Column(nullable = false)
    private LocalDateTime courseDuration;

    @OneToMany
    @JoinColumn( nullable = true)
    private List<Module> module;


}
