package co.za.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ModuleMaterials {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    private String moduleGuide;
    private String bookName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModuleGuide() {
        return moduleGuide;
    }

    public void setModuleGuide(String moduleGuide) {
        this.moduleGuide = moduleGuide;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
