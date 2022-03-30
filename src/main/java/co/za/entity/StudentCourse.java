package co.za.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "COURSE_NAME", nullable = false, length = 100)
    private String courseName;

    @Column(name = "COURSE_CODE", nullable = false, length = 10)
    private String courseCode;

    @Column(name = "COMPLETED", nullable = false, length = 10)
    private boolean completed;

    @Column(name = "DATE_COMPLETED", length = 10)
    private LocalDateTime dateCompleted;

    @Column(name = "DATE_ENROLLED", nullable = false, length = 10)
    private LocalDateTime dateEnrolled;

    @Column(name = "GPA", nullable = false, length = 10)
    private int gpa;

    @ManyToMany
    @JoinColumn(name = "MODULE", nullable = true)
    private List<StudentModule> module;

    @OneToMany
    @JoinColumn(name = "STUDENT_ID" )
    private List<Student> student;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDateTime dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public LocalDateTime getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(LocalDateTime dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public List<StudentModule> getModule() {
        return module;
    }

    public void setModule(List<StudentModule> module) {
        this.module = module;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
