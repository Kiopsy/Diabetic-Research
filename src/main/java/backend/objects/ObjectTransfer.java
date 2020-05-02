package backend.objects;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ObjectTransfer {
    private int[] glucose;
    private String[] glucoseTime;
    private int[] carbs;
    private String[] carbsTime;
    private double[] fastActingDosage;
    private String[] fastActingTime;
    private double[] longActingDosage;
    private String[] longActingTime;
    private String[] exerciseStartTimes;
    private String[] exerciseDuration;

    public ObjectTransfer(ArrayList<Integer> gl, ArrayList<String> glTime, ArrayList<Integer> carb, ArrayList<String>  carbTime, ArrayList<Double> fADosage, ArrayList<String> fATime, ArrayList<Double> lADosage, ArrayList<String> lATime, ArrayList<String> exStartTimes, ArrayList<String>  exDuration) {
        ArrayList<ArrayList>
        arrayListToArray(gl, glTime, carb, carbTime, fADosage, fATime, lADosage, lATime, exStartTimes, exDuration);
    }

    public GlucoseLevels getGlucose() {
        return glucose;
    }

    public void setGlucose(GlucoseLevels glucose) {
        this.glucose = glucose;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Carbs getFoodIntake() {
        return foodIntake;
    }

    public void setFoodIntake(Carbs foodIntake) {
        this.foodIntake = foodIntake;
    }

    public FastActingInsulin getFastInsulin() {
        return fastInsulin;
    }

    public void setFastInsulin(FastActingInsulin fastInsulin) {
        this.fastInsulin = fastInsulin;
    }

    public LongActingInsulin getLongInsulin() {
        return longInsulin;
    }

    public void setLongInsulin(LongActingInsulin longInsulin) {
        this.longInsulin = longInsulin;
    }

    public Exercise getWorkouts() {
        return workouts;
    }

    public void setWorkouts(Exercise workouts) {
        this.workouts = workouts;
    }

    public void arrayListToArray(ArrayList<Integer> gl, ArrayList<String> glTime, ArrayList<Integer> carb, ArrayList<String>  carbTime, ArrayList<Double> fADosage, ArrayList<String> fATime, ArrayList<Double> lADosage, ArrayList<String> lATime, ArrayList<String> exStartTimes, ArrayList<String>  exDuration){

    }
}
