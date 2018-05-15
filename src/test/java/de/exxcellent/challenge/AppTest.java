package de.exxcellent.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 * @author Jakob Gelszinnis <jgelszinnis@gmail.com>
 */
public class AppTest {

    private String successLabel = "not successful";

    @Before
    public void setUp() throws Exception {


        /* most likely not needed anymore
        successLabel = "successful";


        TableDataset ds1 = new TableDataset("weather.csv", "Day", "MxT","MnT");
        TableDataset ds2 = new TableDataset("football.csv", "Team", "Goals","Goals Allowed");


        if (!Objects.equals("14",  ds1.compare_columns_out())){
            successLabel = "failed";
        }
        if (!Objects.equals("Aston_Villa", ds2.compare_columns_out())){
            successLabel = "failed";
        }

        */

    }

    @Test
    public void aSimpleTest() throws IOException {
        TableDataset ds1 = new TableDataset("weather.csv", "Day", "MxT","MnT");
        Assert.assertEquals("Dataset 'weather'", "14" , ds1.compare_columns_out());
    }

    @Test
    public void aSimpleTest2() throws IOException {
        TableDataset ds2 = new TableDataset("football.csv", "Team", "Goals","Goals Allowed");
        Assert.assertEquals("Dataset 'foodball'", "Aston_Villa" , ds2.compare_columns_out());
    }

}
