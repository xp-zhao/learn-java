package date.period;

import java.time.LocalDate;
import java.time.Period;

public class PeriodDemo {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2018, 2, 20);
        LocalDate endDate = LocalDate.of(2019, 1, 15);

        Period period = Period.between(startDate, endDate);
        System.out.println(period.isNegative());
        System.out.println(String.format("Years:%d months:%d days:%d", period.getYears(), period.getMonths(), period.getDays()));
        System.out.println(period.plusYears(1).getYears());

        Period fromCharYears = Period.parse("P2Y");
        System.out.println(fromCharYears.getYears());

        Period fromCharUnits = Period.parse("P2Y3M5D");
        System.out.println(fromCharUnits.getDays());
    }
}
