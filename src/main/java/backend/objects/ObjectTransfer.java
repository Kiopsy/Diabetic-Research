package backend.objects;

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

    public ObjectTransfer(int[] glucose, String[] glucoseTime, int[] carbs, String[] carbsTime, double[] fastActingDosage, String[] fastActingTime, double[] longActingDosage, String[] longActingTime, String[] exerciseStartTimes, String[] exerciseDuration) {
        this.glucose = glucose;
        this.glucoseTime = glucoseTime;
        this.carbs = carbs;
        this.carbsTime = carbsTime;
        this.fastActingDosage = fastActingDosage;
        this.fastActingTime = fastActingTime;
        this.longActingDosage = longActingDosage;
        this.longActingTime = longActingTime;
        this.exerciseStartTimes = exerciseStartTimes;
        this.exerciseDuration = exerciseDuration;
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
