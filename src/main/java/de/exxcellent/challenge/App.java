package de.exxcellent.challenge;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.*;


/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 * @author Jakob Gelszinnis <jgelszinnis@gmail.com>
 */
public final class App {

    public static void main(String... args) throws IOException {

        // Your preparation code …


        // invoke the constructor
        TableDataset ds1 = new TableDataset("weather.csv");
        // invoke the method
        ds1.loadfile("Day", "MxT","MnT");

        TableDataset ds2 = new TableDataset("football.csv");
        ds2.loadfile("Team", "Goals","Goals Allowed");


        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        String teamWithSmallesGoalSpread = "A good team"; // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}



class TableDataset {
    /*
    The custom class that will lead us through the challenge
     */
    private String relative = "src/main/resources/de/exxcellent/challenge/";
    private String filename;
    private ArrayList<String> colid;
    private ArrayList<Float> colA; //float
    private ArrayList<Float> colB; //float

//    private ArrayList<String> countmin;
//    private float argmin;

    /*  The constructor   */
    TableDataset(String filename) {
        this.filename = filename;
    }

    void loadfile(String colid, String colA, String colB) throws IOException {
        /*
        This function should sets the file and save the three columns of interest
       */

        // The id will be strings, the  column values will be floats, because we take the difference between them.
        this.colid = new ArrayList<>();
        this.colA  = new ArrayList<>();
        this.colB  = new ArrayList<>();

        Reader input = new FileReader(String.format("%s%s", this.relative, this.filename));
        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(input);
        for (CSVRecord record : records) {
            this.colid.add(record.get(colid));
            this.colA.add(Float.valueOf(record.get(colA)));
            this.colB.add(Float.valueOf(record.get(colB)));

        }

        System.out.printf("Colid: %s%n", this.colid);
        System.out.printf("ColA : %s%n", this.colA );
        System.out.printf("ColB : %s%n", this.colB);
    }

}







