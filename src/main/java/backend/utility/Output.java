package backend.utility;

import backend.objects.Day;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Output {

    final static String[] monthArr = new String[] {
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
    };

    public static void outputWriter(ArrayList<Day> days, String directory){

        FileWriter csvWriter;
        File fileName;
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
