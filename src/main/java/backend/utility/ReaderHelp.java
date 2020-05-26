package backend.utility;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class ReaderHelp {

    //input a List<String[]> of the csv of Day outputs (with header line) and returns ArrayList<String> of dates already written
    public static ArrayList<String> ReaderHelp(List<String[]> allRows){
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
}
