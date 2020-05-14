package backend.utility;

import backend.objects.Day;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Output {

    final static String[] monthArr = new String[] {
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
    };

    public static void outputWriter(ArrayList<Day> days, String directory){

        FileWriter csvWriter;
        File fileName;
        CSVReader parser;

        for(int i = 0; i < days.size(); i++){
            fileName = new File(directory + "\\" + monthArr[days.get(i).getMonth()] + days.get(i).getYear() + ".csv");

            String[] lines = days.get(i).dayToString();
            try {
                if(!fileName.exists()){
                    //writes file
                    csvWriter = new FileWriter(fileName);
                    csvWriter.write("Date,XX:05,XX:10,XX:15,XX:20,XX:25,XX:30,XX:35,XX:40,XX:45,XX:50,XX:55,XX:60");
                    //adds day to that file
                    for(int k = 0; k<24; k++){
                        csvWriter.append(lines[k] + "n/");
                    }

                }
                else{
                    parser = new CSVReader(new FileReader(fileName));
                    List<String[]> allRows = parser.readAll();
                    String[][] list = new String[allRows.size()][];
                    for(int k = 0; k< allRows.size(); k++)
                    {
                        list[k] = allRows.get(k);
                    }
                    if(true){

                    }
                    else{

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
