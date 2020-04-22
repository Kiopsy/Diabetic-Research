package backend;


import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSV {

    public CSV(String fileName){

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String[]> rows = new ArrayList<>();






    }
}
