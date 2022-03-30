package co.za.service;

import co.za.dto.BooksDto;
import co.za.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static co.za.service.TransferService.transferBook;
import static co.za.service.TransferService.transferBooks;

@Service
public class BookService {

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BooksDto> getBooks(){
        return transferBooks(bookRepository.findAll());
    }

    public BooksDto getBook(String id){
        return transferBook(bookRepository.getOne(Long.parseLong(id)));
    }

    public void addBook(BooksDto booksDto){

    }

    public void deleteBook(String id){
        bookRepository.deleteById(Long.parseLong(id));
    }
}
