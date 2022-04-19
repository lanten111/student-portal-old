package co.za.service.CourseModule;

import co.za.Exception.Exceptions.BookNotFoundException;
import co.za.dto.BookDto;
import co.za.entity.Book;
import co.za.repository.BookRepository;

import java.util.List;

import static co.za.service.ServiceMapper.*;

@org.springframework.stereotype.Service
public class BookServiceImpl {

    private final BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository) {
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

    public List<BookDto> getBooks() {
        return mapToBooksDto(bookRepository.findAll());
    }

    public void deleteBooks(List<BookDto> bookDtoList) {
        for (BookDto bookDto: bookDtoList){
            bookRepository.deleteById(bookDto.getId());
        }
    }
}
