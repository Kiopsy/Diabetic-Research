package backend.utility;

import backend.objects.Day;

import com.opencsv.CSVReader;

import java.io.*;
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
        String fileAddress;
        ArrayList<String> datesWritten;

        for(int i = 0; i < days.size(); i++){
            fileAddress = directory + "\\" + monthArr[days.get(i).getMonth() - 1] + days.get(i).getYear() + ".csv";
            String[] lines = days.get(i).dayToString();
            try{
                parser = new CSVReader(new FileReader(fileAddress));
                List<String[]> allRows = parser.readAll();
                datesWritten = ReaderHelp.listOfDaysWritten(allRows);
                for(int a = 0; a<datesWritten.size(); a++) {
                    System.out.println(datesWritten.get(a));
                }
                if(ReaderHelp.isDayWritten(datesWritten, days.get(i).getDate())){

                }
                else{
                    try {

                        csvWriter = new FileWriter(fileAddress, true);

                        for(int k = 0; k<24; k++){
                            csvWriter.append(lines[k] + "\n");
                        }
                        csvWriter.flush();
                        csvWriter.close();

                    } catch (IOException e) {

                    }
                }
            } catch (FileNotFoundException e) {
                fileName = new File(fileAddress);
                try{
                    csvWriter = new FileWriter(fileName);
                    csvWriter.append("Date,XX:05,XX:10,XX:15,XX:20,XX:25,XX:30,XX:35,XX:40,XX:45,XX:50,XX:55,XX:60\n");
                    //adds day to that file
                    for (int k = 0; k < 24; k++) {
                        csvWriter.append(lines[k] + "\n");
                    }
                    csvWriter.flush();
                    csvWriter.close();
                } catch (IOException j) {

                }

            } catch (IOException e) {

            }
        }
    }

}
