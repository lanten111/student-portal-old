package co.za.service;

import co.za.DTO.StudentTo;
import co.za.Exceptions.StudentNotFoundException;
import co.za.Exceptions.StudentWithSameEmailExist;
import co.za.Exceptions.StudentWithSameStudentNumberExist;
import co.za.Utils.TransferService;
import co.za.Utils.Utils;
import co.za.domain.Login;
import co.za.domain.Student;
import co.za.repository.LoginRepository;
import co.za.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final SaveInterface saveInterface;

    private final LoginRepository loginRepository;

    public StudentService(StudentRepository studentRepository, SaveInterface saveInterface, LoginRepository loginRepository) {
        this.studentRepository = studentRepository;
        this.saveInterface = saveInterface;
        this.loginRepository = loginRepository;
    }

    public Student getStudent(String studentNumber){

        Student student = studentRepository.findAllByStudentNumber(studentNumber);
        if (student == null){
            throw new StudentNotFoundException(studentNumber);
        }
        return studentRepository.findAllByStudentNumber(studentNumber);
    }

    public Student getStudent(Long id){
        Student student =  studentRepository.findAllById(id);
        if (student == null){
            throw new StudentNotFoundException(id);
        }
        return student;
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public void studentRegister(StudentTo studentTo){

        if (studentRepository.existsByIdNumber(studentTo.getIdNumber())){
            throw new StudentWithSameStudentNumberExist(studentTo.getIdNumber());
        } else if (studentRepository.existsByEmail(studentTo.getEmail())){
            throw new StudentWithSameEmailExist(studentTo.getEmail());
        }

        Student student = TransferService.transferStudent(studentTo);
        Login login = new Login();
        int totalStudents = (int) studentRepository.count();
        String studentNumber = Utils.generateStudent(studentTo.getIdNumber(), totalStudents);

        login.setPassword(studentTo.getPassword());
        login.setUsername(studentNumber);
        loginRepository.save(login);
        student.setStudentNumber(studentNumber);
        student.setLogin(login);
        student.setDateCreated(LocalDateTime.now());
        student.setDateUpdated(LocalDateTime.now());
        student.setDeleted(false);
        studentRepository.save(student);
    }

//    private Student createStudent(StudentTo student){}









//    public static void main(String [] args){
//
//        //create a list of numbers char from the int
//        int num = 234324;
//        List<Integer> numList = new ArrayList<>();
//        String numAsStringList = String.parse(num).toCharArray;
//        for (int i = 0; i < numAsStringList.size(); i++ ){
//            numList.add(numAsStringList.get(i))
//        }
//        Array.sort(numList);
//
//
////     split int int char
////     String numAsString = String.valueOf(num)';
//        //split string into an array
//        numList = numList.split();
////     order the list of number asceding
//        numList = numList.sort();
////     build string with sorted number
//        String newNum = "";
//        for (int i = 0; i < numList.size; i++){
//            newNum = newNum + numList[i];
//        }
////     covert newNum to int and return
//        return Integer.arse(newNum);
//    }
}
