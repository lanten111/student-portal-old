package co.za.config;

import co.za.entity.*;
import co.za.entity.Module;
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
        Course course = new Course();
        Module module = new Module();
        List<Module> modules = new ArrayList<>();
        List<Book> bookList = new ArrayList<>();
        Book book = new Book();

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

        book.setBookName("Analytics book");
        book.setAuthor("some guy write it");
        book.setEdition("thrid edition");
        book.setReleased(LocalDate.now());
        bookRepository.save(book);
        bookList.add(book);

        module.setModuleCode("ANU101");
        module.setModuleName("Analytics and Stuff");
        module.setLecturer(lecturer);
        module.setModuleTime(LocalDateTime.now());
        module.setModuleId(UUID.randomUUID().toString());
        module.setModuleGuideUrl("storage/analtic guide.pdf");
        moduleRepository.save(module);
        modules.add(module);

        course.setCourseName("Barchelor of Science");
        course.setCourseCode("BSC");
        course.setModule(modules);
        courseRepository.save(course);

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
