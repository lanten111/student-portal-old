package co.za.dto;

import co.za.enums.SEMESTER;
import lombok.Data;

@Data
public class StudentResultsDto {

    private String moduleId;
    private String moduleName;
    private String moduleResults;
    private int moduleMark;
    private SEMESTER semester;
}
