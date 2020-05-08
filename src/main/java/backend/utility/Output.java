package backend.utility;

import backend.objects.Day;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Output {

    final static String[] monthArr = new String[] {
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
    };

    public static void outputWriter(ArrayList<Day> days){
        FileWriter csvWriter = new FileWriter("Users\\brasi\\Desktop\\Research Storage\\" + ".csv");
        csvWriter.write("");
        for(int i = 0; i < days.size(); i++){


        }
    }

}
