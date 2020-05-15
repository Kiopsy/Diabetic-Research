package backend.utility;

public class ArrayConversion {

    //Converts a 2D array to a 1D array with comma separators for CSVWriter
    public static String[] arrayConversion(String[][] list){
        String[] returnList = new String[list.length];
        for(int i = 0; i<list.length; i++){
            for(int j = 0; j<list[i].length; j++){
                returnList[i] += list[i][j];
                if(j != list[i].length - 1){
                    returnList[i] = ",";
                }
            }
        }
        return returnList;
    }
}
