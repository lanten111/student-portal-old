package co.za.service;

import co.za.dto.*;
import co.za.entity.*;

import java.util.ArrayList;
import java.util.List;

public class TransferService {

    public static Student transferStudent(StudentDto studentDto){
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
        student.setAddress(transferAddress(studentDto.getAddress()));
        return student;
    }

    public static Address transferAddress(AddressDto addressDto){
        Address address = new Address();
        address.setStreetName(addressDto.getStreetName());
        address.setZipCode(addressDto.getZipCode());
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setBuildingNumber(addressDto.getBuildingNumber());
        return  address;
    }

    public static List<CoursesDto> transferCourses(List<Courses> coursesList){
        List<CoursesDto> courseDtoList = new ArrayList<>();
        for (Courses courses: coursesList){
            courseDtoList.add(transferCourse(courses));
        }
        return courseDtoList;
    }

    public static CoursesDto transferCourse(Courses courses){
        CoursesDto courseDto = new CoursesDto();
        List<ModulesDto> moduleDtoList = new ArrayList<>();
        for(Modules modules: courses.getModule()){
            moduleDtoList.add(transferModule(modules));
        }
        courseDto.setModule(moduleDtoList);
        courseDto.setCourseCode(courses.getCourseCode());
        courseDto.setCourseName(courses.getCourseName());
        return courseDto;
    }

    public static ModulesDto transferModule(Modules modules){
        ModulesDto moduleDto = new ModulesDto();
        moduleDto.setModuleId(moduleDto.getModuleId());
        moduleDto.setModuleCode(modules.getModuleCode());
        moduleDto.setModuleName(modules.getModuleName());
        moduleDto.setModuleTime(modules.getModuleTime());
        moduleDto.setModuleGuideUrl(moduleDto.getModuleGuideUrl());
        List<BooksDto> booksList = new ArrayList<>();
        for (Books books: modules.getBooks()){
            booksList.add(transferBook(books));
        }
        moduleDto.setBooks(booksList);
        moduleDto.setLecturer(transferLecture(modules.getLecturer()));
        return moduleDto;
    }

    public static BooksDto transferBook(Books books){
        BooksDto bookDto = new BooksDto();
        bookDto.setBookName(books.getBookName());
        bookDto.setAuthor(books.getAuthor());
        bookDto.setEdition(books.getEdition());
        bookDto.setReleased(books.getReleased());
        bookDto.setIsbn(books.getIsbn());
        return bookDto;
    }

    public static List<BooksDto> transferBooks(List<Books> books){
        List<BooksDto> booksDtos = new ArrayList<>();
        for (Books book: books){
            booksDtos.add(transferBook(book));
        }
        return booksDtos;
    }

    private static LecturerDto transferLecture(Lecturer lecturer){
        LecturerDto lecturerDto = new LecturerDto();
        lecturerDto.setBirthday(lecturer.getBirthday());
        lecturerDto.setDeleted(lecturer.isDeleted());
        lecturerDto.setName(lecturer.getName());
        lecturerDto.setBirthday(lecturer.getBirthday());
        lecturerDto.setAddress(transferAddress(lecturer.getAddress()));
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

    private static AddressDto transferAddress(Address address){
        AddressDto addressDto = new AddressDto();
        addressDto.setStreetName(address.getStreetName());
        addressDto.setCountry(addressDto.getCountry());
        addressDto.setCity(addressDto.getCity());
        addressDto.setBuildingNumber(address.getBuildingNumber());
        addressDto.setZipCode(addressDto.getZipCode());
        return addressDto;
    }
}
