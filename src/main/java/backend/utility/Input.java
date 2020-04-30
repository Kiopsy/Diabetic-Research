package backend.utility;

import backend.objects.*;
import com.opencsv.CSVReader;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Input {

    private GlucoseLevels glucose;
    private Time time;
    private Carbs foodIntake;
    private FastActingInsulin fastInsulin;
    private LongActingInsulin longInsulin;
    private Exercise workouts;

    public ObjectTransfer parseCSV(String fileName)
    {
        CSVReader parser;
        try {

            parser = new CSVReader(new FileReader(fileName));
            List<String[]> allRows = parser.readAll();
            String[] list = (String[]) allRows.toArray();

            String previousTime = "00:00";

            for(int i = 0; i < list.length; i++)
            {
                if(i > 10)
                {
                    //CSV Format: Index, Date:Time, Alert Type,

                    //This finds the index of the event identifier
                    int commaCount = 0, index = 0;
                    while(commaCount < 2)
                    {
                        if(list[i].charAt(index) == ',')
                        {
                            commaCount++;
                        }
                        index++;
                    }

                    //This finds the index of the timestamp and date
                    int timeStampCommaCount = 0, timeStampIndex = 0;
                    while(timeStampCommaCount < 2)
                    {
                        if(list[i].charAt(timeStampIndex) == ',')
                        {
                            timeStampCommaCount++;
                        }
                        timeStampIndex++;
                    }

                    String time = list[i].substring(timeStampIndex + 11, timeStampIndex + 16);
                    System.out.println(time);
                    //Round time to nearest
                    Integer timeRound = Integer.valueOf(time.substring(3));
                    if((timeRound / 5) % 2 == 1)
                    {
                        timeRound = ((timeRound / 10) + 1) * 10;
                        if(timeRound == 60)
                        {
                            time = (Integer.valueOf(time.substring(0, 2)) + 1) + ":00";
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
                    Position writeTo = Time.positionAt(time);

                    //This overarching If/Else loop checks for the type of event
                    if(list[i].substring(index, index + 3).equals("EGV"))
                    {
                        int glucoseCommaCount = 0, glucoseIndex = 0;
                        while(glucoseCommaCount < 11)
                        {
                            if(list[i].charAt(glucoseIndex) == ',')
                            {
                                commaCount++;
                            }
                            glucoseIndex++;
                        }

                        int glucoseCommaCountPlusOne = 0, glucoseIndexPlusOne = 0;
                        while(glucoseCommaCount < 12)
                        {
                            if(list[i].charAt(glucoseIndex) == ',')
                            {
                                commaCount++;
                            }
                            glucoseIndex++;
                        }

                        //Find the length of the Glucose Index
                        Integer glucoseLevel = Integer.valueOf(list[i].substring(glucoseIndex + 1, glucoseIndexPlusOne));

                        //Writes glucose
                        glucose.writeGlucose(writeTo, glucoseLevel);

                    }
                    else if(list[i].substring(index, index + 5).equals("Carbs"))
                    {
                        //TODO: Implement Carbs Writing
                    }
                    else if(list[i].substring(index, index + 7).equals("Insulin"))
                    {
                        int InsulinCommaCount = 0, InsulinIndex = 0;
                        while(InsulinCommaCount < 3)
                        {
                            if(list[i].charAt(InsulinIndex) == ',')
                            {
                                InsulinCommaCount++;
                            }
                            InsulinIndex++;
                        }

                        int InsulinLevelCommaCount = 0, InsulinLevelIndex = 0, InsulinLevelIndexPlusOne = 0;
                        while(InsulinLevelCommaCount < 9)
                        {
                            if(list[i].charAt(InsulinLevelIndex) == ',' && InsulinLevelCommaCount < 8)
                            {
                                InsulinLevelCommaCount++;
                            }
                            InsulinLevelIndex++;
                            InsulinLevelIndexPlusOne++;
                        }

                        double injection = Double.valueOf(list[i].substring(InsulinLevelIndex, InsulinLevelIndexPlusOne - 1));

                        if(list[i].substring(InsulinIndex + 1, InsulinIndex + 2).equals("F"))
                        {
                            fastInsulin.updateInjections(writeTo, injection);
                        }
                        else
                        {
                            longInsulin.updateInjections(writeTo, injection);
                        }
                    }
                    else if(list[i].substring(index, index + 8).equals("Excersize"))
                    {
                        //TODO: Excersize
                    }
                }
            }

            ObjectTransfer object = new ObjectTransfer(glucose, time, foodIntake, fastInsulin, longInsulin, workouts);
            return object;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
