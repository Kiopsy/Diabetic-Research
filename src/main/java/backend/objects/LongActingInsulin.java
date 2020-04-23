package backend.objects;

public class LongActingInsulin extends Injections {

    //note: times and dosage MUST be parallel arrays
    public LongActingInsulin(String[] times, int[] dosage) {
        super(times, dosage);
    }

    @Override
    public int[][] getInjectionsArr() {
        return super.getInjectionsArr();
    }
}
