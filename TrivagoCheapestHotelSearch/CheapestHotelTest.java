package main.java.GreedyAlgorithm.huffmancoding;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static main.java.GreedyAlgorithm.CheapestHotel.getCheapestHotelNames;

public class CheapestHotelTest {

    @Test
    public void getCheapestHotelNamesTest() {
        LocalDate startDate = LocalDate.of(2020, 6, 13);
        LocalDate endDate = LocalDate.of(2020, 6, 19);
        Assert.assertEquals("ABC", getCheapestHotelNames(startDate, endDate).name());
    }

}
