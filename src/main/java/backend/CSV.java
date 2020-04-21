package backend;

import com.opencsv.CSWriter;

import java.io.FileWriter;

public class CSV {

    private String fileName;

    public CSV(){
        CSWriter writer = new CSWriter(new FileWriter(fileName));
    }
}
