package backend.utility;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderHelp {

    //input a List<String[]> of the csv of Day outputs (with header line) and returns ArrayList<String> of dates already written
    public static ArrayList<String> listOfDaysWritten(List<String[]> allRows){
        ArrayList<String> dates = new ArrayList<String>();
        String date;
        for(int i = 1; i<allRows.size(); i+=24){
            date = allRows.get(i)[0];
            dates.add(date);
        }
        return dates;
    }

    public static boolean isDayWritten(ArrayList dates, String date){
        boolean dayWritten = false;
        for(int i = 0; i<dates.size(); i++){
            if(dates.get(i).equals(date)){
                dayWritten = true;
                break;
            }
        }
        return dayWritten;
    }
    /*
    public static void sorter(){

    }

    public static boolean isFileSorted(String fileAddress){
        CSVReader parser;
        ArrayList<String> datesWritten;
        int max;
        try {
            parser = new CSVReader(new FileReader(fileAddress));
            List<String[]> allRows = parser.readAll();
            datesWritten = ReaderHelp.listOfDaysWritten(allRows);
            ArrayList<Integer> numDates= getNumDay(datesWritten);
            max = -1;
            for(int i = 0; i < numDates.size(); i++){
                if(max > numDates.get(i)){
                    return false;
                }
                max = numDates.get(i);
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return true;
    }

    public static ArrayList<Integer> getNumDay(ArrayList<String> dates){
        ArrayList<Integer> numDayList = new ArrayList<Integer>();
        int numDate;
        String[] dateContents;
        for(int i = 0; i<dates.size(); i++) {
            dateContents = dates.get(i).split("-");
            numDate = Integer.parseInt(dateContents[2]);
            numDayList.add(i, numDate);
        }
        return numDayList;
    }
    */
}
