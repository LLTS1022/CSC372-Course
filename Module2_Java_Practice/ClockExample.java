//write a program that counts the number of clock to a button labeled time

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClockButton extends JFrame {
    private JButton timeButton;
    private int count = 0;
    public ClockButton() {
        timeButton = new JButton("Time");
        timeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                timeButton.setText("Time: " + count);
            }
        });
        add(timeButton);
        }
        public static void main(String[] args) {
            
            new ClockButton().setVisible(true);
            }
            }
