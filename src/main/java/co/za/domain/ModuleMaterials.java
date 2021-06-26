package co.za.domain;

import com.itextpdf.text.Document;

public class ModuleMaterials {

    private Document moduleGuide;
    private String bookName;

    public Document getModuleGuide() {
        return moduleGuide;
    }

    public void setModuleGuide(Document moduleGuide) {
        this.moduleGuide = moduleGuide;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
