package co.za.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StudentModule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(name = "MODULE_ID")
    private String moduleId;

    @NotEmpty
    @Column(name = "MODULE_NAME")
    private String moduleName;

//    @NotNull
    @Column(name = "MODULE_MARK")
    private int moduleMarks;

    @Column(name = "COMPLETED")
    private boolean completed = false;

    @NotEmpty
    @Column(name = "MODULE_CODE", length = 10)
    private String moduleCode;

    @ManyToOne
    @JoinColumn(name = "LECTURER")
    private Lecturer lecturer;

    @Column(name = "MODULE_TIME", nullable = true)
    private LocalDateTime moduleTime;

    @Column(name = "MODULE_GUIDE_URL")
    private String moduleGuideUrl;

    @OneToMany
    @JoinColumn(name = "BOOK")
    private List<StudentBook> books = new ArrayList<>();


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

    public int getModuleMarks() {
        return moduleMarks;
    }

    public void setModuleMarks(int moduleMarks) {
        this.moduleMarks = moduleMarks;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public List<StudentBook> getBooks() {
        return books;
    }

    public void setBooks(List<StudentBook> books) {
        this.books = books;
    }
}
