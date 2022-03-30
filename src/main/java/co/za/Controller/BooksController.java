package co.za.Controller;


import co.za.dto.BooksDto;
import co.za.dto.CoursesDto;
import co.za.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public ResponseEntity<List<BooksDto>> getBooks(){
        return ResponseEntity.ok(bookService.getBooks());
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BooksDto> getCourse(@PathVariable String id){
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @PutMapping("/add-book")
    public ResponseEntity<?> addNewCourse(@RequestBody CoursesDto coursesDto){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable String id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

}
