package co.za.service.CourseModule;

import co.za.Exception.Exceptions.BookNotFoundException;
import co.za.dto.BookDto;
import co.za.entity.Book;
import co.za.repository.BookRepository;
import co.za.service.Service;

import java.util.List;

import static co.za.service.ServiceMapper.*;

@org.springframework.stereotype.Service
public class BookServiceImpl implements Service<BookDto> {

    private final BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto get(long id) {
        return mapToBookDto(bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found")));
    }

    @Override
    public void add(BookDto dto) {
        Book book = mapToBook(dto);
        bookRepository.save(book);
    }

    @Override
    public List<BookDto> getList() {
        return mapToBooksDto(bookRepository.findAll());
    }

    @Override
    public int delete(long id) {
        bookRepository.deleteById(id);
        return 0;
    }
}
