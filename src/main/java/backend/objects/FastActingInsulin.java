package backend.objects;

public class FastActingInsulin extends Injections {

    //note: times and dosage MUST be parallel arrays
    public FastActingInsulin(String[] times, double[] dosage) {
        super(times, dosage);
    }

    @Override
    public double[][] getInjectionsArr() {
        return super.getInjectionsArr();
    }
}