package backend;

import java.util.Arrays;


public class onUpdate {

    //creates a day object with only insulin injections
            //will create csv file with insulin inputs
    public static void updateInsulin(String[] t, int[] d)
    {
        int[] tempGlucoseArr = new int[288];
        Arrays.fill(tempGlucoseArr, 0);
        GlucoseLevels empty = new GlucoseLevels(Time.time(), tempGlucoseArr);

        Injections insulinToWrite = new Injections(t, d);
        Day dayToUpdate = new Day(Time.timeArr, insulinToWrite.getInjectionsArr(), empty.getGlucoseArr());
    }

    public static void updateGlucose(String[] t, int[] d)
    {

    }

}
