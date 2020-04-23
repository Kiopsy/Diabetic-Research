package backend.objects;

public class FastActingInsulin extends Injections {

    //note: times and dosage MUST be parallel arrays
    public FastActingInsulin(String[] times, int[] dosage) {
        super(times, dosage);
    }

    @Override
    public int[][] getInjectionsArr() {
        return super.getInjectionsArr();
    }
}