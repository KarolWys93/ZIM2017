package DSP;

/**
 * Created by Karol on 04-06-2017.
 */
public class MeanFilter implements DigitalFilter {

    private int windowWidth;
    private double [] state;
    private int actualStatePointer;

    public MeanFilter(int windowWidth) {
        this.windowWidth = windowWidth;
        state = new double[windowWidth];
        actualStatePointer = 0;
    }

    @Override
    public double filter(double sample) {
        state[(actualStatePointer++)%state.length] = sample;
        state[state.length-1] = sample;
        double sum = 0;
        for (double v : state) {
            sum += v;
        }
        if(actualStatePointer >= state.length) actualStatePointer = 0;
        return sum/windowWidth;
    }

    @Override
    public double[] filter(double[] sample) {
        double[] result = new double[sample.length];
        for (int i = 0; i < sample.length; i++) {
            result[i] = filter(sample[i]);
        }
        return result;
    }

    @Override
    public void resetFilter() {
        for (int i = 0; i < state.length; i++) {
            state[i]=0;
        }
        actualStatePointer = 0;
    }
}
