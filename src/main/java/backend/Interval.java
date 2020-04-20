package backend;

public class Interval{

    private String time;
    private int glucose;
    private int insulin;

    public Interval(String time, int glucose, int insulin) {
        this.time = time;
        this.glucose = glucose;
        this.insulin = insulin;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getGlucose() {
        return glucose;
    }

    public void setGlucose(int glucose) {
        this.glucose = glucose;
    }

    public int getInsulin() {
        return insulin;
    }

    public void setInsulin(int insulin) {
        this.insulin = insulin;
    }

    @Override
    public String toString() {
        return time + "-" +  glucose + "-" + insulin;
    }
}
