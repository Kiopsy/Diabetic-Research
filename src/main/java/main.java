import backend.objects.*;
//import backend.utility.Input;
import backend.utility.Input;
import backend.utility.Output;
import backend.utility.Position;
import backend.utility.splitObjects;
import gui.initialGUI;

import javax.swing.*;
import java.util.ArrayList;

import static backend.utility.splitObjects.*;

public class main {

	public static void main(String[] args) {

	    //Loads initialGUI
        //Grabs the .CSV target file (targetCSV) to write to from initialGUI
        initialGUI program = new initialGUI();
        String[] output = program.GUI();
        String fileAddress = output[0];
        System.out.println(fileAddress);

        String fileDirectory = output[1];

        Output.outputWriter(splitObjects.splitObjectTransfer(Input.parseCSV(fileAddress)), fileDirectory);

        program.closeGUI();
    }

}