package co.za.service;

import co.za.DTO.StudentTo;
import co.za.Exceptions.StudentNotFoundException;
import co.za.domain.Student;
import co.za.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    private final SaveInterface saveInterface;

    public StudentService(StudentRepo studentRepo, SaveInterface saveInterface) {
        this.studentRepo = studentRepo;
        this.saveInterface = saveInterface;
    }

    public Student getStudent(String studentNumber){
        Student student = studentRepo.findAllByStudentNumber(studentNumber);

        if (student == null){
            throw new StudentNotFoundException(studentNumber);
        }
        return studentRepo.findAllByStudentNumber(studentNumber);
    }

    public Student getStudent(int id){
        return studentRepo.findAllById(id);
    }

    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }

    public void saveStudent(StudentTo studentTo){
        saveInterface.saveStudent(studentTo);
    }









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
