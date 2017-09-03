
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        ld = LocalDate.parse("2015-01-01");
        System.out.println(ld);
        
        ld = LocalDate.parse("02/07/2018", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(ld);
        //converting to string, to store and retrieve
        String isoDate = ld.toString();
        System.out.println(isoDate);
        ld = LocalDate.parse(isoDate);
        
        String formatted  = ld.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(formatted);
        formatted = ld.format(DateTimeFormatter.ofPattern("MM/dd/yyyy+-+-+-"));
        System.out.println(formatted);
        
        formatted = ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(formatted);
        formatted = ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        System.out.println(formatted);
        formatted = ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        System.out.println(formatted);
        formatted = ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        System.out.println(formatted);
        LocalDate past = ld.minusYears(5);
        formatted = past.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(formatted);
        
        Period diff = ld.until(past);
        System.out.println(diff);
        
        diff = past.until(ld);
        System.out.println(diff);
        
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        
        formatted = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        System.out.println(formatted);
        
        Date legacyDate = new Date();
        System.out.println(legacyDate);
        GregorianCalendar legacyCalendar = new GregorianCalendar();
        System.out.println(legacyCalendar);
        
        ZonedDateTime zdt = ZonedDateTime.ofInstant(legacyDate.toInstant(), ZoneId.systemDefault());
        System.out.println(zdt);
        ld = zdt.toLocalDate();
        System.out.println(ld);
        
        zdt = legacyCalendar.toZonedDateTime();
        ld = zdt.toLocalDate();
        System.out.println(ld);
    }
    
}
