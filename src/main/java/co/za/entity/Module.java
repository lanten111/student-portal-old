package co.za.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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


}
