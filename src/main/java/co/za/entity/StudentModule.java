package co.za.entity;

import co.za.enums.SEMESTER;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class StudentModule extends Module {

    @Column()
    private int moduleMarks;

    @Column()
    private boolean completed = false;

    @Column()
    private String moduleGuideUrl;

    @Column
    private SEMESTER semester;

    @JoinColumn()
    @OneToMany
    private List<Book> books = new ArrayList<>();

    @JoinColumn
    @ManyToMany
    private List<StudentCourse> studentCourses;

    @JoinColumn()
    @OneToMany
    private List<Assignment> assignments = new ArrayList<>();

    @Column(nullable = false)
    private boolean isActive;


}
