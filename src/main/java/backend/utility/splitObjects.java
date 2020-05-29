package backend.utility;

import backend.objects.Day;
import backend.objects.Exercise;
import backend.objects.ObjectTransfer;

import java.util.ArrayList;

public class splitObjects {

    private static ArrayList<String> dayList = new ArrayList<String>();
    private static int[] glucose;
    private static String[] glucoseTime;
    private static String[] carbsTime;
    private static double[] fastActingDosage;
    private static String[] fastActingTime;
    private static double[] longActingDosage;
    private static String[] longActingTime;
    private static String[] exerciseStartTimes;
    private static String[] exerciseDuration;

    public static ArrayList<Day> splitObjectTransfer(ObjectTransfer object)
    {
        //Extract from Objectransfer class
        glucose = object.getGlucose();
        glucoseTime = object.getGlucoseTime();
        int[] carbs = object.getCarbs();
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

        /**
        for(i = 0; i < dayList.size(); i++)
        {
            if(dayList.get(i).equals(longActingTime[0].substring(11)))
            {
                break;
            }
        }
         */
        iterationCount = 0;
        i = 0;
        double[][] longSplit = new double[dayCount][288];
        while(iterationCount < dayCount)
        {
            //TODO: Change this to allow for no-insulin days
            //This next few lines assumes that the user will take insulin every single day
            //It compares the number of insulin entries against the number of days in the spreadsheet
            //If a day is without an insulin entry, then it breaks.
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

        Exercise[] exerciseSplit = new Exercise[dayCount];
        for(i = 0; i < exerciseStartTimes.length; i++)
        {
            date = exerciseStartTimes[i].substring(0, 10);
            for(iterationCount = 0; iterationCount < dayList.size(); iterationCount++)
            {
                if(date.equals(dayList.get(iterationCount)))
                {
                    break;
                }
            }

            exerciseSplit[iterationCount].setExercisePeriod(exerciseStartTimes[i], exerciseDuration[i]);
        }

        //Day(int[][] glucose, int[][] carbs, boolean[][] exercise, double[][] fastActingInsulin, double[][] longActingInsulin, String date)
        ArrayList<Day> days = new ArrayList<Day>();
        int[][] glucoseEnter = new int[24][12], carbsEnter = new int[24][12];
        double[][] fastEnter = new double[24][12], longEnter = new double[24][12];
        for(i = 0; i < dayCount; i++)
        {
            for(o = 0; o < 288; o++)
            {
                int x = 0 % 12, y = 0 / 12;
                glucoseEnter[y][x] = glucoseSplit[i][o];
            }

            for(o = 0; o < 288; o++)
            {
                int x = 0 % 12, y = 0 / 12;
                carbsEnter[y][x] = carbsSplit[i][o];
            }

            for(o = 0; o < 288; o++)
            {
                int x = 0 % 12, y = 0 / 12;
                fastEnter[y][x] = fastSplit[i][o];
            }

            for(o = 0; o < 288; o++)
            {
                int x = 0 % 12, y = 0 / 12;
                longEnter[y][x] = longSplit[i][o];
            }

            Day temp = new Day(glucoseEnter, carbsEnter, exerciseSplit[i].getExerciseArr(), fastEnter, longEnter, dayList.get(i));
            days.add(temp);
        }

        return days;
    }

}
