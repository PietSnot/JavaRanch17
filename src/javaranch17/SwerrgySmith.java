/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch17;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Piet
 */
public class SwerrgySmith {
    public static void main(String... args) {
        new MainFrame("effe kieken...");
    }
}

class MainFrame extends JFrame {

    private JLabel countLabel = new JLabel("0");
    private JButton startButton = new JButton("start");

    public MainFrame(String title) {
        this.setTitle(title);
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(countLabel);
        this.add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                start();
            }
        });

        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    protected void start() {
        System.out.println("in method 'start': running from EDT? " + SwingUtilities.isEventDispatchThread());
        for (int i = 0; i < 5; i++) {
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countLabel.setText("Current Value : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
