package backend.utility;

import backend.objects.*;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class Input {

    private static ArrayList<Integer> glucose = new ArrayList<Integer>();
    private static ArrayList<String> glucoseTime = new ArrayList<String>();
    private static ArrayList<Integer> carbs = new ArrayList<Integer>();
    private static ArrayList<String>  carbsTime = new ArrayList<String>();
    private static ArrayList<Double> fastActingDosage = new ArrayList<Double>();
    private static ArrayList<String> fastActingTime = new ArrayList<String>();
    private static ArrayList<Double> longActingDosage = new ArrayList<Double>();
    private static ArrayList<String> longActingTime = new ArrayList<String>();
    private static ArrayList<String> exerciseStartTimes = new ArrayList<String>();
    private static ArrayList<String>  exerciseDuration  = new ArrayList<String>();

    public static ObjectTransfer parseDexcomCSV(String fileName)
    {
        CSVReader parser;
        try {
            parser = new CSVReader(new FileReader(fileName));
            List<String[]> allRows = parser.readAll();

            String[][] list = new String[allRows.size()][];
            for(int k = 0; k< allRows.size(); k++)
            {
                list[k] = allRows.get(k);
            }

            for(int i = 0; i < list.length; i++)
            {
                if(i > 10)
                {
                    String time = list[i][1];
                    //Round time to nearest 5
                    time = Helper.roundTime5Min(time);

                  //  time = list[i][1].substring(0, 10) + "_" + time;


                    //This overarching If/Else loop checks for the type of event
                    if(list[i][2].equals("EGV"))
                    {
                        Integer glucoseLevel;
                        //Find the length of the Glucose Index
                        if(list[i][7].equals("Low"))
                        {
                            glucoseLevel = 40;
                        }
                        else
                        {
                             glucoseLevel = Integer.valueOf(list[i][7]);
                        }


                        //Writes glucose
                        glucose.add(glucoseLevel);
                        glucoseTime.add(time);

                    }
                    else if(list[i][2].equals("Carbs"))
                    {

                        Integer carbsLevel = Integer.parseInt(list[i][9]);

                        carbs.add(carbsLevel);
                        carbsTime.add(time);

                    }
                    else if(list[i][2].equals("Insulin"))
                    {

                        double injection = Double.valueOf(list[i][8]);

                        if(list[i][3].substring(0, 1).equals("F"))
                        {
                            fastActingDosage.add(injection);
                            fastActingTime.add(time);
                        }
                        else
                        {
                            longActingDosage.add(injection);
                            longActingTime.add(time);
                        }
                    }
                    else if(list[i][2].equals("Exercise"))
                    {

                        String exerciseLength = list[i][10];

                        exerciseDuration.add(exerciseLength);
                        exerciseStartTimes.add(time);
                    }
                }
            }

            ObjectTransfer object = new ObjectTransfer(glucose, glucoseTime, carbs, carbsTime, fastActingDosage, fastActingTime, longActingDosage, longActingTime, exerciseStartTimes, exerciseDuration);
            return object;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void parseLocalCSV(String directory){
        //method first reads all the files that have been written to an output directory
        File file = new File(directory);
        File[] yearList = file.listFiles();
        File[] monthList;
        //then creates and instantiates a ArrayList<String> of all the fileAddresses of every csv that the program has written onto the users PC
        ArrayList<String> monthFileAddresses = new ArrayList<String>();
        for(int i = 0; i<yearList.length; i++){
            monthList = yearList[i].listFiles();
            for(int k = 0; k<monthList.length; k++){
                monthFileAddresses.add(monthList[k].toString());
                System.out.println(monthList[k].toString());
            }
        }

    }
}
