package co.za.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "BOOK_NAMAE")
    private String bookName;

    @Column(name = "IDBN")
    private String isbn;

    @Column(name = "AUTHROS")
    private String author;

    @Column(name = "RELEASED")
    private LocalDate released;

    @Column(name = "EDITION")
    private String edition;

}
