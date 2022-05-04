package co.za.Controller;


import co.za.dto.BookDto;
import co.za.service.adminMOdule.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/document")
@AllArgsConstructor
public class DocumentsController {

    AdminService adminService;

    @PutMapping()
    public ResponseEntity<?> addBooks(List<BookDto> bookDtoList){
        adminService.addBooks(bookDtoList);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public ResponseEntity<?> updateBook(BookDto bookDto){
        adminService.updateBook(bookDto);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping()
    public ResponseEntity<?> deleteBooks(List<BookDto> bookDtoList){
        adminService.deleteBooks(bookDtoList);
        return ResponseEntity.ok().build();
    }

}
