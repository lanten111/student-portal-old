package co.za.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class DocumentDto {
    private Long id;
    private String documentId;
    private String documentType;
    private Byte[] document;
    private long studentId;
}
