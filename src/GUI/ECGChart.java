package GUI;

import javax.swing.*;

import MITFormatReader.Channel;
import MITFormatReader.RecordMIT;
import javafx.scene.chart.Chart;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryMarker;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.plot.XYPlot;
import org.jfree.experimental.chart.plot.CombinedXYPlot;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Karol on 19-06-2017.
 */
public class ECGChart {

    private XYDataset ecgDataSet;
    private JFreeChart chart;
    private XYPlot plot;

    private ArrayList<Marker> markers;

    public ECGChart() {
        XYItemRenderer renderer = new XYLineAndShapeRenderer(true, false);
        renderer.setSeriesPaint(0, Color.blue);
        ValueAxis domainAxis = new NumberAxis("time [s]");
        domainAxis.setLowerMargin(0.0);
        domainAxis.setUpperMargin(0.02);
        ValueAxis rangeAxis = new NumberAxis("mV");
        plot = new XYPlot(ecgDataSet, domainAxis, rangeAxis, renderer);
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setDomainPannable(true);

        chart = new JFreeChart(plot);
        chart.removeLegend();
        chart.setAntiAlias(true);

    }

    public void setData(double[] ecgData, int samplingFrequency){
        plot.clearDomainMarkers();
        XYSeries data = new XYSeries("ECG signal");
        for (int i = 0; i < ecgData.length; i++) {
            data.add(i/(double)samplingFrequency, ecgData[i]);
        }
        ecgDataSet = new XYSeriesCollection(data);
        plot.setDataset(ecgDataSet);
    }

    public void setQRSMarkers(int[] qrsDetSamples, int samplingFrequency){

        plot.clearDomainMarkers();

        for (int i = 0; i < qrsDetSamples.length; i++) {
            if(qrsDetSamples[i] > 0){
                Marker marker = new ValueMarker(i/(double)samplingFrequency);
                marker.setPaint(Color.RED);
                marker.setStroke(new BasicStroke(1.0f,
                        BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
                plot.addDomainMarker(marker);
            }
        }
    }

    public JFreeChart getChart() {
        return chart;
    }

    public void clearPlots(){
        plot.clearDomainMarkers();
        plot.setDataset(null);
    }



}
