package backend.objects;

public class FastActingInsulin extends Injections {

    public FastActingInsulin() {
        super();
    }

    //note: times and dosage MUST be parallel arrays
    public FastActingInsulin(String[] times, double[] dosage) {
        super(times, dosage);
    }

    public void setFastActingInsulin(String time, double level){ super.setInjections(time, level);}

    @Override
    public double[][] getInjectionsArr() {
        return super.getInjectionsArr();
    }
}