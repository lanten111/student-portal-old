package co.za.dto;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModuleDto implements Serializable {
    private Long id;
    @NotEmpty
    private String moduleId;
    @NotEmpty
    private String moduleName;
    @NotEmpty
    private String moduleCode;
    private LecturerDto lecturer;
    private LocalDateTime moduleTime;
    @NotEmpty
    private String moduleGuideUrl;
    private List<BookDto> books = new ArrayList<>();

    public ModuleDto() {
    }

    public ModuleDto(Long id, String moduleId, String moduleName, String moduleCode, LecturerDto lecturer, LocalDateTime moduleTime, String moduleGuideUrl, List<BookDto> books) {
        this.id = id;
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
        this.lecturer = lecturer;
        this.moduleTime = moduleTime;
        this.moduleGuideUrl = moduleGuideUrl;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public LecturerDto getLecturer() {
        return lecturer;
    }

    public void setLecturer(LecturerDto lecturer) {
        this.lecturer = lecturer;
    }

    public LocalDateTime getModuleTime() {
        return moduleTime;
    }

    public void setModuleTime(LocalDateTime moduleTime) {
        this.moduleTime = moduleTime;
    }

    public String getModuleGuideUrl() {
        return moduleGuideUrl;
    }

    public void setModuleGuideUrl(String moduleGuideUrl) {
        this.moduleGuideUrl = moduleGuideUrl;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModuleDto entity = (ModuleDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.moduleId, entity.moduleId) &&
                Objects.equals(this.moduleName, entity.moduleName) &&
                Objects.equals(this.moduleCode, entity.moduleCode) &&
                Objects.equals(this.lecturer, entity.lecturer) &&
                Objects.equals(this.moduleTime, entity.moduleTime) &&
                Objects.equals(this.moduleGuideUrl, entity.moduleGuideUrl) &&
                Objects.equals(this.books, entity.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moduleId, moduleName, moduleCode, lecturer, moduleTime, moduleGuideUrl, books);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "moduleId = " + moduleId + ", " +
                "moduleName = " + moduleName + ", " +
                "moduleCode = " + moduleCode + ", " +
                "lecturer = " + lecturer + ", " +
                "moduleTime = " + moduleTime + ", " +
                "moduleGuideUrl = " + moduleGuideUrl + ", " +
                "books = " + books + ")";
    }
}
