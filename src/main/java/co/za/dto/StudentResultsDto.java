package co.za.dto;

public class StudentResultsDto {

    private String moduleId;
    private String moduleName;
    private String moduleResults;
    private int moduleMark;

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleResults() {
        return moduleResults;
    }

    public void setModuleResults(String moduleResults) {
        this.moduleResults = moduleResults;
    }

    public int getModuleMark() {
        return moduleMark;
    }

    public void setModuleMark(int moduleMark) {
        this.moduleMark = moduleMark;
    }
}
