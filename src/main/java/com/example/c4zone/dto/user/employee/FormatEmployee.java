package com.example.c4zone.dto.user.employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class FormatEmployee {
    private static final Random random = new Random();

    /**
     * Author: CaoNV
     * Goal:  Create an automatic format for employee
     */
    public static String generateEmployeeCode() {
        int randomNumber = random.nextInt(9999);
        if (randomNumber < 10) {
            return "NV000" + randomNumber;
        } else if (randomNumber < 100) {
            return "NV00" + randomNumber;
        } else if (randomNumber < 1000) {
            return "NV0" + randomNumber;
        }
        return "NV" + randomNumber;
    }

    /**
     * Author: CaoNV
     * Goal:  Check if the date format is 18 years old or not
     */
    public static boolean check18YearsOld(String dateStr) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        LocalDate date18YearsAgo = currentDate.minusYears(18);
        return date.isBefore(date18YearsAgo);
    }

    /**
     * Author: CaoNV
     * Goal:  Check the validity of the date
     */
    public static boolean isDateValidAndBeforeCurrent(String dateStr) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        return !date.isAfter(currentDate);
    }

 public static LocalDate formatDate(String startDate){
     LocalDate currentDate = LocalDate.now();
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     LocalDate date = LocalDate.parse(startDate, formatter);
     return date;
 }


}
