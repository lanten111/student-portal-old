package co.za.service;

import co.za.dto.*;
import co.za.entity.*;
import co.za.entity.Module;

import java.util.ArrayList;
import java.util.List;

public class ServiceMapper {

    public static Student mapToStudent(StudentDto studentDto){
        Student student = new Student();
        student.setEmail(studentDto.getEmail());
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setIdNumber(studentDto.getIdNumber());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setBirthday(studentDto.getBirthday());
        student.setDeleted(false);
        student.setGender(studentDto.getGender());
        student.setPassword(studentDto.getPassword());
        student.setAddress(mapToAddress(studentDto.getAddress()));
        return student;
    }

    public static StudentDto mapToStudentDto(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setEmail(student.getEmail());
        studentDto.setName(student.getName());
        studentDto.setSurname(student.getSurname());
        studentDto.setIdNumber(student.getIdNumber());
        studentDto.setPhoneNumber(student.getPhoneNumber());
        studentDto.setBirthday(student.getBirthday());
        studentDto.setDeleted(student.isDeleted());
        studentDto.setGender(student.getGender());
        studentDto.setPassword(student.getPassword());
        studentDto.setAddress(mapToAddress(student.getAddress()));
        return studentDto;
    }

    public static List<StudentDto> mapToStudentsDto(List<Student> students){
        List<StudentDto> studentsDto = new ArrayList<>();
        for(Student student: students){
            studentsDto.add(mapToStudentDto(student));
        }
        return studentsDto;
    }

    public static Address mapToAddress(AddressDto addressDto){
        Address address = new Address();
        address.setStreetName(addressDto.getStreetName());
        address.setZipCode(addressDto.getZipCode());
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setBuildingNumber(addressDto.getBuildingNumber());
        return  address;
    }

    public static List<CourseDto> mapToCoursesDto(List<Course> courseList){
        List<CourseDto> courseDtoList = new ArrayList<>();
        for (Course course : courseList){
            courseDtoList.add(mapToCourseDto(course));
        }
        return courseDtoList;
    }

    public static CourseDto mapToCourseDto(Course course){
        CourseDto courseDto = new CourseDto();
        List<ModuleDto> moduleDtoList = new ArrayList<>();
        for(Module module : course.getModule()){
            moduleDtoList.add(mapToModuleDto(module));
        }
        courseDto.setModule(moduleDtoList);
        courseDto.setCourseCode(course.getCourseCode());
        courseDto.setCourseName(course.getCourseName());
        return courseDto;
    }

    public static Course mapToCourse(CourseDto courseDto){
        Course course = new Course();
        course.setCourseCode(course.getCourseCode());
        course.setCourseName(course.getCourseName());
        return course;
    }

    public static List<ModuleDto> mapToModulesDto(List<Module> moduleList){
        List<ModuleDto> moduleDtoList = new ArrayList<>();
        for (Module module: moduleList){
            moduleDtoList.add(mapToModuleDto(module));
        }
        return moduleDtoList;
    }

    public static Module mapToModule(ModuleDto moduleDto){
        Module module = new Module();
        module.setModuleCode(moduleDto.getModuleCode());
        module.setModuleName(moduleDto.getModuleName());
        module.setModuleGuideUrl(moduleDto.getModuleGuideUrl());
        module.setModuleId(moduleDto.getModuleId());
        return module;
    }


    public static ModuleDto mapToModuleDto(Module module){
        ModuleDto moduleDto = new ModuleDto();
        moduleDto.setModuleId(moduleDto.getModuleId());
        moduleDto.setModuleCode(module.getModuleCode());
        moduleDto.setModuleName(module.getModuleName());
        moduleDto.setModuleTime(module.getModuleTime());
        moduleDto.setModuleGuideUrl(moduleDto.getModuleGuideUrl());
        List<BookDto> booksList = new ArrayList<>();
        for (Book book : module.getBooks()){
            booksList.add(mapToBookDto(book));
        }
        moduleDto.setBooks(booksList);
        moduleDto.setLecturer(mapToLecture(module.getLecturer()));
        return moduleDto;
    }

    public static BookDto mapToBookDto(Book book){
        BookDto bookDto = new BookDto();
        bookDto.setBookName(book.getBookName());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setEdition(book.getEdition());
        bookDto.setReleased(book.getReleased());
        bookDto.setIsbn(book.getIsbn());
        return bookDto;
    }

    public static Book mapToBook(BookDto bookDto){
        Book book = new Book();
        book.setBookName(bookDto.getBookName());
        book.setAuthor(bookDto.getAuthor());
        book.setEdition(bookDto.getEdition());
        book.setReleased(bookDto.getReleased());
        book.setIsbn(bookDto.getIsbn());
        return book;
    }

    public static List<BookDto> mapToBooksDto(List<Book> books){
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book: books){
            bookDtos.add(mapToBookDto(book));
        }
        return bookDtos;
    }

    private static LecturerDto mapToLecture(Lecturer lecturer){
        LecturerDto lecturerDto = new LecturerDto();
        lecturerDto.setBirthday(lecturer.getBirthday());
        lecturerDto.setDeleted(lecturer.isDeleted());
        lecturerDto.setName(lecturer.getName());
        lecturerDto.setBirthday(lecturer.getBirthday());
        lecturerDto.setAddress(mapToAddress(lecturer.getAddress()));
        lecturerDto.setDateCreated(lecturer.getDateCreated());
        lecturerDto.setEmail(lecturer.getEmail());
        lecturerDto.setGender(lecturer.getGender());
        lecturerDto.setPassword(lecturer.getPassword());
        lecturerDto.setIdNumber(lecturer.getIdNumber());
        lecturerDto.setPhoneNumber(lecturer.getPhoneNumber());
        lecturerDto.setSurname(lecturer.getSurname());
        lecturerDto.setDateUpdated(lecturer.getDateUpdated());
        return  lecturerDto;
    }

    private static AddressDto mapToAddress(Address address){
        AddressDto addressDto = new AddressDto();
        addressDto.setStreetName(address.getStreetName());
        addressDto.setCountry(addressDto.getCountry());
        addressDto.setCity(addressDto.getCity());
        addressDto.setBuildingNumber(address.getBuildingNumber());
        addressDto.setZipCode(addressDto.getZipCode());
        return addressDto;
    }

    private static DocumentDto mapToDocumentDto(Document document){
        DocumentDto documentDto = new DocumentDto();
        documentDto.setDocument(document.getDocument());
        documentDto.setDocumentId(document.getDocumentId());
        documentDto.setDocumentType(document.getDocumentType());
        return documentDto;
    }


    public static Document mapToDocument(DocumentDto documentDto){
        Document document = new Document();
        document.setDocument(documentDto.getDocument());
        document.setDocumentId(documentDto.getDocumentId());
        document.setDocumentType(documentDto.getDocumentType());
        return document;
    }

    public static List<DocumentDto> mapToDocumentsDto(List<Document> documents){
        List<DocumentDto> documentDtoList = new ArrayList<>();
        for (Document document: documents){
            documentDtoList.add(mapToDocumentDto(document));
        }
        return documentDtoList;
    }
}
