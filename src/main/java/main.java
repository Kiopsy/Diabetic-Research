import backend.utility.Input;
import backend.utility.Output;
import backend.utility.splitObjects;
import gui.initialGUI;

public class main {

	public static void main(String[] args) {

	    //Loads initialGUI
        //Grabs the .CSV target file (targetCSV) to write to from initialGUI
        initialGUI program = new initialGUI();
        String[] output = program.GUI();
        String fileAddress = output[0];
        System.out.println(fileAddress);

        String fileDirectory = output[1];

        Output.outputWriter(splitObjects.splitObjectTransfer(Input.parseDexcomCSV(fileAddress)), fileDirectory);

        //Victor's testing for outputing all file names from directory fileDirectory
        //Input.parseLocalCSV(fileDirectory);
        program.closeGUI();

            /**
             Bugs:
             1. All events other than glucose are being rounded up. Happens if an event occurs on the 5 minute mark.
             */
    }

}