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

        int iterationCount = 0, i = 0, o;
        String date = "", prevDate = "";
        int[][] glucoseSplit = new int[dayCount][288];
        while(iterationCount < dayCount)
        {
            o = Time.indexAt1DArr(glucoseTime[i].substring(11));
            glucoseSplit[iterationCount][o] = glucose[i];

            date = glucoseTime[i].substring(0, 10);
            if(date != prevDate && i != 0)
            {
                iterationCount++;
            }
            prevDate = date;

            i++;
        }

        iterationCount = 0;
        i = 0;
        int[][] carbsSplit = new int[dayCount][288];
        while(iterationCount < dayCount)
        {
            o = Time.indexAt1DArr(carbsTime[i].substring(11));
            carbsSplit[iterationCount][o] = carbs[i];

            date = carbsTime[i].substring(0, 10);
            if(date != prevDate && i != 0)
            {
                iterationCount++;
            }
            prevDate = date;

            i++;
        }

        iterationCount = 0;
        i = 0;
        double[][] fastSplit = new double[dayCount][288];
        while(iterationCount < dayCount)
        {
            o = Time.indexAt1DArr(fastActingTime[i].substring(11));
            fastSplit[iterationCount][o] = fastActingDosage[i];

            date = fastActingTime[i].substring(0, 10);
            if(date != prevDate && i != 0)
            {
                iterationCount++;
            }
            prevDate = date;

            i++;
        }

        iterationCount = 0;
        i = 0;
        double[][] longSplit = new double[dayCount][288];
        while(iterationCount < dayCount)
        {
            o = Time.indexAt1DArr(longActingTime[i].substring(11));
            longSplit[iterationCount][o] = longActingDosage[i];

            date = longActingTime[i].substring(0, 10);
            if(date != prevDate && i != 0)
            {
                iterationCount++;
            }
            prevDate = date;

            i++;
        }

        ArrayList<ArrayList<Integer>> exerciseSplit = new ArrayList<ArrayList<Integer>>(dayCount);
        for(i = 0; i < exerciseStartTimes.length; i++)
        {

        }

        //Day(int[][] glucose, int[][] carbs, boolean[][] exercise, double[][] fastActingInsulin, double[][] longActingInsulin, String date)
        ArrayList<Day> days = new ArrayList<Day>();
        int[][] glucoseEnter, carbsEnter;
        double[][] fastEnter, longEnter;
        boolean [][] exercise;
        for(i = 0; i < dayCount; i++)
        {

        }

        return null;
    }

}
