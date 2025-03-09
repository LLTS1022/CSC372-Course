import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

// I wanted to change the program to a GUI app. In this instace, Student class remains mostly unchanged
class Student {
    private String name;
    private String address;
    private double GPA;

    public Student(String name, String address, double GPA) {
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", GPA: " + GPA;
    }
}

public class StudentRecordsGUI extends JFrame {
    // List to hold student records
    private LinkedList<Student> studentList;

    // Table to display records
    private DefaultTableModel tableModel;

    private JTable table;

    // Input fields
    private JTextField nameField, addressField, gpaField;

    private final Color backgroundColor = new Color(140, 31, 40); // Maroon
    private final Color accentColor = new Color(255, 184, 28); // Gold
    private final Color textColor = Color.WHITE;

    public StudentRecordsGUI() {
        studentList = new LinkedList<>();

        setTitle("CSU Global Student Records");
        setSize(650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(backgroundColor);

        // -- LOGO PANEL --
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(backgroundColor);

        // Load the CSU Global logo
        ImageIcon csuGlobalIcon = new ImageIcon("CSUGlobal.png");
        JLabel logoLabel = new JLabel(csuGlobalIcon);
        logoPanel.add(logoLabel);

        // Title Panel
        JLabel titleLabel = new JLabel("CSU Global Student Records", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(accentColor);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBackground(backgroundColor);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Labels and text fields for student data
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(textColor);
        nameField = new JTextField();

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setForeground(textColor);
        addressField = new JTextField();

        JLabel gpaLabel = new JLabel("GPA:");
        gpaLabel.setForeground(textColor);
        gpaField = new JTextField();

        // Buttons for adding a student and clearing fields
        JButton addButton = new JButton("Add Student");
        addButton.setBackground(accentColor);
        addButton.setForeground(backgroundColor);

        JButton clearButton = new JButton("Clear Fields");
        clearButton.setBackground(accentColor);
        clearButton.setForeground(backgroundColor);

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);
        inputPanel.add(gpaLabel);
        inputPanel.add(gpaField);
        inputPanel.add(addButton);
        inputPanel.add(clearButton);

        // -- TABLE --
        tableModel = new DefaultTableModel(new Object[] { "Name", "Address", "GPA" }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        // Optionally set table colors
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(table);

        // -- SAVE BUTTON --
        JButton saveButton = new JButton("Save Records to File");
        saveButton.setBackground(accentColor);
        saveButton.setForeground(backgroundColor);

        // Action listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                writeToFile();
            }
        });

        // Layout setup
        setLayout(new BorderLayout(10, 10));
        // Top region: Logo + Title
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(backgroundColor);
        topPanel.add(logoPanel, BorderLayout.NORTH);
        topPanel.add(titleLabel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);
    }

    // Method to add a new student after validating input
    private void addStudent() {
        String name = nameField.getText().trim();
        String address = addressField.getText().trim();
        String gpaText = gpaField.getText().trim();

        if (name.isEmpty() || address.isEmpty() || gpaText.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill in all fields.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        double gpa;
        try {
            gpa = Double.parseDouble(gpaText);
            if (gpa < 0.0 || gpa > 4.0) {
                JOptionPane.showMessageDialog(this,
                        "GPA must be between 0.0 and 4.0.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid numeric GPA.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Student student = new Student(name, address, gpa);
        studentList.add(student);
        updateTable();
        clearFields();
    }

    // Update the table after sorting by student name
    private void updateTable() {
        Collections.sort(studentList, Comparator.comparing(Student::getName));
        tableModel.setRowCount(0);
        for (Student s : studentList) {
            tableModel.addRow(new Object[] { s.getName(), s.getAddress(), s.getGPA() });
        }
    }

    // Clear input fields
    private void clearFields() {
        nameField.setText("");
        addressField.setText("");
        gpaField.setText("");
    }

    // Write the student records to "students.txt"
    private void writeToFile() {
        try (FileWriter writer = new FileWriter("students.txt")) {
            for (Student s : studentList) {
                writer.write(s.toString() + "\n");
            }
            JOptionPane.showMessageDialog(this,
                    "Student records saved to students.txt",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error writing to file: " + e.getMessage(),
                    "File Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main method to launch the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentRecordsGUI gui = new StudentRecordsGUI();
            gui.setVisible(true);
        });
    }
}
