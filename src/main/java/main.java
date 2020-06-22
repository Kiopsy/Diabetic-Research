import backend.utility.*;
import gui.initialGUI;

public class main {

	public static void main(String[] args) {

	    //Loads initialGUI
        //Grabs the .CSV target file (targetCSV) to write to from initialGUI

        initialGUI program = new initialGUI();
        String[] output = program.GUI();
        String fileAddress = output[0];
        String fileDirectory = output[1];
        Output.outputWriter(splitObjects.splitObjectTransfer(Input.parseDexcomCSV(fileAddress)), fileDirectory);

        //Victor's testing for outputing all file names from directory fileDirectory
        Input.parseLocalCSV(fileDirectory);
        program.closeGUI();

    }

}