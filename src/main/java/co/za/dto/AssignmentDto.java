package co.za.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentDto implements Serializable {
    private Long id;
    private String moduleId;
    private String lecturer;
    private List<DocumentDto> documents;
    private StudentDto student;
}
