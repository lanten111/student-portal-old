package co.za.Controller;


import co.za.dto.BookDto;
import co.za.dto.DocumentDto;
import co.za.service.BookModule.BookService;
import co.za.service.adminMOdule.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {

    BookService bookService;

    @GetMapping()
    public ResponseEntity<BookDto> getBook(long id){
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookDto>> getBooks(){
        return ResponseEntity.ok(bookService.getBooks());
    }

    @PutMapping()
    public ResponseEntity<?> addBooks(List<BookDto> bookDtoList){
        bookService.addBooks(bookDtoList);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteDocument(List<BookDto> bookDtoList){
        bookService.deleteBooks(bookDtoList);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> updateBook(BookDto bookDto){
        bookService.updateBook(bookDto);
        return ResponseEntity.ok().build();
    }

}
