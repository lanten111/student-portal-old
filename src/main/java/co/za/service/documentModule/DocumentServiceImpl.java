package co.za.service.documentModule;

import co.za.dto.DocumentDto;
import co.za.entity.Document;
import co.za.repository.DocumentRepository;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

import static co.za.service.ServiceMapper.*;

@AllArgsConstructor
public class DocumentServiceImpl {

    private final DocumentRepository documentRepository;

    public void uploadDocuments(List<DocumentDto> documentDtoList){
        List<Document> documents = mapToDocuments(documentDtoList);
        documentRepository.saveAll(documents);
    }

    public void deleteDocument(long id){
        documentRepository.deleteById(id);
    }

    public List<DocumentDto> getDocumentsByUser(long userId){
        List<Document> documents = documentRepository.findAllById(Collections.singletonList(userId));
        return mapToDocumentsDto(documents);
    }

    public DocumentDto getDocumentDto(long id){
        return mapToDocumentDto(documentRepository.findById(id).orElseThrow(() -> new RuntimeException("s")));
    }
}
