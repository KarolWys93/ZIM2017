package DSP;

/**
 * Created by Karol on 03-06-2017.
 */
public class FIRfilter implements DigitalFilter{

    private double bCoeffs[];
    private double state[];

    public FIRfilter(double bCoeffs[]) {
        this.bCoeffs = bCoeffs;
        state = new double[bCoeffs.length-1];
    }

    @Override
    public void resetFilter(){
        for (int i = 0; i < state.length; i++) {
            state[i] = 0;
        }
    }

    @Override
    public double filter(double sample) {

        double y = 0;
        y = sample * bCoeffs[0];
        for(int i = 0; i < state.length; i++){
            y += state[i] * bCoeffs[i+1];
        }

        //przepisanie stanów Z^-1 -> Z^-2
        for(int i = state.length-1; i != 0; i--)
            state[i] = state[i-1];
        state[0] = sample;

        return y;
    }

    @Override
    public double[] filter(double[] sample) {
        double[] filteredData = new double[sample.length];
        for (int i = 0; i < sample.length; i++){
            filteredData[i] = filter(sample[i]);
        }
        return filteredData;
    }

}
