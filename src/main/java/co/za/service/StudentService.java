package co.za.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

//    @Autowired
//    private StudentRepo studentRepo;

//    public StudentService(StudentRepo studentRepo) {
//        this.studentRepo = studentRepo;
//    }

    public String getStudentByStudentNumber(String studentNumber){
//        List<Student> students = studentRepo.findAllByStudentNumber(studentNumber);
        System.out.println();
        return  "Yay it works";
    }
    


    public static void main(String [] args){

        String firstWord = "I am a spring.boot developer and I enjoy doing android in my spare time";
        String[]  firstWordArray = firstWord.split(" ");
        List<String> s = new ArrayList<>();

        Boolean skip = true;
        String newString = "";
        for ( int i = firstWordArray.length - 1 ; i >= 0; i--){
            if (skip){
                newString = newString  +" "+ firstWordArray[i];
                skip = !skip;
            }
        }
        System.out.println(newString);
    }
}
