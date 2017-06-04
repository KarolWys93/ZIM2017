package KarolW.ZIM.MITFormatReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Karol on 02-06-2017.
 */
public class RecordMIT {

    private String filePath;
    private String recordName;
    private int samplingFrequency;
    private int numberOfSample;
    private String info;
    private Channel[] channels;


    public RecordMIT(String pathName) throws FileNotFoundException {
        filePath = pathName;
        File headerFile = new File(filePath);
        FileInputStream fis = new FileInputStream(headerFile);
        Scanner fileScanner = new Scanner(fis);

        HashMap<String, Integer> chInFile = new HashMap<>();

        String firstLine [] = fileScanner.nextLine().split(" ");

        this.recordName = firstLine[0];
        int numberOfChannel = Integer.parseInt(firstLine[1]);
        this.samplingFrequency = Integer.parseInt(firstLine[2]);
        this.numberOfSample = Integer.parseInt(firstLine[3]);

        channels = new Channel[numberOfChannel];
        String[] channelLine = new String[channels.length];

        for(int i = 0; i < channelLine.length; i++){
            if(!fileScanner.hasNext()){
                break;
            }
            channelLine[i] = fileScanner.nextLine();
            String fileName = channelLine[i].split(" ")[0].trim();
            chInFile.put(fileName, chInFile.containsKey(fileName) ? chInFile.get(fileName)+1 : 1);
        }

        StringBuilder infoBuilder = new StringBuilder();
        while (fileScanner.hasNextLine()) {
            infoBuilder.append(fileScanner.nextLine()+System.lineSeparator());
        }
        info = infoBuilder.toString();
        fileScanner.close();

        int offset = 0;
        for(int i = 0; i < channels.length; i++){
            String[] channelInfo = channelLine[i].split(" ");
            StringBuilder desc = new StringBuilder();
            for(int j = 8; j < channelInfo.length; j++){
                desc.append(channelInfo[j]+" ");
            }
            if(offset >= chInFile.get(channelInfo[0])){
                offset = 0;
            }
            channels[i] = new Channel(
                    headerFile.getParent() + File.separator + channelInfo[0],
                    channelInfo[1],
                    Double.parseDouble(channelInfo[2]),
                    Integer.parseInt(channelInfo[3]),
                    desc.toString(),
                    offset++,
                    chInFile.get(channelInfo[0]),
                    numberOfSample);
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public String getRecordName() {
        return recordName;
    }

    public int getSamplingFrequency() {
        return samplingFrequency;
    }

    public int getNumberOfSample() {
        return numberOfSample;
    }

    public String getInfo() {
        return info;
    }

    public Channel[] getChannels() {
        return channels;
    }

    @Override
    public String toString() {
        return "RecordMIT{" +
                "filePath='" + filePath + '\'' +
                ", recordName='" + recordName + '\'' +
                ", samplingFrequency=" + samplingFrequency +
                ", numberOfSample=" + numberOfSample +
                ", info='" + info + '\'' +
                '}';
    }
}
