package KarolW.ZIM.DSP;

/**
 * Created by Karol on 03-06-2017.
 */
public class SimpleDCfilter implements DigitalFilter {

    private double alpha;
    private double state;

    public SimpleDCfilter(double alpha) {
        this.alpha = alpha;
        state = 0;
    }

    @Override
    public double filter(double sample) {
        double y = sample - state;
        state = y * (1 - alpha) + state;
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
