package backend.objects;

public class ObjectTransfer {
    private GlucoseLevels glucose;
    private Time time;
    private Carbs foodIntake;
    private FastActingInsulin fastInsulin;
    private LongActingInsulin longInsulin;
    private Exercise workouts;

    public ObjectTransfer(GlucoseLevels glucose, Time time, Carbs foodIntake, FastActingInsulin fastInsulin, LongActingInsulin longInsulin, Exercise workouts) {
        this.glucose = glucose;
        this.time = time;
        this.foodIntake = foodIntake;
        this.fastInsulin = fastInsulin;
        this.longInsulin = longInsulin;
        this.workouts = workouts;
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
}
