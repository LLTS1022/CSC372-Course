import javax.swing.*;

public class TextFieldExample extends JFrame {
    public TextFieldExample() {
        setTitle("Text Field Example");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 100);

        JTextField textField = new JTextField(20);
        JLabel label = new JLabel("Enter text:");

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);

        add(panel);
        setVisible(true);
    }
}
