package de.exxcellent.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 * @author Jakob Gelszinnis <jgelszinnis@gmail.com>
 */
public class AppTest {

    private String successLabel = "not successful";

    @Before
    public void setUp() throws Exception {
        successLabel = "successful";



        TableDataset ds1 = new TableDataset("weather.csv", "Day", "MxT","MnT");
        TableDataset ds2 = new TableDataset("football.csv", "Team", "Goals","Goals Allowed");

        System.out.printf("____ %s%n", ds1.compare_columns_out());
        System.out.printf("____ %s%n", ds2.compare_columns_out());

        if (!Objects.equals("14",  ds1.compare_columns_out())){
            successLabel = "failed";
        }
        if (!Objects.equals("Aston_Villa", ds2.compare_columns_out())){
            successLabel = "failed";
        }

    }

    @Test
    public void aSimpleTest() {
        Assert.assertEquals("Expectations met", "successful", successLabel);

    }

}
