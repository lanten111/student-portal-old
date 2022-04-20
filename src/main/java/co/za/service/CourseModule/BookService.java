package co.za.service.CourseModule;

import co.za.Exception.Exceptions.BookNotFoundException;
import co.za.dto.BookDto;
import co.za.entity.Book;
import co.za.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static co.za.service.ServiceMapper.*;

@Service
public class BookService {

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDto getBook(long id) {
        return mapToBookDto(bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id)));
    }

    public void addBooks(List<BookDto> bookDtoList) {
        for (BookDto bookDto: bookDtoList){
            Book book = mapToBook(bookDto);
            bookRepository.save(book);
        }
    }

    public void updateBook(BookDto bookDto){
        Book book = bookRepository.findById(bookDto.getId()).orElseThrow(() -> new BookNotFoundException(bookDto.getId()));
        book.setReleased(bookDto.getReleased());
        book.setBookName(bookDto.getBookName());
        book.setEdition(bookDto.getEdition());
        book.setAuthor(bookDto.getAuthor());
        book.setIsbn(bookDto.getIsbn());
        bookRepository.save(book);
    }

    public List<BookDto> getBooks() {
        return mapToBooksDto(bookRepository.findAll());
    }

    public void deleteBooks(List<BookDto> bookDtoList) {
        for (BookDto bookDto: bookDtoList){
            bookRepository.deleteById(bookDto.getId());
        }
    }
}
