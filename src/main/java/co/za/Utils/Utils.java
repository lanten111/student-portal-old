package co.za.Utils;

import co.za.entity.Course;
import co.za.entity.Student;
import co.za.response.CourseResponse;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class Utils {

    public static String generateStudent(String idNumber, int studentsTotal){

        LocalDateTime now = LocalDateTime.now();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(now.getYear());
        stringBuilder.append(String.format("%02d", studentsTotal));
        stringBuilder.append(String.valueOf(now.getNano()).substring(0, 4));
        return stringBuilder.toString();
    }

    public static CourseResponse generateResponse(List<Course> message){
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setCode(HttpStatus.OK.value());
        courseResponse.setStatus(HttpStatus.OK.getReasonPhrase());
        courseResponse.setDatas(message);
        return courseResponse;
    }


//    public static SuccessTO generateResponse(String message){
//        SuccessTO successTO = new SuccessTO();
//        successTO.setCode(HttpStatus.OK.value());
//        successTO.setStatus(HttpStatus.OK.getReasonPhrase());
//        successTO.setData(message);
//    }
}
