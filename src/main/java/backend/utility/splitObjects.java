package backend.utility;

import backend.objects.Day;
import backend.objects.ObjectTransfer;
import backend.objects.Time;

import java.util.ArrayList;

public class splitObjects {

    private ArrayList<String> dayList = new ArrayList<String>();
    private int[] glucose;
    private String[] glucoseTime;
    private int[] carbs;
    private String[] carbsTime;
    private double[] fastActingDosage;
    private String[] fastActingTime;
    private double[] longActingDosage;
    private String[] longActingTime;
    private String[] exerciseStartTimes;
    private String[] exerciseDuration;

    public ArrayList<Day> splitObjectTransfer(ObjectTransfer object)
    {
        //Extract from Objectransfer class
        glucose = object.getGlucose();
        glucoseTime = object.getGlucoseTime();
        carbs = object.getCarbs();
        carbsTime = object.getCarbsTime();
        fastActingDosage = object.getFastActingDosage();
        fastActingTime = object.getFastActingTime();
        longActingDosage = object.getLongActingDosage();
        longActingTime = object.getLongActingTime();
        exerciseStartTimes = object.getExerciseStartTimes();
        exerciseDuration = object.getExerciseDuration();

        int dayCount = 0;
        String previousDate = "";
        String currentDate;

        //Check how many days
        for(int i = 0; i < glucoseTime.length; i++)
        {
            currentDate = glucoseTime[i].substring(0, 10);
            if(!currentDate.equals(previousDate))
            {
                dayCount++;
                dayList.add(currentDate);
            }

            previousDate = currentDate;
        }
        ArrayList<Day> returnObject = new ArrayList<Day>(dayCount);

        int iterationCount = 0, i = 0, o = 0;
        int[][] glucoseSplit = new int[dayCount][288];
        while(iterationCount < dayCount)
        {
            o = Time.indexAt1DArr(glucoseTime[i]);
            glucoseSplit[iterationCount][o] = glucose[i];

            //TODO: Additional checks in case of connection loss at midnight (Glucose)
            if(glucoseTime[i].equals("00:00") && i != 0)
            {
                iterationCount++;
            }
            i++;
        }

        iterationCount = 0;
        i = 0;
        o = 0;
        int[][] carbsSplit = new int[dayCount][288];
        while(iterationCount < dayCount)
        {
            o = Time.indexAt1DArr(carbsTime[i]);
            carbsSplit[iterationCount][o] = carbs[i];

            //TODO: Additional checks in case of connection loss at midnight (Carbs)
            if(carbsTime[i].equals("00:00") && i != 0)
            {
                iterationCount++;
            }
            i++;
        }

        iterationCount = 0;
        i = 0;
        o = 0;
        double[][] fastSplit = new double[dayCount][288];
        while(iterationCount < dayCount)
        {
            //TODO: Check if logic applies to 2D arrays, or requires additional layers
            o = Time.indexAt1DArr(fastActingTime[i]);
            fastSplit[iterationCount][o] = fastActingDosage[i];

            //TODO: Write day logic iterator for insulin counts
            i++;
        }

        iterationCount = 0;
        i = 0;
        o = 0;
        double[][] longSplit = new double[dayCount][288];
        while(iterationCount < dayCount)
        {
            //TODO: Check if logic applies to 2D arrays, or requires additional layers
            o = Time.indexAt1DArr(longActingTime[i]);
            longSplit[iterationCount][o] = longActingDosage[i];

            //TODO: Write day logic iterator for insulin counts
            i++;
        }



        //Create day array to match
        //Create Day objects
        //Return Arraylist of days
    }

}
