package GUI;

import DSP.DigitalFilter;
import MITFormatReader.Channel;
import MITFormatReader.RecordMIT;
import QRSdetect.QRSdetector;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Karol on 18-06-2017.
 */
public class MainWindow extends JFrame {


    private JButton loadRecordBtn;
    private JButton analisisBtn;
    private JButton saveBtn;
    private JButton dspBtn;
    private JButton moreInfoBtn;
    private JLabel recordNameLbl;
    private JLabel recordChannelsNumLbl;
    private JLabel recordLengthLbl;
    private JLabel recordSampleFrqLbl;
    private JLabel channelDescLbl;
    private JLabel channelGarinLbl;
    private JLabel channelResLbl;
    private JPanel mainPanel;
    private JPanel ecgPanel;

    private ECGChart ecgChart;

    private JFileChooser fileChooser;
    private ExpandedRecordInfo expandInfo;

    private QRSAnalisisOptions analisisOptions;

    private RecordMIT ecgRecord;
    private Channel ecgChannel;
    private QRSdetector qrsDetector;

    private double[] ecgData;

    public MainWindow(String title) {
        super(title);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/icon-128px.png")));
        $$$setupUI$$$();
        getContentPane().add(mainPanel);


        fileChooser = new JFileChooser();

        loadRecordBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseRecordFile();
            }
        });
        moreInfoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expandInfo != null) {
                    expandInfo.setVisible(true);
                }
            }
        });
        analisisBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (analisisOptions.showDialog()) {
                    qrsDetector = analisisOptions.getQRSDetector();

                    int min = analisisOptions.getFromSampleNum();
                    int max = analisisOptions.getToSampleNum();
                    System.out.println("From: " + min + " To: " + max);
                    int[] qrsData = qrsDetector.detectQRS(ecgData, min, max);
                    ecgChart.setQRSMarkers(qrsData, ecgRecord.getSamplingFrequency());
                }
            }
        });
        dspBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterSignal();
            }
        });
    }

    private void chooseRecordFile() {
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("ECG record header (*.hea)", "hea");
        fileChooser.setFileFilter(fileFilter);
        int result = fileChooser.showOpenDialog(mainPanel);

        if (result == JFileChooser.APPROVE_OPTION) {
            System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                ecgRecord = new RecordMIT(fileChooser.getSelectedFile().getAbsolutePath());
            } catch (FileNotFoundException e1) {
                JOptionPane.showMessageDialog(null, "Open file error!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            ChannelChooser channelChooser = new ChannelChooser(ecgRecord, "Channel selection");


            if (channelChooser.showDialog()) {//channelChooser.getSelectedChannel() != null) {
                ecgChannel = channelChooser.getSelectedChannel();
                setInfo(ecgRecord, ecgChannel);
                expandInfo = new ExpandedRecordInfo(ecgRecord, ecgChannel, "Record info");

                try {
                    ecgData = ecgChannel.getData();
                    ecgChart.setData(ecgData, ecgRecord.getSamplingFrequency());
                    analisisOptions = new QRSAnalisisOptions(ecgRecord);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void filterSignal() {
        FilterDialog filterDialog = new FilterDialog(ecgRecord.getSamplingFrequency());

        if (filterDialog.showDialog()) {
            ArrayList<DigitalFilter> filters = filterDialog.getSelectedFilters();
            for (DigitalFilter filter : filters) {
                ecgData = filter.filter(ecgData);
            }
            ecgChart.setData(ecgData, ecgRecord.getSamplingFrequency());
            analisisOptions = new QRSAnalisisOptions(ecgRecord);
        }

    }

    private void setInfo(RecordMIT record, Channel channel) {
        recordNameLbl.setText(record.getRecordName());
        recordSampleFrqLbl.setText(record.getSamplingFrequency() + " Hz");
        recordChannelsNumLbl.setText(record.getChannels().length + "");
        recordLengthLbl.setText(record.getNumberOfSample() / record.getSamplingFrequency() + " s");
        channelDescLbl.setText(channel.getDescription());
        channelGarinLbl.setText(channel.getGain() + "");
        channelResLbl.setText(channel.getResolution() + "");

    }

    private void repaintECGChart() {

    }

    private void createUIComponents() {
        ecgPanel = new JPanel();
        ecgPanel.setLayout(new BorderLayout());

        ecgChart = new ECGChart();
        ChartPanel chartPanel = new ChartPanel(ecgChart.getChart());
        chartPanel.setRefreshBuffer(true);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setRangeZoomable(false);
        ecgPanel.add(chartPanel, BorderLayout.CENTER);

    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 2, new Insets(0, 5, 0, 5), -1, -1));
        mainPanel.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        loadRecordBtn = new JButton();
        loadRecordBtn.setIcon(new ImageIcon(getClass().getResource("/Images/file-48px.png")));
        loadRecordBtn.setText("");
        loadRecordBtn.setToolTipText("Load ECG record");
        panel2.add(loadRecordBtn, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        analisisBtn = new JButton();
        analisisBtn.setIcon(new ImageIcon(getClass().getResource("/Images/analysis-48px.png")));
        analisisBtn.setText("");
        analisisBtn.setToolTipText("QRS detection analisis");
        panel2.add(analisisBtn, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        saveBtn = new JButton();
        saveBtn.setIcon(new ImageIcon(getClass().getResource("/Images/save-48px.png")));
        saveBtn.setText("");
        saveBtn.setToolTipText("Save results");
        panel2.add(saveBtn, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dspBtn = new JButton();
        dspBtn.setIcon(new ImageIcon(getClass().getResource("/Images/dsp-48px.png")));
        dspBtn.setText("");
        dspBtn.setToolTipText("Signal processing functions");
        panel2.add(dspBtn, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel3, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(588, 36), null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel4.setToolTipText("Record file information");
        panel3.add(panel4, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        panel4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Record info:"));
        final JLabel label1 = new JLabel();
        label1.setText("Name: ");
        panel4.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Chanels: ");
        panel4.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Length: ");
        panel4.add(label3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Samples/sec:");
        panel4.add(label4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        recordNameLbl = new JLabel();
        recordNameLbl.setText("");
        panel4.add(recordNameLbl, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        recordChannelsNumLbl = new JLabel();
        recordChannelsNumLbl.setText("");
        panel4.add(recordChannelsNumLbl, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        recordLengthLbl = new JLabel();
        recordLengthLbl.setText("");
        panel4.add(recordLengthLbl, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        recordSampleFrqLbl = new JLabel();
        recordSampleFrqLbl.setText("");
        panel4.add(recordSampleFrqLbl, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel5.setToolTipText("Selected channel information");
        panel3.add(panel5, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        panel5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Chanel info:"));
        final JLabel label5 = new JLabel();
        label5.setText("Description:");
        panel5.add(label5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Resolution: ");
        panel5.add(label6, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Gain:");
        panel5.add(label7, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        channelDescLbl = new JLabel();
        channelDescLbl.setText("");
        panel5.add(channelDescLbl, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        channelResLbl = new JLabel();
        channelResLbl.setText("");
        panel5.add(channelResLbl, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        channelGarinLbl = new JLabel();
        channelGarinLbl.setText("");
        panel5.add(channelGarinLbl, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        moreInfoBtn = new JButton();
        moreInfoBtn.setIcon(new ImageIcon(getClass().getResource("/Images/info-48px.png")));
        moreInfoBtn.setText("");
        moreInfoBtn.setToolTipText("Show more info");
        panel3.add(moreInfoBtn, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel6, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        panel6.add(ecgPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
