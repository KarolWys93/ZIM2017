package KarolW.ZIM.QRSdetect;


import KarolW.ZIM.DSP.MeanFilter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Karol on 03-06-2017.
 */
public class QRSdetector {


    private double decisionThreshold;
    private int samplingFreq;
    private int[] qrsMarkers;


    public QRSdetector(int samplingFreq, double decisionThreshold) {
        this.samplingFreq = samplingFreq;
        this.decisionThreshold = decisionThreshold;
        qrsMarkers = null;
    }

    public int[] detectQRS(double[] data){
        qrsMarkers = decisionFunction(detectFunction(data));
        return qrsMarkers;
    }

    public int getHeartRate(int fromSample, int toSample){
        if(qrsMarkers == null) {
            return -1;
        }
        if (fromSample > toSample){
            throw new IllegalArgumentException(fromSample + " > " + toSample);
        }

        if(toSample > qrsMarkers.length){
            toSample = qrsMarkers.length;
        }


        int lastMarkerIndex = 0;
        double numOfMarkers = 0;
        double intervalSum = 0;

        for(int i = fromSample; i < toSample; i++){
            if(qrsMarkers[i] != 0){
                intervalSum += i-lastMarkerIndex;
                lastMarkerIndex = i;
                numOfMarkers++;
            }
        }

        double hrRate = ((intervalSum/numOfMarkers)*60)/samplingFreq;
        return (int) hrRate;
    }

    private int [] decisionFunction(double[] data){
        int[] result = new int[data.length];
        Set<Integer> qrsSampleNumbers = new HashSet<Integer>();
        int lastMaxIndex = Integer.MIN_VALUE;

        int detectWindowSize = samplingFreq/4; //detectWindowSize span 250 ms of signal
        int maxSpace = (int)(samplingFreq*0.35); //space between maxims has 350 ms

        for (int i = 0; i < data.length-detectWindowSize; i++) {
            int maxIndex = getMaxValueIndex(data, i, i+detectWindowSize);
            if(data[maxIndex] >= decisionThreshold){
                i = maxIndex;
                if (maxIndex - lastMaxIndex > maxSpace) {
                    if(lastMaxIndex >= 0) {
                        qrsSampleNumbers.add(lastMaxIndex);
                    }
                    lastMaxIndex = maxIndex;
                }else{
                    if((lastMaxIndex >= 0 ? data[lastMaxIndex] : Integer.MIN_VALUE) < data[maxIndex]){
                        lastMaxIndex = maxIndex;
                    }
                }
            }
        }
        for (Integer sampleNumber : qrsSampleNumbers) {
            result[sampleNumber] = 1;
        }

        return result;
    }

    private double[] detectFunction(double[] data){
        MeanFilter meanFilter = new MeanFilter(samplingFreq > 100 ? samplingFreq/5 : 8);

        double [] detectFcnData = derivative(data);

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

    private int getMaxValueIndex(double[] data){
        int index = 0;
        double max = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < data.length; i++) {
            if(data[i] > max){
                max = data[i];
                index = i;
            }
        }
        return index;
    }

    private int getMaxValueIndex(double[] data, int from, int to){
        int index = 0;
        double max = Double.NEGATIVE_INFINITY;

        if (from > to){
            throw new IllegalArgumentException(from + " > " + to);
        }

        if(data.length < to){
            to = data.length;
        }

        for (int i = from; i < to; i++) {
            if(data[i] > max){
                max = data[i];
                index = i;
            }
        }
        return index;
    }

    private double[] derivative(double[] data){
        double[] results = new double[data.length];

        for (int i = 0; i < data.length; i++) {
            double a = data[i-2 < 0 ? 0 : i-2];
            double b = data[i-1 < 0 ? 0 : i-1];
            double c = data[i+1 > data.length-1 ? data.length-1: i+1];
            double d = data[i+2 > data.length-1 ? data.length-1: i+2];
            results[i] = (a - 8*b + 8*c -d)/12.0;
        }
        return results;
    }

    private double mean(double[] data){
        double sum = 0;
        for (double v : data) {
            sum+=v;
        }
        return sum/data.length;
    }

    public double getDecisionThreshold() {
        return decisionThreshold;
    }

    public void setDecisionThreshold(double decisionThreshold) {
        this.decisionThreshold = decisionThreshold;
    }

    public int getSamplingFreq() {
        return samplingFreq;
    }

    public void setSamplingFreq(int samplingFreq) {
        this.samplingFreq = samplingFreq;
    }
}