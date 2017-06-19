import GUI.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    private static String appName = "ECG QRS detector";

    private static JFrame frame;

    public static void main(String[] args) {


        // frame.setIconImage();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                runGUI();
            }
        });
    }

    private static void runGUI(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame = new MainWindow(appName);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                closeApp();
            }
        });

        frame.setBounds(100,100,800,600);

        frame.setVisible(true);
    }

    static void closeApp(){
        int selection = JOptionPane.showConfirmDialog(
                null,
                "Exit "+appName+"?",
                "Confirm exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if(selection == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
}