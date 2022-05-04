package co.za.service.modulesModule;

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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static co.za.service.ServiceMapper.*;

@Service
public class ModuleServiceImpl {

    private final ModulesRepository modulesRepository;

    private final BookRepository bookRepository;

    private final LecturerRepository lecturerRepository;

    public ModuleServiceImpl(ModulesRepository modulesRepository, BookRepository bookRepository, LecturerRepository lecturerRepository) {
        this.modulesRepository = modulesRepository;
        this.bookRepository = bookRepository;
        this.lecturerRepository = lecturerRepository;
    }


    public List<ModuleDto> getModules(){
        return mapToModulesDto(modulesRepository.findAll());
    }

    public ModuleDto getModule(long id){
        return mapToModuleDto(modulesRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id)));
    }

    public void addModules(List<ModuleDto> moduleDtoList){
        for (ModuleDto moduleDto: moduleDtoList){
            List<Book> bookList = new ArrayList<>();
            for (BookDto book: moduleDto.getBooks()){
                Book books = bookRepository.findById(book.getId()).orElseThrow(() -> new ModuleNotFoundException(moduleDto.getId()));
                bookRepository.save(books);
                bookList.add(books);
            }
            Lecturer lecturer = lecturerRepository.findById(moduleDto.getId()).orElseThrow(() -> new LecturerNotFoundException(moduleDto.getId()));
            Module module = mapToModule(moduleDto);
            module.setBooks(bookList);
            module.setLecturer(lecturer);
            modulesRepository.save(module);
        }
    }

    public void updateModule(ModuleDto moduleDto){
        Module module = modulesRepository.findById(moduleDto.getId()).orElseThrow(() -> new ModuleNotFoundException(moduleDto.getId()));
        module.setModuleName(moduleDto.getModuleName());
        module.setModuleId(moduleDto.getModuleId());
        module.setModuleCode(moduleDto.getModuleCode());
        module.setModuleTime(moduleDto.getModuleTime());
        module.setModuleGuideUrl(moduleDto.getModuleGuideUrl());


    }

    public void delete(long id){
        modulesRepository.deleteById(id);
    }
}
