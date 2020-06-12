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

        String[][] glucoseDates = Helper.splitTimeArrays(glucoseTime);
        String[][] carbsDates = Helper.splitTimeArrays(carbsTime);
        String[][] FADates = Helper.splitTimeArrays(fastActingTime);
        String[][] LADates = Helper.splitTimeArrays(longActingTime);
        String[][] exerciseDates = Helper.splitTimeArrays(exerciseStartTimes);



        for(int i = 0; i< glucoseDates.length; i++){
            for(int k = 0; k<glucoseDates[i].length; k++){
                System.out.print(glucoseDates[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 0; i<carbsDates.length; i++){
            for(int k = 0; k< carbsDates[i].length; k++){
                System.out.print(carbsDates[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 0; i<FADates.length; i++){
            for(int k = 0; k<FADates[i].length; k++){
                System.out.print(FADates[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 0; i<LADates.length; i++){
            for(int k = 0; k<LADates[i].length; k++){
                System.out.print(LADates[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 0; i< exerciseDates.length; i++){
            for(int k = 0; k<exerciseDates[i].length; k++){
                System.out.print(exerciseDates[i][k] + " ");
            }
            System.out.println();
        }

        ArrayList<String> dates = Helper.listOfDays(glucoseDates, carbsDates, FADates, LADates, exerciseDates);
        for(int i = 0; i<dates.)

        ArrayList<Day> days = new ArrayList<Day>();

        return days;
    }

    public static void display(ObjectTransfer object){
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

        System.out.println(carbsTime[0]);
        System.out.println(exerciseStartTimes[2]);
        System.out.println(glucoseTime[0]);
    }

}
