package backend.utility;

import backend.objects.*;

import java.util.ArrayList;
import java.util.Arrays;

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

        ArrayList<Day> days = new ArrayList<Day>();

        String[][] glucoseDates = Helper.splitTimeArrays(glucoseTime);
        String[][] carbsDates = Helper.splitTimeArrays(carbsTime);
        String[][] FADates = Helper.splitTimeArrays(fastActingTime);
        String[][] LADates = Helper.splitTimeArrays(longActingTime);
        String[][] exerciseDates = Helper.splitTimeArrays(exerciseStartTimes);

        ArrayList<String> dates = Helper.listOfDays(glucoseDates, carbsDates, FADates, LADates, exerciseDates);
        for(int i = 0; i<dates.size(); i++){
            Glucose g;
            Carbs c;
            FastActingInsulin fA;
            LongActingInsulin lA;
            Exercise e;
            String[] dayIndexes;
            int min, max;
            String[] time;
            int[] intNum;
            double[] dosage;
            String[] duration;

            //creates the Glucose object for date dates.get(i)
            if(Helper.containsDay(glucoseDates, dates.get(i))){
                dayIndexes = Helper.dayArrayIndexes(glucoseDates, dates.get(i));
                min = Integer.parseInt(dayIndexes[1]);
                max = Integer.parseInt(dayIndexes[2]) + 1;
                time = Arrays.copyOfRange(glucoseTime, min, max);
                time = Helper.removeDates(time);
                intNum = Arrays.copyOfRange(glucose, min, max);
                g = new Glucose(time, intNum);
            }
            else{
                g = new Glucose();
            }

            //creates the Carbs object for date dates.get(i)
            if(Helper.containsDay(carbsDates, dates.get(i))){
                dayIndexes = Helper.dayArrayIndexes(carbsDates, dates.get(i));
                min = Integer.parseInt(dayIndexes[1]);
                max = Integer.parseInt(dayIndexes[2]) + 1;
                time = Arrays.copyOfRange(carbsTime, min, max);
                time = Helper.removeDates(time);
                intNum = Arrays.copyOfRange(carbs, min, max);
                c = new Carbs(time, intNum);
            }
            else{
                c = new Carbs();
            }

            //creates the FastActingInsulin object for date dates.get(i)
            if(Helper.containsDay(FADates, dates.get(i))){
                dayIndexes = Helper.dayArrayIndexes(FADates, dates.get(i));
                min = Integer.parseInt(dayIndexes[1]);
                max = Integer.parseInt(dayIndexes[2]) + 1;
                time = Arrays.copyOfRange(fastActingTime, min, max);
                time = Helper.removeDates(time);
                dosage = Arrays.copyOfRange(fastActingDosage, min, max);
                fA = new FastActingInsulin(time, dosage);
            }
            else{
                fA = new FastActingInsulin();
            }

            //creates the LongActingInsulin object for date dates.get(i)
            if(Helper.containsDay(LADates, dates.get(i))){
                dayIndexes = Helper.dayArrayIndexes(LADates, dates.get(i));
                min = Integer.parseInt(dayIndexes[1]);
                max = Integer.parseInt(dayIndexes[2]) + 1;
                time = Arrays.copyOfRange(longActingTime, min, max);
                time = Helper.removeDates(time);
                dosage = Arrays.copyOfRange(longActingDosage, min, max);
                lA = new LongActingInsulin(time, dosage);
            }
            else{
                lA = new LongActingInsulin();
            }

            //creates Exercise object for date dates.get(i)
            if(Helper.containsDay(exerciseDates, dates.get(i))){
                dayIndexes = Helper.dayArrayIndexes(exerciseDates, dates.get(i));
                min = Integer.parseInt(dayIndexes[1]);
                max = Integer.parseInt(dayIndexes[2]) + 1;
                time = Arrays.copyOfRange(exerciseStartTimes, min, max);
                time = Helper.removeDates(time);
                duration = Arrays.copyOfRange(exerciseDuration, min, max);
                e = new Exercise(time, duration);
            }
            else{
                e = new Exercise();
            }
            days.add(new Day(g.getGlucoseArr(), c.getCarbsArr(), e.getExerciseArr(), fA.getInjectionsArr(), lA.getInjectionsArr(), dates.get(i)));
        }

        return days;
    }
}
