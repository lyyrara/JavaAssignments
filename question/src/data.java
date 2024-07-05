import java.time.*;
import java.time.temporal.ChronoUnit;

public class data {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2024, 12, 31);

        Period period = Period.between(date1, date2);
        int year = period.getYears();
        int month = period.getMonths();
        int days = period.getDays();

        System.out.println(year);
        System.out.println(month);
        System.out.println(days);


        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        System.out.println(daysBetween);
    }
    
    

}
