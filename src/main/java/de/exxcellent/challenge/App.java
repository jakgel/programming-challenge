package de.exxcellent.challenge;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.*;


/**
 * The entry class for my solution.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 * @author Jakob Gelszinnis <jgelszinnis@gmail.com>
 */
public final class App {

    public static void main(String... args) throws IOException {

        // My preparation code …


        // invoke the constructor + method
        TableDataset ds1 = new TableDataset("weather.csv", "Day", "MxT","MnT");
        TableDataset ds2 = new TableDataset("football.csv", "Team", "Goals","Goals Allowed");

        // My day analysis function call + some formating
        String dayWithSmallestTempSpread = ds1.compare_columns_out();
        String teamWithSmallesGoalSpread = ds2.compare_columns_out();

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

    private ArrayList<String> countmin;
    private float argmin;

    /*  The constructor(s)   */
    TableDataset(String filename) {
        this.filename = filename;
    }

    TableDataset(String filename, String colid, String colA, String colB) throws IOException {
        this.filename = filename;
        loadfile(colid, colA, colB);
    }

    void loadfile(String colid, String colA, String colB) throws IOException {
        /*
        This function should sets the file and save the three columns of interest

        Input:
           - column identifier for the id
           - column identifier for the first column
           - column identifier for the ssecond column
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

    }

    ArrayList<String> compare_columns() {
        /* This method will compare the two columns
           To be more specific, in this implementation we will return the ArrayList of the columnIDs
           that refer to the rows with the smallest absolute difference colA-colB
        */


        Iterator<String> id = colid.iterator();
        Iterator<Float> A = colA.iterator();
        Iterator<Float> B = colB.iterator();

        this.countmin =  new ArrayList<>();
        this.countmin.add(id.next());
        this.argmin   = (float) Math.abs(A.next()-B.next()); // Float.NaN;   // Double.POSITIVE_INFINITY;


        /* We go through each line and update the argmin and countmin parameter if needed */
        while (id.hasNext() && A.hasNext() && B.hasNext()) {

            float diff;
            diff = Math.abs(A.next()-B.next());
            String iduse   = id.next();

            // If new record is set, update the variables
            if (diff < this.argmin){
                this.countmin.clear();
                this.argmin     = diff;
            }

            // Add the identifier id
            if (diff == this.argmin) {
                this.countmin.add(iduse);
            }

        }


        return this.countmin;
    }

    String compare_columns_out() {
        /*  A wrapper for an utility function */
        return String.join(" ; ", this.compare_columns());
    }
}







