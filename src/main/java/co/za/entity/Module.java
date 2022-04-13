package co.za.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
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

    @Column(name = "MODULE_ACTIVE", nullable = false)
    private boolean isActive;

    @NotEmpty
    @Column(name = "MODULE_GUIDE_URL")
    private String moduleGuideUrl;

    @OneToMany
    @JoinColumn(name = "BOOK")
    private List<Book> books = new ArrayList<>();


}
