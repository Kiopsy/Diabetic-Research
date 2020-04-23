package backend.utility;

import backend.objects.GlucoseLevels;
import backend.objects.Injections;
import backend.objects.Time;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Input {

    private Injections insulin;
    private GlucoseLevels glucose;
    private Time time;

    public static void parseCSV(String fileName)
    {
        CSVReader parser;
        try {

            parser = new CSVReader(new FileReader(fileName));
            List<String[]> allRows = parser.readAll();
            String[] list = (String[]) allRows.toArray();

            for(int i = 0; i < list.length; i++)
            {
                if(i > 11)
                {
                    //CSV Format: Index, Date:Time, Alert Type,
                    int commaCount = 0, index = 0;
                    while(commaCount < 2)
                    {
                        if(list[i].charAt(index) == ',')
                        {
                            commaCount++;
                        }
                        index++;
                    }
                    if(list[i].substring(index, index + 3).equals("EGV"))
                    {

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
