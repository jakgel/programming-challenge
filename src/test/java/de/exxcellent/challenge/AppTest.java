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



        TableDataset ds1 = new TableDataset("weather.csv");
        ds1.loadfile("Day", "MxT","MnT");

        if (!Objects.equals("14", String.join(" ; ", ds1.compare_columns()))){
            successLabel = "failed";
        }


        TableDataset ds2 = new TableDataset("football.csv");
        ds2.loadfile("Team", "Goals","Goals Allowed");

        if (!Objects.equals("Aston_Villa", String.join(" ; ", ds2.compare_columns()))){
            successLabel = "failed";
        }

        System.out.printf("____ %s%n", String.join(" ; ", ds1.compare_columns()));
        System.out.printf("____ %s%n", String.join(" ; ", ds2.compare_columns()));
    }

    @Test
    public void aSimpleTest() {
        Assert.assertEquals("Expectations met", "successful", successLabel);
    }

}
