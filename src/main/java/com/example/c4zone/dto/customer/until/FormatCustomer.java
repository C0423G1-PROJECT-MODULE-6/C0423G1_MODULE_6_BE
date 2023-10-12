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
    /**
     * Author: TinDT
     * Goal:  calculate age for customer
     */
        public static int calculateAge(String birthDate) {
            // Định dạng của ngày tháng năm trong chuỗi đầu vào
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            // Chuyển chuỗi thành LocalDate
            LocalDate birthLocalDate = LocalDate.parse(birthDate, formatter);

            // Tính toán tuổi
            LocalDate currentDate = LocalDate.now();
            int age = currentDate.getYear() - birthLocalDate.getYear();

            return age;
        }
}
