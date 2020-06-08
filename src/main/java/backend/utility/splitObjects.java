package backend.utility;

import backend.objects.Day;
import backend.objects.Exercise;
import backend.objects.ObjectTransfer;

import java.util.ArrayList;

public class splitObjects {

    private static ArrayList<String> dayList = new ArrayList<String>();
    private static int[] glucose;
    private static String[] glucoseTime;
    private static int[] carbs;
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
        String currentDate, instantDay;

        //Check how many days
        //Checks how many days with info from all time arrays. If a day is present in one of the arrays that is not in others, it adds that day to the list.
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

        int i = 0, p = 0, o;
        String date = "", prevDate = "";
        int[][] glucoseSplit = new int[dayCount][288];
        while(i < glucoseTime.length)
        {
            date = glucoseTime[i].substring(0, 10);
            //Lookup of date index
            for(p = 0; p < dayList.size(); p++)
            {
                if(date.equals(dayList.get(p)))
                {
                    break;
                }
            }

            o = Time.indexAt1DArr(glucoseTime[i].substring(11));
            glucoseSplit[p][o] = glucose[i];

            i++;
        }

        for(i = 0; i < glucoseSplit.length; i++)
        {
            System.out.println(glucoseSplit[i][1] + " Run1");
        }

        i = 0;
        p = 0;
        int[][] carbsSplit = new int[dayCount][288];
        while(i < carbsTime.length)
        {
            date = carbsTime[i].substring(0, 10);
            //Lookup of date index
            for(p = 0; p < dayList.size(); p++)
            {
                if(date.equals(dayList.get(p)))
                {
                    break;
                }
            }

            o = Time.indexAt1DArr(carbsTime[i].substring(11));
            carbsSplit[p][o] = carbs[i];

            i++;
        }

        i = 0;
        p = 0;
        double[][] fastSplit = new double[dayCount][288];
        while(i < fastActingTime.length)
        {
            date = fastActingTime[i].substring(0, 10);
            //Lookup of date index
            for(p = 0; p < dayList.size(); p++)
            {
                if(date.equals(dayList.get(p)))
                {
                    break;
                }
            }

            o = Time.indexAt1DArr(fastActingTime[i].substring(11));
            fastSplit[p][o] = fastActingDosage[i];

            i++;
        }

        i = 0;
        p = 0;
        double[][] longSplit = new double[dayCount][288];
        while(i < longActingTime.length)
        {
            date = longActingTime[i].substring(0, 10);
            //Lookup of date index
            for(p = 0; p < dayList.size(); p++)
            {
                if(date.equals(dayList.get(p)))
                {
                    break;
                }
            }
            o = Time.indexAt1DArr(longActingTime[i].substring(11));
            longSplit[p][o] = longActingDosage[i];

            i++;
        }

        int iterationCount = 0;
        Exercise[] exerciseSplit = new Exercise[dayCount];
        for(int z = 0; z < exerciseSplit.length; z++)
        {
            exerciseSplit[z] = new Exercise();
        }
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

        ArrayList<Day> days = new ArrayList<Day>();
        int[][] glucoseEnter = new int[24][12], carbsEnter = new int[24][12];
        double[][] fastEnter = new double[24][12], longEnter = new double[24][12];
        for(i = 0; i < dayCount; i++)
        {
            for(o = 0; o < 288; o++)
            {
                int x = o % 12, y = o / 12;
                glucoseEnter[y][x] = glucoseSplit[i][o];
            }

            for(o = 0; o < 288; o++)
            {
                int x = o % 12, y = o / 12;
                carbsEnter[y][x] = carbsSplit[i][o];
            }

            for(o = 0; o < 288; o++)
            {
                int x = o % 12, y = o / 12;
                fastEnter[y][x] = fastSplit[i][o];
            }

            for(o = 0; o < 288; o++)
            {
                int x = o % 12, y = o / 12;
                longEnter[y][x] = longSplit[i][o];
            }

            Day temp = new Day(glucoseEnter, carbsEnter, exerciseSplit[i].getExerciseArr(), fastEnter, longEnter, dayList.get(i));
            days.add(temp);
        }

        for(i = 0; i < glucoseEnter.length; i++)
        {
            System.out.println(glucoseEnter[i][1] + " Run2");
        }

        return days;
    }

}
