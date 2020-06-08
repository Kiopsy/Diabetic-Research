import backend.utility.*;
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
        System.out.println(Helper.roundTime5Min("2020-04-22T01:12:00"));
            System.out.println(Helper.roundTime5Min("2020-04-22T00:02:30"));
            System.out.println(Helper.roundTime5Min("2020-04-22T23:57:31"));
            System.out.println(Helper.roundTime5Min("2020-04-22T23:55:31"));
            System.out.println(Helper.roundTime5Min("2020-04-22T00:02:31"));
            System.out.println(Helper.roundTime5Min("2020-04-22T01:58:00"));
        //splitObjects.display(Input.parseDexcomCSV(fileAddress));
        //Output.outputWriter(splitObjects.splitObjectTransfer(Input.parseDexcomCSV(fileAddress)), fileDirectory);
        splitObjects.splitObjectTransfer(Input.parseDexcomCSV(fileAddress));
        //Victor's testing for outputing all file names from directory fileDirectory
        //Input.parseLocalCSV(fileDirectory);
        program.closeGUI();

            /**
             Bugs:
             1. All events other than glucose are being rounded up. Happens if an event occurs on the 5 minute mark.
             */
    }

}