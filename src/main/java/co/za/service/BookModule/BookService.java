package co.za.service.BookModule;

import co.za.dto.BookDto;

import java.util.List;

public interface BookService {

    void addBooks(List<BookDto> bookDtoList);

    void updateBook(BookDto bookDto);

    void deleteBooks(List<BookDto> bookDtoList);

    List<BookDto> getBooks();

    BookDto getBook(long id);
}
