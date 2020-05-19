import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class CheapestHotel {
    private static Hotel getCheapestHotelNames(LocalDate startDate, LocalDate endDate) {
        long totalDaysOfStay = DAYS.between(startDate, endDate);

        int numberOfWeekends = getNumberOfWeekEndsDays(startDate, endDate);
        int numberOfWeekday = (int) (totalDaysOfStay - numberOfWeekends);
        List<Hotel> listOfHotels = Arrays.asList(Hotel.values());
        return listOfHotels.stream().sorted((h1, h2) -> {
            return (h1.getWeekDayPrice() * numberOfWeekday + h1.getWeekEndPrice() * numberOfWeekends -
                    h2.getWeekDayPrice() * numberOfWeekday + h2.getWeekEndPrice() * numberOfWeekends);
        }).collect(Collectors.toList()).get(0);
    }

    private static int getNumberOfWeekEndsDays(LocalDate startDate, LocalDate endDate) {
        int count = 0;
        LocalDate currentDate = startDate;
        do {
            if (DayOfWeek.SATURDAY.equals(currentDate.getDayOfWeek()) || DayOfWeek.SUNDAY.equals(currentDate.getDayOfWeek())) {
                count++;
            }
            currentDate = currentDate.plusDays(1);
        } while (DAYS.between(currentDate, endDate) != 0);

        return count;
    }

    public static void main(String args[]) {
        LocalDate startDate = LocalDate.of(2020, 6, 13);
        LocalDate endDate = LocalDate.of(2020, 6, 19);
        System.out.println(getCheapestHotelNames(startDate, endDate));
    }


}
