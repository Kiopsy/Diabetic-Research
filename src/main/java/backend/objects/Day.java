package backend.objects;

import backend.utility.Time;

public class Day{

    private String[] day = new String[288];
    //Format: YYY-MM-DD
    private String date;
    private String[][] time;
    private int[][] glucose;
    private int[][] carbs;
    private boolean[][] exercise;
    private double[][] fastActingInsulin;
    private double[][]longActingInsulin;

    //All inputs need to be sanitised for time, each array is assumed to be 288 long, or 2d 24x12
    public Day(int[][] glucose, int[][] carbs, boolean[][] exercise, double[][] fastActingInsulin, double[][] longActingInsulin, String date){
        //Array of each row in the final file
        // //Cell format: time_24hr-glucose_level-carbs_intake-whether_exercising-fastActingInsulin_intake-longActingInsulin_intake
        //Example cell: 20:30-123-20-false-0-23 (represents 123 mg/deciliter of glucose in blood at 8:30pm, 20 grams of carbs eaten, no exercise at given time, no fast acting insulin, and 23u of long acting insulin)
        this.time = Time.timeArr;
        this.glucose = glucose;
        this.carbs = carbs;
        this.exercise = exercise;
        this.fastActingInsulin = fastActingInsulin;
        this.longActingInsulin = longActingInsulin;
        this.date = date;

        int count = 0;
        for(int i = 0; i < 24; i++) {
            for (int k = 0; k < 12; k++) {
                day[count] = time[i][k] + "-" + glucose[i][k] + "-" + carbs[i][k] + "-" + exercise[i][k] + "-" + fastActingInsulin[i][k] + "-" + longActingInsulin[i][k];
                count++;
            }
        }
    }

    public String[] dayToString() {
        String[] lines = new String[24];
        int count = 0;
        for(int i = 0; i<24; i++) {
            lines[i] = date + ",";
            for (int k = 0; k < 12; k++) {
                lines[i] += day[count];
                if(k!=11){
                    lines[i] += ",";
                }
                count++;
            }
        }
        return lines;
    }

    public int[][] getGlucose() {
        return glucose;
    }

    public int[][] getCarbs() {
        return carbs;
    }

    public boolean[][] getExercise() {
        return exercise;
    }

    public double[][] getFastActingInsulin() {
        return fastActingInsulin;
    }

    public double[][] getLongActingInsulin() {
        return longActingInsulin;
    }

    public String[] getDay(){
        return day;
    }

    public String getDate() {
        return date;
    }

    public int getMonth(){
        String[] dateContents = date.split("-");
        int month = Integer.parseInt(dateContents[1]);
        return month;
    }

    public int getNumDay(){
        String[] dateContents = date.split("-");
        int numDate = Integer.parseInt(dateContents[2]);
        return numDate;
    }

    public String getYear(){
        String[] dateContents = date.split("-");
        return dateContents[0];
    }

    public void setGlucose(int[] glucose){
        for(int i = 0; i < 24; i++)
        {
            for(int o = 0; o < 12; o++)
            {
                this.glucose[i][o] = glucose[(24 * i) + o];
            }
        }
    }

    /*
    date,00:00,00:05,00:10,00:15,etc....
    (interval),(interval),(interval),(interval),etc....
     */

}
