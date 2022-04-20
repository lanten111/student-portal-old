//package co.za.Controller;
//
//
//import co.za.dto.BookDto;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/books")
//public class BooksController {
//
//    private final CourseService<BookDto> courseService;
//
//    public BooksController(CourseService<BookDto> courseService) {
//        this.courseService = courseService;
//    }
//
//    @GetMapping("")
//    public ResponseEntity<List<BookDto>> getBooks(){
//        return ResponseEntity.ok(courseService.getList());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<BookDto> getBook(@PathVariable String id){
//        return ResponseEntity.ok(courseService.get(Long.parseLong(id)));
//    }
//
//    @PutMapping("")
//    public ResponseEntity<?> addBook(@RequestBody BookDto bookDto){
//        courseService.add(bookDto);
//        return ResponseEntity.ok().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteBook(@PathVariable String id){
//        courseService.delete(Long.parseLong(id));
//        return ResponseEntity.ok().build();
//    }
//
//}
