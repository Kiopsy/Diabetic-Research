import gui.initialGUI;

import javax.swing.*;

public class main {

	public static void main(String[] args) {

	    //Loads initialGUI
        //Grabs the .CSV target file (targetCSV) to write to from initialGUI
        initialGUI program = new initialGUI();
        String fileAddress = program.GUI();
        System.out.println(fileAddress);
        program.closeGUI();

        while(true){
            //Loads GUI
            //Holds program in place using a button while loop (reference MassScout_App project)
            //Grabs array from GUI and passes to output, along with the targetCSV
        }

    }

}