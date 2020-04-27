package backend.objects;

public class LongActingInsulin extends Injections {

    //note: times and dosage MUST be parallel arrays
    public LongActingInsulin(String[] times, double[] dosage) {
        super(times, dosage);
    }

    @Override
    public double[][] getInjectionsArr() {
        return super.getInjectionsArr();
    }
}
