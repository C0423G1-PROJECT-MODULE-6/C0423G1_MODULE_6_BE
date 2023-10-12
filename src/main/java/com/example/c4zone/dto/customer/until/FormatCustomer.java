package com.example.c4zone.dto.customer.until;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class FormatCustomer {
    /**
     * Author: TinDT
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
     * Author: TinDT
     * Goal:  Check the validity of the date
     */
    public static boolean isDateValidAndBeforeCurrent(String dateStr) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        return !date.isAfter(currentDate);
    }

}
