import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TablesExample extends JFrame {

    public TablesExample() {
        // Set the title and default close operation for the frame
        setTitle("Table Example");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create table column names
        String[] columnNames = {"ID", "Name", "Age", "Department"};

        // Create table data
        Object[][] data = {
            {1, "John Doe", 25, "Engineering"},
            {2, "Brianna Lanpher", 30, "Out of Work Ass 🤣"},
            {3, "Mike Johnson", 35, "Finance"},
            {4, "Emily Davis", 28, "HR"}
        };

        // Create a table model and JTable
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);

        // Add the table to a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        add(scrollPane);

        // Make the frame visible
        setVisible(true);
    }

    // Main method for testing (optional if integrated into Main.java)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TablesExample::new);
    }
}
