package co.za.Controller;


import co.za.dto.BookDto;
import co.za.service.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {

    private final Service<BookDto> service;

    public BooksController(Service<BookDto> service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<BookDto>> getBooks(){
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable String id){
        return ResponseEntity.ok(service.get(Long.parseLong(id)));
    }

    @PutMapping("")
    public ResponseEntity<?> addBook(@RequestBody BookDto bookDto){
        service.add(bookDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id){
        service.delete(Long.parseLong(id));
        return ResponseEntity.ok().build();
    }

}
