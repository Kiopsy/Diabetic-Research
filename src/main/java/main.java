import backend.objects.ObjectTransfer;
import backend.utility.Input;
import gui.initialGUI;

import javax.swing.*;

public class main {

	public static void main(String[] args) {

	    //Loads initialGUI
        //Grabs the .CSV target file (targetCSV) to write to from initialGUI
        initialGUI program = new initialGUI();
        String fileAddress = program.GUI();
        System.out.println(fileAddress);

        ObjectTransfer readCSV = Input.parseCSV(fileAddress);

        program.closeGUI();



    }

}