package backend.objects;

import backend.utility.Position;
import backend.utility.Time;

public class Exercise {
    private boolean[][] exerciseArr = new boolean[][]{
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false}
    };

    public Exercise(){

    }
    
    //note: times and insulin MUST be parallel arrays
    public Exercise(String[] startTimes, String[] duration){
        Position p = new Position(0,0);
        Position[] exerciseDuration;

        for(int i = 0; i<duration.length; i++){
            exerciseDuration = Time.timeSpan(startTimes[i], Time.timeStringToMinutes(duration[i]));
            for(int k = 0; k<exerciseDuration.length; k++) {
                p = exerciseDuration[k];
                exerciseArr[p.getColumnPosition()][p.getRowPosition()] = true;
            }
        }
    }


    public void setExercisePeriod(String time, String duration)
            {
                Position p;
                Position[] exerciseDuration = Time.timeSpan(time, Time.timeStringToMinutes(duration));
                for(int k = 0; k<exerciseDuration.length; k++) {
                    p = exerciseDuration[k];
                    exerciseArr[p.getColumnPosition()][p.getRowPosition()] = true;
        }
    }

    public void setExercise(String time, boolean isExercising)
    {
        Position p;
        p = Time.positionAt(time);
        exerciseArr[p.getColumnPosition()][p.getRowPosition()] = isExercising;
    }

    public boolean[][] getExerciseArr() {
        return exerciseArr;
    }
}
