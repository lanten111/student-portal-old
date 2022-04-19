package co.za.entity;

import co.za.enums.SEMESTER;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class StudentCourse extends Course {

    @Column(nullable = false, length = 10)
    private boolean completed;

    @Column(length = 10)
    private LocalDateTime dateCompleted;

    @Column( nullable = false, length = 10)
    private LocalDateTime dateEnrolled;

    @Column(nullable = false, length = 10)
    private int gpa;

    @ManyToOne
    @JoinColumn()
    private Student student;

    @Column
    private SEMESTER semester;

    @ManyToMany
    @JoinColumn( nullable = true)
    private List<StudentModule> studentModules;

}
