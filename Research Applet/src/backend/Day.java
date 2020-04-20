package backend;

public class Day{

    private String[] day = new String[288];
    private String[][] time;
    private int[][] insulin;
    private int[][] glucose;
    //All inputs need to be sanitised for time, each array is assumed to be 288 long, or 2d 12x24
    public Day(String[][] t, int[][] insul, int[][] g){
        //Array of each row in the final file
        // //Cell format: time_24hr-glucose_level-insulin_intake
        //Example cell: 2030-123-0 (represents 123 mg/deciliter of glucose in blood at 8:30pm, with no insulin intake)
        time = t;
        insulin = insul;
        glucose = g;

        for(int i = 0; i < 288; i++)
        {
            int x = i / 24;
            int y = i % 24;
            day[i] = time[x][y] + "-" + glucose[x][y] + "-" + insulin[x][y];
        }
    }

    @Override
    public String toString() {
        String line = "";
        for(int i = 0; i < day.length - 1; i++)
        {
            line += day[i].toString() + ",";
        }
        line += day[day.length - 1];
        return line;
    }

    public int[][] getGlucose() {
        return glucose;
    }

    public int[][] getInsulin() {
        return insulin;
    }
}
