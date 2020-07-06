package backend.utility;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Helper {

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

    //given an ArrayList of dates, and a String date to check, it checks whether the specified date is in the list.
    public static boolean isDayWritten(ArrayList<String> dates, String date){
        boolean dayWritten = false;
        for(int i = 0; i<dates.size(); i++){
            if(dates.get(i).equals(date)){
                dayWritten = true;
                break;
            }
        }
        return dayWritten;
    }

    //given a String[][] (created with splitTimeArray()), and a String date to check, it checks whether the specified date is in the list.
    public static boolean containsDay(String[][] dates, String date){
        boolean dayWritten = false;
        for(int i = 0; i<dates.length; i++){
            if(dates[i][0].equals(date)){
                dayWritten = true;
                break;
            }
        }
        return dayWritten;
    }

    //given a String[][] (created with splitTimeArray()), and a String date to check, it returns the String[] of indexes.
    public static String[] dayArrayIndexes(String[][] dates, String date){
        String[] dayIndexes = new String[3];
        for(int i = 0; i<dates.length; i++){
            if(dates[i][0].equals(date)){
                dayIndexes = dates[i];
                break;
            }
        }
        return dayIndexes;
    }

    //given an String[] of times (ex: 2020-04-18_00:05) returns an ArrayList of dates.
    public static ArrayList<String> listOfDays(String[] time){
        ArrayList<String> dates = new ArrayList<String>();
        String tempDate;
        for(int i = 0; i<time.length; i++){
            tempDate = time[i].split("_")[0];
            if(!isDayWritten(dates, tempDate)){
                dates.add(tempDate);
            }
        }
        return dates;
    }

    //given the 5 2D arrays that are created for each object
    //returns a ArrayList<String> that lists all the days that have data
    public static ArrayList<String> listOfDays(String[][] GDates, String[][] CDates, String[][] FADates, String[][] LADates, String[][] EDates){
        ArrayList<String> dates = new ArrayList<String>();
        for(int i = 0; i<GDates.length; i++){
            if(!Helper.isDayWritten(dates, GDates[i][0])){
                dates.add(GDates[i][0]);
            }
        }
        for(int i = 0; i<CDates.length; i++){
            if(!Helper.isDayWritten(dates, CDates[i][0])){
                dates.add(CDates[i][0]);
            }
        }
        for(int i = 0; i<FADates.length; i++){
            if(!Helper.isDayWritten(dates, FADates[i][0])){
                dates.add(FADates[i][0]);
            }
        }
        for(int i = 0; i<LADates.length; i++){
            if(!Helper.isDayWritten(dates, LADates[i][0])){
                dates.add(LADates[i][0]);
            }
        }
        for(int i = 0; i<EDates.length; i++){
            if(!Helper.isDayWritten(dates, EDates[i][0])){
                dates.add(EDates[i][0]);
            }
        }
        return dates;
    }

    //returns a String[][]
    //each line in the String[][] will be a new day
    //The String[] will have 3 indexes (0 = date, 1= startDateIndex, 2= endDateIndex)
    //The String[] will give the indexes within the inputted time array that have the same date.
    public static String[][] splitTimeArrays(String[] dateAndTime){
        ArrayList<String> totalDates = Helper.listOfDays(dateAndTime);
        String[][] splitTimeArrays = new String[totalDates.size()][3];
        int min = 0,max = -1;
        for(int i = 0; i<totalDates.size(); i++){
            for(int k = min; k<dateAndTime.length; k++){
                if(dateAndTime[k].split("_")[0].equals(totalDates.get(i))){

                    max++;
                }
                else
                {
                    break;
                }
            }
            splitTimeArrays[i][0] = totalDates.get(i);
            splitTimeArrays[i][1] = Integer.toString(min);
            splitTimeArrays[i][2] = Integer.toString(max);

            min = max + 1;
        }
        return splitTimeArrays;
    }

    //takes a String[] of times with dates and returns a String[] with just the times
    public static String[] removeDates(String[] withDates){
        String[] times = new String[withDates.length];
        for(int i = 0; i<withDates.length; i++){
            times[i] = withDates[i].substring(11,16);
        }
        return times;
    }

    //given a String time (consisting of YYYY-MM-DD_HH-MM-SS) it returns a String with time rounded to the nearest 5 minutes.
    public static String roundTime5Min(String time){

        String year = time.substring(0,4);
        String month = time.substring(5,7);
        String day = time.substring(8,10);

        Calendar calendarDate = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));

        //time.substring(14, 16) shows minutes
        //time.substring(11,13) shows hour
        //time.substring(17,19) shows seconds
        String hour = time.substring(11,13);
        String tens = time.substring(14, 15);
        String minute;

        String date;

        String timeReturn = null;

        int timeRound = Integer.parseInt(time.substring(14, 16));
        int minTo5 = timeRound % 5;
        int minTo10 = timeRound % 10;
        int secTo5 = (minTo5 * 60) + Integer.parseInt(time.substring(17,19));
        if(secTo5 < 150 || secTo5 == 150){
            //rounds down
            if(minTo10 < 5){
                //accounts for times that do not need to be rounded
                minute = Integer.parseInt(tens) + "0";
            }
            else{
                minute = tens + "5";
            }
            timeReturn = hour + ":" + minute;
        }
        else{
            //rounds up
            //first it rounds the String down
            if(minTo10 < 5){
                minute = Integer.parseInt(tens) + "0";
            }
            else{
                minute = tens + "5";
            }
            //then uses an 1D time array to find the next position in the array.
            timeReturn = hour + ":" + minute;
            if(timeReturn.equals("23:55")){
                calendarDate.add(Calendar.DAY_OF_MONTH, 1);
                timeReturn = Time.time()[0];
            }
            else{
                timeReturn = Time.time()[Time.indexAt1DArr(timeReturn) + 1];
            }
        }
        year = Integer.toString(calendarDate.get(Calendar.YEAR));
        if(calendarDate.get(Calendar.MONTH)  + 1 < 10){
            month = "0" + Integer.toString(calendarDate.get(Calendar.MONTH) + 1);
        }
        else{
            month = Integer.toString(calendarDate.get(Calendar.MONTH));
        }
        if(calendarDate.get(Calendar.DAY_OF_MONTH)< 10){
            day = "0" + Integer.toString(calendarDate.get(Calendar.DAY_OF_MONTH));
        }
        else{
            day = Integer.toString(calendarDate.get(Calendar.DAY_OF_MONTH));
        }

        date = year + "-" + month + "-" + day;
        timeReturn = date + "_" + timeReturn;
        return timeReturn;
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
