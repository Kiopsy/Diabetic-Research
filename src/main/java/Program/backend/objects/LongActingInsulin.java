package Program.backend.objects;

public class LongActingInsulin extends Injections {

    public LongActingInsulin() {
        super();
    }

    //note: times and dosage MUST be parallel arrays
    public LongActingInsulin(String[] times, double[] dosage) {
        super(times, dosage);
    }

    public void setLongActingInsulin(String time, double level){ super.setInjections(time, level);}
    @Override
    public double[][] getInjectionsArr() {
        return super.getInjectionsArr();
    }
}
