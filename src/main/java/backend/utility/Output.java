package backend.utility;

import backend.objects.Day;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Output {

    final static String[] monthArr = new String[] {
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
    };

    public static void outputWriter(ArrayList<Day> days){

        FileWriter csvWriter;
        File fileName;
        for(int i = 0; i < days.size(); i++){
            fileName = new File("Users\\brasi\\Desktop\\Research Storage\\" + monthArr[days.get(i).getMonth()] + days.get(i).getYear() + ".csv");
            if(!fileName.exists()){
                csvWriter = new FileWriter(fileName);
                //csvWriter.write("Index, Glucose Value (mg/dL), Carb Value (grams) , Exercs, fastActingInsulin, longActingInsulin, date");
                csvWriter.append("dd");
            }
            else{
                if(){

                }
                else{

                }
            }
        }
    }

}
