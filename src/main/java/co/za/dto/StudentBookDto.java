package co.za.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class StudentBookDto implements Serializable {
    private Long id;
    private String bookName;
    private String isbn;
    private String author;
    private LocalDate released;
    private String edition;

    public StudentBookDto() {
    }

    public StudentBookDto(Long id, String bookName, String isbn, String author, LocalDate released, String edition) {
        this.id = id;
        this.bookName = bookName;
        this.isbn = isbn;
        this.author = author;
        this.released = released;
        this.edition = edition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentBookDto entity = (StudentBookDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.bookName, entity.bookName) &&
                Objects.equals(this.isbn, entity.isbn) &&
                Objects.equals(this.author, entity.author) &&
                Objects.equals(this.released, entity.released) &&
                Objects.equals(this.edition, entity.edition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, isbn, author, released, edition);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "bookName = " + bookName + ", " +
                "isbn = " + isbn + ", " +
                "author = " + author + ", " +
                "released = " + released + ", " +
                "edition = " + edition + ")";
    }
}
