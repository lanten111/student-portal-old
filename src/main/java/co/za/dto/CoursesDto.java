package co.za.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CoursesDto implements Serializable {
    private String courseName;
    private String courseCode;
    private List<ModulesDto> module;

    public CoursesDto() {
    }

    public CoursesDto(String courseName, String courseCode, List<ModulesDto> module) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.module = module;
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

    public List<ModulesDto> getModule() {
        return module;
    }

    public void setModule(List<ModulesDto> module) {
        this.module = module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursesDto entity = (CoursesDto) o;
        return Objects.equals(this.courseName, entity.courseName) &&
                Objects.equals(this.courseCode, entity.courseCode) &&
                Objects.equals(this.module, entity.module);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, courseCode, module);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "courseName = " + courseName + ", " +
                "courseCode = " + courseCode + ", " +
                "module = " + module + ")";
    }
}
