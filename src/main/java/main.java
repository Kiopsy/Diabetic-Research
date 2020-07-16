import backend.objects.Day;
import backend.utility.*;
import gui.*;

import java.util.ArrayList;

public class main { /* extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
         Parent root = FXMLLoader.load(getClass().getResource("gui.fxml.GUI.fxml"));
         primaryStage.setTitle("Hello World");
         primaryStage.setScene(new Scene(root, 300, 275));
         primaryStage.show();
    }
    */

	public static void main(String[] args) {

        //launch(args);

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