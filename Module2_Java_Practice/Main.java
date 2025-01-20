import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Java Form Control Examples");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);

            JButton textFieldExampleButton = new JButton("Text Field Example");
            JButton sliderExampleButton = new JButton("Slider Example");
            JButton buttonExampleButton = new JButton("Button Example");
            JButton layoutManagerExampleButton = new JButton("Layout Manager Example");

            textFieldExampleButton.addActionListener(e -> new TextFieldExample());
            sliderExampleButton.addActionListener(e -> new SliderExample());
            buttonExampleButton.addActionListener(e -> new ButtonExample());
            layoutManagerExampleButton.addActionListener(e -> new LayoutManagerExample());

            JPanel panel = new JPanel();
            panel.add(textFieldExampleButton);
            panel.add(sliderExampleButton);
            panel.add(buttonExampleButton);
            panel.add(layoutManagerExampleButton);

            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

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
