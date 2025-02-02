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
        // this will be the frame Settings
        setTitle("UI with Menu");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // here I create Text Area
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setOpaque(true);  // Make it visible
        textArea.setBackground(Color.WHITE); // Default background
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Create Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        // Create Menu Items
        dateTimeMenuItem = new JMenuItem("Print Date & Time");
        saveToFileMenuItem = new JMenuItem("Save to File");
        changeColorMenuItem = new JMenuItem("Change Background Color"); // No initial color
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

        // **Make SURE to set the initial background color!!!!!**
        getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dateTimeMenuItem) {
            // Print out the Date & Time in Text Box
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateTime = formatter.format(new Date());
            textArea.setText("Current Date & Time: " + dateTime);
        } 
        else if (e.getSource() == saveToFileMenuItem) {
            // Write the Text Box Contents to File
            try (FileWriter writer = new FileWriter("log.txt")) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "Text saved to log.txt", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error writing to file!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        else if (e.getSource() == changeColorMenuItem) {
            // Generate a new random green hue
            Color newGreenHue = generateRandomGreenHue();

            // Change Background Color
            getContentPane().setBackground(newGreenHue);
            textArea.setBackground(newGreenHue);  // Ensure text area blends in

            // Update menu text with the new color hex
            changeColorMenuItem.setText("Background: " + getHexColor(newGreenHue));

            JOptionPane.showMessageDialog(this, "Background color set to " + getHexColor(newGreenHue),
                    "Tada... the color has been changed", JOptionPane.INFORMATION_MESSAGE);
        } 
        else if (e.getSource() == exitMenuItem) {
            // Exit the Program
            System.exit(0);
        }
    }

    // Method to Generate a Random Green Hue
    private Color generateRandomGreenHue() {
        Random rand = new Random();
        int red = rand.nextInt(56);       // Low red value (0-55)
        int green = 150 + rand.nextInt(106); // Strong green value (150-255)
        int blue = rand.nextInt(56);       // Low blue value (0-55)
        return new Color(red, green, blue);
    }

    // Convert Color to Hex for Display
    private String getHexColor(Color color) {
        return String.format("#%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
    }

    // Main Method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuInterfaceApp().setVisible(true));
    }
}
