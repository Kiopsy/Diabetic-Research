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

    public ObjectTransfer(ArrayList<Integer> glucose, ArrayList<String> glucoseTime, ArrayList<Integer> carbs, ArrayList<String>  carbsTime, ArrayList<Double> fastActingDosage, ArrayList<String> fastActingTime, ArrayList<Double> longActingDosage, ArrayList<String> longActingTime, ArrayList<String> exerciseStartTimes, ArrayList<String>  exerciseDuration) {
        this.glucose = toArrayInteger(glucose);
        this.glucoseTime = toArrayString(glucoseTime);
        this.carbs = toArrayInteger(carbs);
        this.carbsTime = toArrayString(carbsTime);
        this.fastActingDosage = toArrayDouble(fastActingDosage);
        this.fastActingTime = toArrayString(fastActingTime);
        this.longActingDosage = toArrayDouble(longActingDosage);
        this.longActingTime = toArrayString(longActingTime);
        this.exerciseStartTimes = toArrayString(exerciseStartTimes);
        this.exerciseDuration = toArrayString(exerciseDuration);
    }

    public int[] toArrayInteger(ArrayList<Integer> values){
        int[] temp = new int[values.size()];
        for(int i = 0; i<values.size(); i++){
            temp[i] = values.get(i);
        }
        return temp;
    }

    public String[] toArrayString(ArrayList<String> values){
        String[] temp = new String[values.size()];
        for(int i = 0; i<values.size(); i++){
            temp[i] = values.get(i);
        }
        return temp;
    }

    public double[] toArrayDouble(ArrayList<Double> values){
        double[] temp = new double[values.size()];
        for(int i = 0; i<values.size(); i++){
            temp[i] = values.get(i);
        }
        return temp;
    }

    public int[] getGlucose() {
        return glucose;
    }

    public void setGlucose(int[] glucose) {
        this.glucose = glucose;
    }

    public String[] getGlucoseTime() {
        return glucoseTime;
    }

    public void setGlucoseTime(String[] glucoseTime) {
        this.glucoseTime = glucoseTime;
    }

    public int[] getCarbs() {
        return carbs;
    }

    public void setCarbs(int[] carbs) {
        this.carbs = carbs;
    }

    public String[] getCarbsTime() {
        return carbsTime;
    }

    public void setCarbsTime(String[] carbsTime) {
        this.carbsTime = carbsTime;
    }

    public double[] getFastActingDosage() {
        return fastActingDosage;
    }

    public void setFastActingDosage(double[] fastActingDosage) {
        this.fastActingDosage = fastActingDosage;
    }

    public String[] getFastActingTime() {
        return fastActingTime;
    }

    public void setFastActingTime(String[] fastActingTime) {
        this.fastActingTime = fastActingTime;
    }

    public double[] getLongActingDosage() {
        return longActingDosage;
    }

    public void setLongActingDosage(double[] longActingDosage) {
        this.longActingDosage = longActingDosage;
    }

    public String[] getLongActingTime() {
        return longActingTime;
    }

    public void setLongActingTime(String[] longActingTime) {
        this.longActingTime = longActingTime;
    }

    public String[] getExerciseStartTimes() {
        return exerciseStartTimes;
    }

    public void setExerciseStartTimes(String[] exerciseStartTimes) {
        this.exerciseStartTimes = exerciseStartTimes;
    }

    public String[] getExerciseDuration() {
        return exerciseDuration;
    }

    public void setExerciseDuration(String[] exerciseDuration) {
        this.exerciseDuration = exerciseDuration;
    }
}
