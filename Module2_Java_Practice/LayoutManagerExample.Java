import javax.swing.*;
import java.awt.*;

public class LayoutManagerExample extends JFrame {
    JPanel flowLayoutPanel1, flowLayoutPanel2, gridLayoutPanel1, gridLayoutPanel2, gridLayoutPanel3;
    JButton one, two, three, four, five, six;
    JLabel bottom, lbl1, lbl2, lbl3;

    // Constructor
    public LayoutManagerExample() {
        setTitle("Layout Manager Example");
        setLayout(new BorderLayout()); // Set BorderLayout for JFrame

        // FlowLayout (Top - North)
        flowLayoutPanel1 = new JPanel();
        one = new JButton("One");
        two = new JButton("Two");
        three = new JButton("Three");
        flowLayoutPanel1.setLayout(new FlowLayout(FlowLayout.CENTER)); // Set FlowLayout Manager
        flowLayoutPanel1.add(one);
        flowLayoutPanel1.add(two);
        flowLayoutPanel1.add(three);

        // FlowLayout (Bottom - South)
        flowLayoutPanel2 = new JPanel();
        bottom = new JLabel("This is South");
        flowLayoutPanel2.setLayout(new FlowLayout(FlowLayout.CENTER)); // Set FlowLayout Manager
        flowLayoutPanel2.add(bottom);

        // GridLayouts (Center)
        gridLayoutPanel1 = new JPanel();
        gridLayoutPanel2 = new JPanel();
        gridLayoutPanel3 = new JPanel();

        lbl1 = new JLabel("One");
        lbl2 = new JLabel("Two");
        lbl3 = new JLabel("Three");

        four = new JButton("Four");
        five = new JButton("Five");
        six = new JButton("Six");

        // Inner GridLayout (Top of Center)
        gridLayoutPanel2.setLayout(new GridLayout(1, 3, 5, 5)); // Set GridLayout Manager
        gridLayoutPanel2.add(lbl1);
        gridLayoutPanel2.add(lbl2);
        gridLayoutPanel2.add(lbl3);

        // Inner GridLayout (Bottom of Center)
        gridLayoutPanel3.setLayout(new GridLayout(3, 1, 5, 5)); // Set GridLayout Manager
        gridLayoutPanel3.add(four);
        gridLayoutPanel3.add(five);
        gridLayoutPanel3.add(six);

        // Outer GridLayout (Combines the above two)
        gridLayoutPanel1.setLayout(new GridLayout(2, 1)); // Set GridLayout Manager
        gridLayoutPanel1.add(gridLayoutPanel2);
        gridLayoutPanel1.add(gridLayoutPanel3);

        // Add panels to JFrame
        add(flowLayoutPanel1, BorderLayout.NORTH);
        add(flowLayoutPanel2, BorderLayout.SOUTH);
        add(gridLayoutPanel1, BorderLayout.CENTER);

        // JFrame Settings
        setSize(400, 325);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE to allow returning to Main
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
