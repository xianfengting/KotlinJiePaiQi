package com.src_resources.metronome;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppMainFrame extends JFrame {
    private long lastRecordedTime = System.currentTimeMillis();

    private JPanel mainPanel;
    private JLabel tipLabel;
    private JButton recordButton;
    private JLabel tipLabel2;

    AppMainFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        Thread t = new Thread(() -> {
            while (true) {
                long currentTime = System.currentTimeMillis();
                double betweenTime = (currentTime - lastRecordedTime) / 1000.0;
                if (betweenTime == 0.0) {
                    tipLabel2.setText("你的手速太快了");
                } else {
                    double bpm = 60.0 / betweenTime;
                    tipLabel2.setText("当前BPM: " + bpm);
                }
            }
        });
        t.setDaemon(true);
        t.start();

        recordButton.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mousePressed(MouseEvent e) {
                long currentTime = System.currentTimeMillis();
                double betweenTime = (currentTime - lastRecordedTime) / 1000.0;
                if (betweenTime == 0.0) {
                    tipLabel.setText("你的手速太快了");
                } else {
                    double bpm = 60.0 / betweenTime;
                    tipLabel.setText("BPM: " + bpm);
                    lastRecordedTime = currentTime;
                }
            }
        });
    }
}
