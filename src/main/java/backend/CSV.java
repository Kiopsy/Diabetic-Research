package backend;


import com.opencsv.CSVWriter;
import com.opencsv.CSWriter;
import java.io.FileWriter;

public class CSV {

    private String fileName;

    public CSV(){

        CSVWriter writer = new CSVWriter(new FileWriter(filename));
    }
}
