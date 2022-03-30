package co.za.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class StudentCourseDto implements Serializable {
    private long id;
    private String courseName;
    private String courseCode;
    private boolean completed;
    private LocalDateTime dateCompleted;
    private LocalDateTime dateEnrolled;
    private int gpa;
    private List<StudentModuleDto> module;

    public StudentCourseDto() {
    }

    public StudentCourseDto(long id, String courseName, String courseCode, boolean completed, LocalDateTime dateCompleted, LocalDateTime dateEnrolled, int gpa, List<StudentModuleDto> module) {
        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.completed = completed;
        this.dateCompleted = dateCompleted;
        this.dateEnrolled = dateEnrolled;
        this.gpa = gpa;
        this.module = module;
    }

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

    public boolean getCompleted() {
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

    public List<StudentModuleDto> getModule() {
        return module;
    }

    public void setModule(List<StudentModuleDto> module) {
        this.module = module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourseDto entity = (StudentCourseDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.courseName, entity.courseName) &&
                Objects.equals(this.courseCode, entity.courseCode) &&
                Objects.equals(this.completed, entity.completed) &&
                Objects.equals(this.dateCompleted, entity.dateCompleted) &&
                Objects.equals(this.dateEnrolled, entity.dateEnrolled) &&
                Objects.equals(this.gpa, entity.gpa) &&
                Objects.equals(this.module, entity.module);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, courseCode, completed, dateCompleted, dateEnrolled, gpa, module);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "courseName = " + courseName + ", " +
                "courseCode = " + courseCode + ", " +
                "completed = " + completed + ", " +
                "dateCompleted = " + dateCompleted + ", " +
                "dateEnrolled = " + dateEnrolled + ", " +
                "gpa = " + gpa + ", " +
                "module = " + module + ")";
    }
}
