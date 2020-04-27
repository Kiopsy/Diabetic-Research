import backend.objects.Exercise;
import backend.objects.Time;
import backend.utility.Position;


public class dailyInput extends Time {

	public static void main(String[] args) {
        String[] startTimes = new String[]{"10:00"};
        String[] duration = new String[]{"00:30:00"};
        boolean[][] exercise = new boolean[12][24];
        Exercise test = new Exercise(startTimes, duration);
        exercise = test.getExerciseArr();

        Position p = new Position(0,0);
        p = Time.positionAt("10:00");
        System.out.println(exercise[p.getColumnPosition()][p.getRowPosition()]);

        p = Time.positionAt("10:15");
        System.out.println(exercise[p.getColumnPosition()][p.getRowPosition()]);

        p = Time.positionAt("10:30");
        System.out.println(exercise[p.getColumnPosition()][p.getRowPosition()]);

        p = Time.positionAt("10:35");
        System.out.println(exercise[p.getColumnPosition()][p.getRowPosition()]);
	    //Loads initialGUI
        //Grabs the .CSV target file (targetCSV) to write to from initialGUI
        //System.out.println("FIX");

        while(true){
            //Loads GUI
            //Holds program in place using a button while loop (reference MassScout_App project)
            //Grabs array from GUI and passes to output, along with the targetCSV
        }

    }

}