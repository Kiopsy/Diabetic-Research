import backend.objects.*;
//import backend.utility.Input;
import backend.utility.Output;
import backend.utility.Position;
import gui.initialGUI;

import javax.swing.*;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {

	    //Loads initialGUI
        //Grabs the .CSV target file (targetCSV) to write to from initialGUI
        initialGUI program = new initialGUI();
        String[] output = program.GUI();
        String fileAddress = output[0];
        System.out.println(fileAddress);

        String fileDirectory = output[1];
        System.out.println(fileDirectory);

        //use time for glucoseTime,carbTime, exerciseStartTime, FATime, LAtime
        String[] time = new String[]{"12:45"};
        int[] glucose = new int[]{123};
        int[] carb = new int[]{10};
        double[] dosage = new double[]{19.0};
        String[] exerciseDuration = new String[]{"00:30:00"};


        Glucose g = new Glucose(time, glucose);
        System.out.println("glucose complete");
        Carbs c = new Carbs(time, carb);
        System.out.println("carbs complete");
        Exercise e = new Exercise(time, exerciseDuration);
        System.out.println("exercise complete");
        FastActingInsulin fa = new FastActingInsulin(time, dosage);
        System.out.println("fa complete");
        LongActingInsulin la = new LongActingInsulin(time, dosage);
        System.out.println("la complete");

        String date = "2020-05-17";
        Day exampleDay = new Day(g.getGlucoseArr(), c.getCarbsArr(), e.getExerciseArr(), fa.getInjectionsArr(), la.getInjectionsArr(), date);
        date = "2020-05-18";
        Day exampleDay2 = new Day(g.getGlucoseArr(), c.getCarbsArr(), e.getExerciseArr(), fa.getInjectionsArr(), la.getInjectionsArr(), date);

        String[] text = exampleDay.dayToString();

        for(int i = 0; i < text.length; i++){
                System.out.println(text[i]);
        }

        ArrayList<Day> example = new ArrayList<Day>();
        example.add(exampleDay);
        example.add(exampleDay2);
        Output.outputWriter(example, fileDirectory);

        /*
	    //contains all parts from the input CSV (ex: 30 days worth of values specific to each array)
        // .parseCSV does not work
        ObjectTransfer readCSV = Input.parseCSV(fileAddress);



        //takes arrays from readCSV to create a Day object

        Glucose g = new Glucose(readCSV.getGlucoseTime(), readCSV.getGlucose());
        Carbs c = new Carbs(readCSV.getCarbsTime(),readCSV.getCarbs());
        Exercise e = new Exercise(readCSV.getExerciseStartTimes(), readCSV.getExerciseDuration());
        FastActingInsulin fa = new FastActingInsulin(readCSV.getFastActingTime(), readCSV.getFastActingDosage());
        LongActingInsulin la = new LongActingInsulin(readCSV.getLongActingTime(), readCSV.getLongActingDosage());
	    */

        program.closeGUI();



    }

}