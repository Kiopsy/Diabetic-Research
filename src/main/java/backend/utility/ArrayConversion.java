package backend.utility;

import java.util.List;

public class ArrayConversion {

    //Converts a 2D array to a 1D array with comma separators for CSVWriter
    public static String[] arrayConversion(String[][] list){
        String[] returnList = new String[list.length];
        for(int i = 0; i<list.length; i++){
            for(int j = 0; j<list[i].length; j++){
                returnList[i] += list[i][j];
                if(j != list[i].length - 1){
                    returnList[i] += ",";
                }
            }
        }
        return returnList;
    }
    //Converts a List<String[]> to a 1D array with comma separators for CSVWriter
    public static String[] arrayConversion(List<String[]> list){
        String[] returnList = new String[list.size()];
        for(int i = 0; i<list.size(); i++){
            for(int j = 0; j<list.get(i).length; j++){
                returnList[i] += list.get(i)[j];
                if(j != list.get(i).length - 1){
                    returnList[i] += ",";
                }
            }
        }
        return returnList;
    }
}
