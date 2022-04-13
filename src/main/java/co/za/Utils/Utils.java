package co.za.Utils;

import java.time.LocalDateTime;

public class Utils {

    public static String generateStudentNumber(String idNumber, int studentsTotal){

        LocalDateTime now = LocalDateTime.now();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(now.getYear());
        stringBuilder.append(String.format("%02d", studentsTotal));
        stringBuilder.append(String.valueOf(now.getNano()).substring(0, 4));
        return stringBuilder.toString();
    }

}
