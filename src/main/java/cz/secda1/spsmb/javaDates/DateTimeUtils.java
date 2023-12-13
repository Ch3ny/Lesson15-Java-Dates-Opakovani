package cz.secda1.spsmb.javaDates;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class DateTimeUtils {
    static DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    static DateTimeFormatter czdateformat = DateTimeFormatter.ofPattern("dd.MM.yyyy").localizedBy(Locale.getDefault());


    /**
     * Vypište aktuální datum ve formátu den.měsíc.rok hodina:minuta (např. 12.12.2023 14:41)
     *
     * @param date Libovolné datum a čas (LocalDateTime), které chceme naformátovat.
     * @return String s naformátovaným datem
     */
    public static String formattedDate(LocalDateTime date) {
        return dateformat.format(date);
    }

    /**
     * Naparsujte datum "03.11.2023" pomocí parseru se zadaným fromátem. Správný zápis formátu můžete vyhledat.
     *
     * @param dateString String ze kterého vyrobíme datum (LocalDate)
     * @return
     */
    public static LocalDate parseDate(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    /**
     * Přičtěte k zadanému datu (LocalDate) 12 hodin a vypište ve formátu 12.12.2023 12:00
     *
     * @param date libovolné datum
     * @return vložené datum s časem 12:00
     */
    public static String atMoonTime(LocalDate date) {
        return date.atStartOfDay().plusHours(12).format(dateformat);

    }

    /**
     * Vypište aktuální den v týdnu v české lokalizaci.
     *
     * @example "Dnes je středa."
     * @return String "Dnes je středa."
     */
    public static String whatsTheDateToday(LocalDate today) {
        //dopolňte do proměnné dayOfWeek den v týdnu.
        DayOfWeek dayOfWeek = today.getDayOfWeek();

        String dayNameInCzech = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());

        //Sestavte message "Dnes je <dayNameInCzech>." pomocí String.format()
        String formattedMessage = null;
        return formattedMessage.format("Dnes je "+dayNameInCzech+".");
    }

    /**
     * Definujte proměnou Vánoce (LocalDate), která bude ukazovat na datum 24.12.2023
     * a vypište kolik dní zbývá do začátku Vánoc pomocí String format();
     *
     * 1) pro výpočet použijte proměnné Vánoce a aktuální datum.
     * 2) Výsledný výstup z metody bude String ve formátu "Do Vánoc zbývá XY dní."
     *
     * @return String message
     */
    public static String daysToChristmas() {
        LocalDate christmass = parseDate("24.12.2023");
        int left = christmass.getDayOfMonth() - LocalDate.now().getDayOfMonth();

        return "Do Vánoc zbývá "+left+ " dní.";
    }

    /**
     * Napište metodu, která porovná dva vložené datumy a vrátí vždy nižší datum na provní pozici a vyšší na druhé.
     * Pokud je tedy druhé datum nižší než to první, pak oba datumy prohodí prohodí a vrátí je jako list.
     *
     * @examples
     * např. pro start = 01.01.2023 a end = 31.12.2023 vrátí list ve stejném pořadí
     * např. pro start = 31.12.2023  a end = 01.01.2023 vrátí list ve opět s nižším datem na první pozici a s vyšším na pozici druhé, tedy opět 01.01.2023, 31.12.2023.
     *
     * @param start první datum pro porovnání
     * @param end druhé datum pro porovnání
     * @return List<LocalDate> s oběma seřazenými datumy
     */
    public static List<LocalDate> smallerFirst(LocalDate start, LocalDate end){
        List<LocalDate> dates = new ArrayList<>();
       boolean yes = start.isBefore(end);
        if (yes) {
            dates.add(start);
            dates.add(end);
            return dates;
        }
        dates.add(end);
        dates.add(start);
        return dates;

    }

    /**
     * Najděte a vypište první pondělí po Vánocích 24.12.2023
     *
     * @return první pondělí po Vánocích (LocalDate)
     */
    public static LocalDate firstMondayAfterChristmas() {
        LocalDate chirismassDate = parseDate("24.12.2023");
        DayOfWeek first = chirismassDate.getDayOfWeek();
        LocalDate answer ;

        for (int i = 1; i < 7; i++) {
           answer = chirismassDate.plusDays(i);
           first =  answer.getDayOfWeek();
            if (DayOfWeek.MONDAY.equals(first)) {

                return answer;
            }
        }


    return null;
    }}



