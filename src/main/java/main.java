import backend.objects.*;
import backend.utility.Input;
import gui.initialGUI;

import javax.swing.*;

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
        //contains all parts from the input CSV (ex: 30 days worth of values specific to each array)
        ObjectTransfer readCSV = Input.parseCSV(fileAddress);



        //takes arrays from readCSV to create a Day object
        Glucose g = new Glucose(readCSV.getGlucoseTime(), readCSV.getGlucose());
        Carbs c = new Carbs(readCSV.getCarbsTime(),readCSV.getCarbs());
        Exercise e = new Exercise(readCSV.getExerciseStartTimes(), readCSV.getExerciseDuration());
        FastActingInsulin fa = new FastActingInsulin(readCSV.getFastActingTime(), readCSV.getFastActingDosage());
        LongActingInsulin la = new LongActingInsulin(readCSV.getLongActingTime(), readCSV.getLongActingDosage());


        program.closeGUI();



    }

}