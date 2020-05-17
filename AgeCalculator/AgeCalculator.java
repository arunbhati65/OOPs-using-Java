import java.time.LocalDate;
        import java.time.LocalDateTime;
        import java.time.Period;
        import java.time.temporal.ChronoUnit;
        import java.util.function.BiFunction;
        import java.util.function.Function;


public class AgeCalculator {

    public static void main(String[] args) {


        BiFunction<LocalDate, LocalDate, String> ageCalculator = (x, x1) -> {


            Period diff = Period.between(x, x1);


            return "" + diff.getYears() + " years " + diff.getMonths() + " months " + diff.getDays() + " days";
        };
        LocalDate birthDate = LocalDateTime.of(1994, 9, 15, 12, 22).toLocalDate();
        LocalDate ChoiceOfDate = LocalDateTime.of(2020, 9, 15, 12, 22).toLocalDate();
        System.out.println(ageCalculator.apply(birthDate, ChoiceOfDate));
    }

}