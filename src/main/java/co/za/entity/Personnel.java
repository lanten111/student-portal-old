package co.za.entity;

import co.za.enums.GENDER;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@Data
public class Personnel {

    @Column(unique = true)
    @NotEmpty
    @Length(min = 13, max = 13, message = "length must be 13 digits")
    private String idNumber;

    @Column()
    @NotEmpty
    private String name;

    @Column()
    @NotEmpty
    private String surname;

    @Column(unique = true)
    @NotEmpty
    private String email;

    @Column()
    @NotEmpty
    @Length(min = 10, max = 10 , message = "length must be 10 digits")
    private String phoneNumber;

    @Column()
    private LocalDateTime dateCreated;

    @Column()
    private Byte[] profilePicture;

    @NotNull
    @Column( columnDefinition = "boolean default false")
    private boolean deleted = false;

    @Column()
    @NotNull
    private LocalDateTime dateUpdated;

    @Column()
    @NotEmpty
    private String password;

    @Column()
    @NotNull
    private GENDER gender;

    @Column()
    private LocalDateTime birthday;

    @Column()
    @OneToMany
    private List<Document> documents = new ArrayList<>();

    @Column()
    @NotNull
    @Embedded
    private Address address;
}
