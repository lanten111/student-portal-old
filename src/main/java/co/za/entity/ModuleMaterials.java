package co.za.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ModuleMaterials {

    @Id
    private Long id;
//    private String moduleguide;
    private String bookName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookname() {
        return bookName;
    }

    public void setBookname(String bookname) {
        this.bookName = bookname;
    }
}
