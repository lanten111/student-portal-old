package co.za.service.CourseModule;

import co.za.Exception.Exceptions.BookNotFoundException;
import co.za.Exception.Exceptions.LecturerNotFoundException;
import co.za.Exception.Exceptions.ModuleNotFoundException;
import co.za.dto.BookDto;
import co.za.dto.ModuleDto;
import co.za.entity.Book;
import co.za.entity.Lecturer;
import co.za.entity.Module;
import co.za.repository.BookRepository;
import co.za.repository.LecturerRepository;
import co.za.repository.ModulesRepository;
import co.za.service.Service;

import java.util.ArrayList;
import java.util.List;

import static co.za.service.ServiceMapper.*;

@org.springframework.stereotype.Service
public class ModuleServiceImpl implements Service<ModuleDto> {

    private final ModulesRepository modulesRepository;

    private final BookRepository bookRepository;

    private final LecturerRepository lecturerRepository;

    public ModuleServiceImpl(ModulesRepository modulesRepository, BookRepository bookRepository, LecturerRepository lecturerRepository) {
        this.modulesRepository = modulesRepository;
        this.bookRepository = bookRepository;
        this.lecturerRepository = lecturerRepository;
    }

    @Override
    public List<ModuleDto> getList(){
        return mapToModulesDto(modulesRepository.findAll());
    }

    @Override
    public ModuleDto get(long id){
        return mapToModuleDto(modulesRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Module not found")));
    }

    @Override
    public void add(ModuleDto moduleDto){
        List<Book> bookList = new ArrayList<>();
        for (BookDto book: moduleDto.getBooks()){
            Book books = bookRepository.findById(book.getId()).orElseThrow(() -> new ModuleNotFoundException("selected book does not exist"));
            bookRepository.save(books);
            bookList.add(books);
        }
        Lecturer lecturer = lecturerRepository.findById(moduleDto.getLecturer().getId()).orElseThrow(() -> new LecturerNotFoundException("Selected Lecturer does not exist"));
        Module module = mapToModule(moduleDto);
        module.setBooks(bookList);
        module.setLecturer(lecturer);
        modulesRepository.save(module);
    }

    @Override
    public int delete(long id){
        modulesRepository.deleteById(id);
        return 0;
    }
}
