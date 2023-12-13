package cz.secda1.spsmb.javaDates;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Main {
    static  DateFormat dateformat =new SimpleDateFormat("DD.mm.YYYY, hh:MM");


    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(DateTimeUtils.formattedDate(LocalDateTime.now()));
        System.out.println(DateTimeUtils.parseDate("03.11.2023"));
        System.out.println(DateTimeUtils.atMoonTime(LocalDate.now()));
        System.out.println(DateTimeUtils.whatsTheDateToday(LocalDate.now()));
        System.out.println(DateTimeUtils.daysToChristmas());
        System.out.println(DateTimeUtils.smallerFirst(LocalDate.now(), LocalDate.now().minusDays(1)));
        System.out.println(DateTimeUtils.smallerFirst(LocalDate.now().plusDays(3), LocalDate.now().minusDays(1)));

    }
}
