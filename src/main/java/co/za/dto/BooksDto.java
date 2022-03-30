package co.za.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class BooksDto implements Serializable {
    private String bookName;
    private String isbn;
    private String author;
    private LocalDate released;
    private String edition;

    public BooksDto() {
    }

    public BooksDto(String bookName, String isbn, String author, LocalDate released, String edition) {
        this.bookName = bookName;
        this.isbn = isbn;
        this.author = author;
        this.released = released;
        this.edition = edition;
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
        BooksDto entity = (BooksDto) o;
        return Objects.equals(this.bookName, entity.bookName) &&
                Objects.equals(this.isbn, entity.isbn) &&
                Objects.equals(this.author, entity.author) &&
                Objects.equals(this.released, entity.released) &&
                Objects.equals(this.edition, entity.edition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, isbn, author, released, edition);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "bookName = " + bookName + ", " +
                "isbn = " + isbn + ", " +
                "author = " + author + ", " +
                "released = " + released + ", " +
                "edition = " + edition + ")";
    }
}
