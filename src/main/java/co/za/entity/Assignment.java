package co.za.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column()
    private String moduleId;

    @Column()
    private String lecturer;

    @Column()
    @OneToMany
    private List<Document> documents;

    @JoinColumn
    @ManyToOne
    private Student student;
}
