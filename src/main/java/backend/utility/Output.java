package backend.utility;

import backend.objects.Day;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        Path path;
        String fileAddress;
        for(int i = 0; i < 1; i++){
            fileAddress = directory + "\\" + monthArr[days.get(i).getMonth()] + days.get(i).getYear() + ".csv";
            path = Paths.get(fileAddress);

            String[] lines = days.get(i).dayToString();
            try {
                if(!Files.exists(path)){
                    //writes file
                    fileName = new File(fileAddress);
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
                    if(list.length > ((days.get(i).getNumDay()*24) + 1)){

                    }
                    else{
                        csvWriter = new FileWriter(fileName);
                        String[] currentCSV = ArrayConversion.arrayConversion(list);
                        for(int j = 0; i<list.length; i++){
                                csvWriter.append(currentCSV[j]);
                        }
                        for(int k = 0; k<24; k++){
                            csvWriter.append(lines[k] + "n/");
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
