import javax.swing.*;

public class SliderExample extends JFrame {
    public SliderExample() {
        setTitle("Slider Example");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 100);

        JSlider slider = new JSlider(0, 100, 50);
        JLabel label = new JLabel("Move the slider:");

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(slider);

        add(panel);
        setVisible(true);
    }
}
