import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MenuInterfaceApp extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JMenuItem dateTimeMenuItem, saveToFileMenuItem, changeColorMenuItem, exitMenuItem;

    public MenuInterfaceApp() {
        // Frame Settings
        setTitle("User Interface with Menu");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create Text Area
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setBackground(new Color(0, 0, 0, 0));
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Create Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        // Create Menu Items
        dateTimeMenuItem = new JMenuItem("Print Date & Time");
        saveToFileMenuItem = new JMenuItem("Save to File");
        changeColorMenuItem = new JMenuItem("Change Background Color");
        exitMenuItem = new JMenuItem("Exit");

        // Add Action Listener to Menu Items
        dateTimeMenuItem.addActionListener(this);
        saveToFileMenuItem.addActionListener(this);
        changeColorMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);

        // Add Items to Menu
        menu.add(dateTimeMenuItem);
        menu.add(saveToFileMenuItem);
        menu.add(changeColorMenuItem);
        menu.add(exitMenuItem);

        // Add Menu to Menu Bar
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Set initial background color to white
        getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dateTimeMenuItem) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateTime = formatter.format(new Date());
            textArea.setText("Current Date & Time: " + dateTime);
        } 
        else if (e.getSource() == saveToFileMenuItem) {
            try (FileWriter writer = new FileWriter("log.txt")) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "Text saved to log.txt", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error writing to file!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        else if (e.getSource() == changeColorMenuItem) {
            Color newGreenHue = generateRandomGreenHue();
            getContentPane().setBackground(newGreenHue);
            textArea.setBackground(newGreenHue);
            changeColorMenuItem.setText("Background: " + getHexColor(newGreenHue));
            JOptionPane.showMessageDialog(this, "Background color set to " + getHexColor(newGreenHue),
                    "Color Changed", JOptionPane.INFORMATION_MESSAGE);
        } 
        else if (e.getSource() == exitMenuItem) {
            System.exit(0);
        }
    }

    private Color generateRandomGreenHue() {
        Random rand = new Random();
        int red = rand.nextInt(56);
        int green = 150 + rand.nextInt(106);
        int blue = rand.nextInt(56);
        return new Color(red, green, blue);
    }

    private String getHexColor(Color color) {
        return String.format("#%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuInterfaceApp().setVisible(true));
    }
}
