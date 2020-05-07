package backend.objects;

public class Day{

    private String[] day = new String[289];
    private String date;
    private String[][] time;
    private int[][] glucose;
    private int[][] carbs;
    private boolean[][] exercise;
    private double[][] fastActingInsulin;
    private double[][]longActingInsulin;

    //All inputs need to be sanitised for time, each array is assumed to be 288 long, or 2d 12x24
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
        day[0] = date;

        for(int i = 0; i < 288; i++)
        {
            int x = i / 24;
            int y = i % 24;
            day[i + 1] = time[x][y] + "-" + glucose[x][y] + "-" + carbs[x][y] + "-" + exercise[x][y] + "-" + fastActingInsulin[x][y] + "-" + longActingInsulin[x][y];
        }
    }

    public String[] dayToString() {
        String[] lines = new String[24];
        int count = 0;
        for(int i = 0; i<24; i++) {
            for (int k = 0; k < 12; k++) {
                lines[i] += day[k + count] + ",";
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

}
