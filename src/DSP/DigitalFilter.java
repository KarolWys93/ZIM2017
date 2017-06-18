package DSP;

/**
 * Created by Karol on 03-06-2017.
 */
public interface DigitalFilter {

    public abstract double filter(double sample);

    public abstract double[] filter(double[] sample);

    public abstract void resetFilter();
}
