import gui.initialGUI;

import javax.swing.*;

public class dailyInput {

	public static void main(String[] args) {

	    //Loads initialGUI
        //Grabs the .CSV target file (targetCSV) to write to from initialGUI

        initialGUI program = new initialGUI();
        //Move this to the gui.inputGUI class, somehow?
        program.setVisible(true);
        program.setTitle("Import Target CSV");
        program.setSize(450,250);
        program.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true){
            //Loads GUI
            //Holds program in place using a button while loop (reference MassScout_App project)
            //Grabs array from GUI and passes to output, along with the targetCSV
        }

    }

}