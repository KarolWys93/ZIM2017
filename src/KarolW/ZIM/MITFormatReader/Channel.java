package KarolW.ZIM.MITFormatReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Karol on 02-06-2017.
 * @author Karol Wyskocki
 */

public class Channel {

    private String filePath;
    private String formatName;
    private double gain;
    private int resolution;
    private String description;
    private int byteOffset;
    private int channelsInFile;
    private int length;

    public Channel(String filePath, String formatName, double gain, int resolution,
                   String description, int byteOffset, int channelsInFile, int length) {
        this.filePath = filePath;
        this.formatName = formatName;
        this.gain = gain;
        this.resolution = resolution;
        this.description = description;
        this.byteOffset = byteOffset;
        this.length = length;
        this.channelsInFile = channelsInFile;
    }


    public int[] getRawData() throws IOException {
        int[] rawData = new int[length];
        File dataFile = new File(filePath);
        FileInputStream fis = new FileInputStream(dataFile);



        byte[] sample = new byte[2];
        int sampleNumber = 0;

        for (int i = 0; i < length * channelsInFile; i++) {
            if(fis.read(sample) == -1){
                break;
            }
            if ((i % channelsInFile) == byteOffset) {

                if ((sample[1] & (0x80)) == 0x80) {
                    rawData[sampleNumber++] = (0xFFFF0000 | ((sample[1] & 0xFF) << 8) | ((sample[0] & 0xFF)));
                } else {
                    rawData[sampleNumber++] = ((sample[1]) << 8) | ((sample[0]));
                }
            }
        }
        fis.close();
        return rawData;
    }

    public double[] getData() throws IOException {
        int[] rawData = getRawData();
        double[] data = new double[rawData.length];

        for (int i = 0; i < data.length; i++){
            data[i] = (double)rawData[i]/gain;
        }
        return data;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getFormatName() {
        return formatName;
    }

    public double getGain() {
        return gain;
    }

    public int getResolution() {
        return resolution;
    }

    public String getDescription() {
        return description;
    }

    public int getByteOffset() {
        return byteOffset;
    }

    public int getLength() {
        return length;
    }

    public int getChannelsInFile() {
        return channelsInFile;
    }


    @Override
    public String toString() {
        return "Channel{" +
                "filePath='" + filePath + '\'' +
                ", formatName='" + formatName + '\'' +
                ", gain=" + gain +
                ", resolution=" + resolution +
                ", description='" + description + '\'' +
                ", byteOffset=" + byteOffset +
                ", channelsInFile=" + channelsInFile +
                ", length=" + length +
                '}';
    }
}
