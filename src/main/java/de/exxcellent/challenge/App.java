package de.exxcellent.challenge;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 * @author Jakob Gelszinnis <jgelszinnis@gmail.com>
 */
public final class App {

    public static void main(String... args) {

        // Your preparation code …


        // invoke the constructor
        TableDataset ds = new TableDataset("Testname");
        // invoke the method
        ds.loadfile();

        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        String teamWithSmallesGoalSpread = "A good team"; // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}


class TableDataset {


    private String filename;


    /*  THe constructor   */
    TableDataset(String filename) {
        this.filename = filename;
    }

    void loadfile() {
        System.out.printf("This is a test : %s%n", this.filename);
    }

}




