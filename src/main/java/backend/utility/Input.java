package backend.utility;

import backend.objects.*;
import com.opencsv.CSVReader;
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

    public static void parseCSV(String fileName)
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
                    //Add 11 to TimeStampIndex to skip the date

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

                        String time = list[i].substring(timeStampIndex + 11, timeStampIndex + 16);
                        System.out.println(time);

                        //Round time to nearest
                        Integer timeRound = Integer.valueOf(time.substring(3));
                        if((timeRound / 5) % 2 == 1)
                        {
                            timeRound = ((timeRound / 10) + 1) * 10;
                            if(timeRound == 60)
                            {

                            }
                        }
                        else
                        {
                            timeRound = ((timeRound / 10) * 10) + 5;
                            time = time.substring(0, 3) + timeRound.toString();
                        }

                    }
                    else if(list[i].substring(index, index + 5).equals("Carbs"))
                    {

                    }
                    else if(list[i].substring(index, index + 7).equals("Insulin"))
                    {

                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
