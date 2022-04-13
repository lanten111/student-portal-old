package co.za.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CourseDto implements Serializable {
    private long id;
    private String courseName;
    private String courseCode;
    private List<ModuleDto> module;

    public CourseDto() {
    }

    public CourseDto(long id, String courseName, String courseCode, List<ModuleDto> module) {
        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
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

    public List<ModuleDto> getModule() {
        return module;
    }

    public void setModule(List<ModuleDto> module) {
        this.module = module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseDto entity = (CourseDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.courseName, entity.courseName) &&
                Objects.equals(this.courseCode, entity.courseCode) &&
                Objects.equals(this.module, entity.module);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, courseCode, module);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "courseName = " + courseName + ", " +
                "courseCode = " + courseCode + ", " +
                "module = " + module + ")";
    }
}
