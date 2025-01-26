import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Java Form Control Examples");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 250);

            // Create buttons for different examples
            JButton textFieldExampleButton = new JButton("Text Field Example");
            JButton sliderExampleButton = new JButton("Slider Example");
            JButton buttonExampleButton = new JButton("Button Example");
            JButton layoutManagerExampleButton = new JButton("Layout Manager Example");
            JButton tablesExampleButton = new JButton("Table Example");
            JButton clockExampleButton = new JButton("Clock Example");

            // Attach action listeners to the buttons
            textFieldExampleButton.addActionListener(e -> new TextFieldExample());
            sliderExampleButton.addActionListener(e -> new SliderExample());
            buttonExampleButton.addActionListener(e -> new ButtonExample());
            layoutManagerExampleButton.addActionListener(e -> new LayoutManagerExample());
            tablesExampleButton.addActionListener(e -> new TablesExample());
            clockExampleButton.addActionListener(e -> new ClockExample());
           

            // Add buttons to a panel
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(5, 1, 5, 5)); // Align buttons vertically with spacing
            panel.add(textFieldExampleButton);
            panel.add(sliderExampleButton);
            panel.add(buttonExampleButton);
            panel.add(layoutManagerExampleButton);
            panel.add(tablesExampleButton);
            panel.add(clockExampleButton);

            // Add the panel to the frame
            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

// The existing classes for TextFieldExample, SliderExample, ButtonExample, and LayoutManagerExample remain unchanged.

class TextFieldExample extends JFrame {
    TextFieldExample() {
        setTitle("Text Field Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel();
        JTextField textField = new JTextField(20);
        panel.add(new JLabel("Enter text: "));
        panel.add(textField);
        
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class SliderExample extends JFrame {
    SliderExample() {
        setTitle("Slider Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel();
        JSlider slider = new JSlider(0, 100, 50);
        slider.setMajorTickSpacing(20);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        panel.add(slider);
        
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class ButtonExample extends JFrame {
    ButtonExample() {
        setTitle("Button Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel();
        JButton button = new JButton("Click Me!");
        button.addActionListener(e -> JOptionPane.showMessageDialog(this, "Button clicked!"));
        panel.add(button);
        
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class LayoutManagerExample extends JFrame {
    LayoutManagerExample() {
        setTitle("Layout Manager Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setLayout(new GridLayout(2, 2, 5, 5));
        add(new JButton("Button 1"));
        add(new JButton("Button 2"));
        add(new JButton("Button 3"));
        add(new JButton("Button 4"));
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class TablesExample extends JFrame {
    TablesExample() {
        setTitle("Table Example");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create table column names
        String[] columnNames = {"ID", "Name", "Age", "Department"};

        // Create table data
        Object[][] data = {
            {1, "John Doe", 25, "Engineering"},
            {2, "Jane Smith", 30, "Marketing"},
            {3, "Mike Johnson", 35, "Finance"},
            {4, "Emily Davis", 28, "HR"}
        };

        // Create a table model and JTable
        JTable table = new JTable(data, columnNames);

        // Add the table to a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        add(scrollPane);

        // Make the frame visible
        setVisible(true);
    }
}
