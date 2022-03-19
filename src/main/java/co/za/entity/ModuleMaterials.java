package co.za.entity;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;

@Entity
public class ModuleMaterials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "MODULE_CODE")
    private String moduleGuideUrl;

    @Column(name = "BOOK_NAME")
    private String bookName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModuleGuideUrl() {
        return moduleGuideUrl;
    }

    public void setModuleGuideUrl(String moduleGuideUrl) {
        this.moduleGuideUrl = moduleGuideUrl;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
