package backend.utility;

import backend.objects.*;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public static ObjectTransfer parseCSV(String fileName)
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
                    //Round time to nearest
                    //TODO: Redo this function to account for full time cell
                    Integer timeRound = Integer.valueOf(time.substring(3));
                    if((timeRound / 5) % 2 == 1)
                    {
                        timeRound = ((timeRound / 10) + 1) * 10;
                        if(timeRound == 60)
                        {
                            time = (Integer.parseInt(time.substring(0, 2)) + 1) + ":00";
                        }
                        else
                        {
                            time = time.substring(0, 3) + timeRound.toString();
                        }
                    }
                    else
                    {
                        timeRound = ((timeRound / 10) * 10) + 5;
                        time = time.substring(0, 3) + timeRound.toString();
                    }

                    //Gets position for writing to
                    //TODO: Also rewrite this to account for new changes
                    Position writeTo = Time.positionAt(list[i][1].substring(0, 10) + "_" + time);

                    //This overarching If/Else loop checks for the type of event
                    if(list[i][2].equals("EGV"))
                    {

                        //Find the length of the Glucose Index
                        Integer glucoseLevel = Integer.valueOf(list[i][7]);

                        //Writes glucose
                        glucose.add(glucoseLevel);
                        glucoseTime.add(time);

                    }
                    else if(list[i][2].equals("Carbs"))
                    {

                        Integer carbsLevel = (int) Double.parseDouble(list[i][8]);

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

                        String exerciseLength = list[i][9];

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
}
