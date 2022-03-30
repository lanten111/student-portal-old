package co.za.config;

import co.za.entity.*;
import co.za.enums.DEPARTMENT;
import co.za.enums.GENDER;
import co.za.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class StartUpListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LecturerRepository lecturerRepository;

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {



        Lecturer lecturer = new Lecturer();
        Address address = new Address();
        Courses course = new Courses();
        Modules module = new Modules();
        List<Modules> modules = new ArrayList<>();
        List<Books> booksList = new ArrayList<>();
        Books books = new Books();

        address.setCountry("South Afrca");
        address.setZipCode("1123");
        address.setCity("Johannesurg");
        address.setStreetName("113 back str");

        lecturer.setDepartment(DEPARTMENT.SCIENCE);
        lecturer.setEmail("s@sd.c");
        lecturer.setPassword("23213213");
        lecturer.setBirthday(LocalDateTime.now());
        lecturer.setDateCreated(LocalDateTime.now());
        lecturer.setDateUpdated(LocalDateTime.now());
        lecturer.setDeleted(false);
        lecturer.setGender(GENDER.FEMALE);
        lecturer.setIdNumber("9406225558014");
        lecturer.setSurname("mablula");
        lecturer.setName("jackobson");
        lecturer.setPhoneNumber("0458584554");
        lecturer.setAddress(address);
        lecturerRepository.save(lecturer);

        books.setBookName("Analytics book");
        books.setAuthor("some guy write it");
        books.setEdition("thrid edition");
        books.setReleased(LocalDate.now());
        bookRepository.save(books);
        booksList.add(books);

        module.setModuleCode("ANU101");
        module.setModuleName("Analytics and Stuff");
        module.setLecturer(lecturer);
        module.setModuleTime(LocalDateTime.now());
        module.setModuleId(UUID.randomUUID().toString());
        module.setModuleGuideUrl("storage/analtic guide.pdf");
//        module.setBooks(bookList);
        moduleRepository.save(module);
        modules.add(module);

        course.setCourseName("Analiytics ans stans");
        course.setCourseCode("AAS");
        course.setModule(modules);
        courseRepository.save(course);

         Modules module1 = new Modules();
        List<Modules> modules1 = new ArrayList<>();
        module1.setModuleCode("C+1");
        module1.setModuleName("C++ and Stuff");
        module1.setLecturer(lecturer);
        module1.setModuleTime(LocalDateTime.now());
        module1.setModuleId(UUID.randomUUID().toString());
        module1.setModuleGuideUrl("storage/C++ guide.pdf");
//        module1.setBooks(bookList);
        moduleRepository.save(module1);
        modules1.add(module1);

        Courses course1 = new Courses();
        course1.setCourseName("Computer  Science");
        course1.setCourseCode("BSC");
        course1.setModule(modules1);
        courseRepository.save(course1);

//        StudentTO studentTO = new StudentTO();
//        studentTO.setEmail("sada@asdsa");
//        studentTO.setIdNumber("940622555801");
//        studentTO.setName("somethiugn");
//        studentTO.setSurname("wayne");
//        studentTO.setPhoneNumber("2012548658");
//        Student student = transferStudent(studentTO);
//        studentRepository.save(student);
    }
}
