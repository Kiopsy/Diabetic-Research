package Program;

import Program.backend.objects.Day;
import Program.backend.utility.*;
import Program.gui.initialGUI;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {

	    //Loads initialGUI
        //Grabs the .CSV target file (targetCSV) to write to from initialGUI

        initialGUI program = new initialGUI();
        String[] output = program.GUI();
        String fileAddress = output[0];
        String fileDirectory = output[1];
        Output.outputWriter(splitObjects.splitObjectTransfer(Input.parseDexcomCSV(fileAddress)), fileDirectory);

        //allData contains all the data that has been written to the user's PC in the specified output directory
        ArrayList<ArrayList<Day>> allData = Input.parseLocalCSV(fileDirectory);

        program.closeGUI();

    }

}