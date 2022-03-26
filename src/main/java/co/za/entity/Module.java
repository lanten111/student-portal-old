package co.za.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(name = "MODULE_ID")
    private String moduleId;

    @NotEmpty
    @Column(name = "MODULE_NAME")
    private String moduleName;

    @NotEmpty
    @Column(name = "MODULE_CODE", length = 10)
    private String moduleCode;

    @ManyToOne
    @JoinColumn(name = "LECTURER")
    private Lecturer lecturer;

    @Column(name = "MODULE_TIME", nullable = true)
    private LocalDateTime moduleTime;

    @NotEmpty
    @Column(name = "MODULE_GUIDE_URL")
    private String moduleGuideUrl;

    @OneToMany
    @JoinColumn(name = "BOOK")
    private List<Book> books = new ArrayList<>();


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

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
