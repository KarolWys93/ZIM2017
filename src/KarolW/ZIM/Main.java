package KarolW.ZIM;

import KarolW.ZIM.MITFormatReader.RecordMIT;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        int channel = 0;
        JDialog dialog = new JDialog();
        FileDialog fdialog = new FileDialog(dialog, "Potato");
        fdialog.setVisible(true);

        String path = fdialog.getDirectory();
        String fileName = fdialog.getFile();
        RecordMIT record = null;
        try {
            record = new RecordMIT(path + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(record.toString());

        try {
            System.out.println(record.getChannels()[channel].toString());
            int samples[] = record.getChannels()[channel].getRawData();
            for(int sample : samples){
                System.out.println(sample);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(record.getInfo());
        System.exit(0);

//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }
}
