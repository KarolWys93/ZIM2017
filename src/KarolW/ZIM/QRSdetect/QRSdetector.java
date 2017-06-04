package KarolW.ZIM.QRSdetect;


import KarolW.ZIM.DSP.MeanFilter;

/**
 * Created by Karol on 03-06-2017.
 */
public class QRSdetector {

    private double[] data;
    private int meanWindowWidth;
    private double decisionThreshold;

    public QRSdetector(double[] data, int meanWindowWidth, double decisionThreshold) {
        this.data = data;
        this.meanWindowWidth = meanWindowWidth;
        this.decisionThreshold = decisionThreshold;
    }

    public double[] process(){
        return detectFunction(data);
    }

    private double[] detectFunction(double[] data){
        MeanFilter meanFilter = new MeanFilter(meanWindowWidth);

        double [] detectFcnData = derivate(data);

        for (int i = 0; i < detectFcnData.length; i++) {
            detectFcnData[i] = detectFcnData[i]*detectFcnData[i];
        }
        detectFcnData = meanFilter.filter(detectFcnData);
        return normalization(detectFcnData);
    }

    private double[] normalization(double[] data){
        double[] normalizedData = new double[data.length];

        double max = getMaxValue(data);
        for (int i = 0; i < data.length; i++) {
            normalizedData[i] = data[i]/max;
        }
        return normalizedData;
    }

    private double getMaxValue(double[] data){
        double max = Double.NEGATIVE_INFINITY;
        for (double v : data) {
            if(v > max){
                max = v;
            }
        }
        return max;
    }

    private double[] derivate(double[] data){
        double[] derivatedData = new double[data.length];

        for (int i = 0; i < data.length; i++) {
            double a = data[i-2 < 0 ? 0 : i-2];
            double b = data[i-1 < 0 ? 0 : i-1];
            double c = data[i+1 > data.length-1 ? data.length-1: i+1];
            double d = data[i+2 > data.length-1 ? data.length-1: i+2];
            derivatedData[i] = (a - 8*b + 8*c -d)/12.0;
        }
        return derivatedData;
    }

    private double mean(double[] data){
        double sum = 0;
        for (double v : data) {
            sum+=v;
        }
        return sum/data.length;
    }
}
