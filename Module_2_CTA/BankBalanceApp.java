import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceApp extends JFrame implements ActionListener {
    private BankAccount account;
    private JLabel balanceLabel;
    private JTextField inputField;
    private JButton depositButton, withdrawButton;

    public BankBalanceApp() {
        account = new BankAccount(1000.00);

        setTitle("Jones Banking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Title Panel with Text, Logo, and Tagline
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(128, 0, 0)); // Maroon background
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS)); // Vertical layout for logo, title, and tagline

        // Load logo
        ImageIcon logoIcon = new ImageIcon("JonesBankingLogo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the logo

        // Add main title text
        JLabel titleLabel = new JLabel("Jones Banking");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(255, 215, 0)); // Gold color
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the title text

        // Add tagline text
        JLabel taglineLabel = new JLabel("Get your money right homie");
        taglineLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        taglineLabel.setForeground(Color.WHITE);
        taglineLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the tagline text

        // Add components to the title panel
        titlePanel.add(logoLabel);
        titlePanel.add(Box.createVerticalStrut(10)); // Space between logo and title
        titlePanel.add(titleLabel);
        titlePanel.add(Box.createVerticalStrut(5)); // Space between title and tagline
        titlePanel.add(taglineLabel);

        // Main Content Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10)); // Adjusted grid layout to fit links
        panel.setBackground(new Color(128, 0, 0));

        // Balance Label
        balanceLabel = new JLabel("Balance: $" + account.getBalance(), SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        balanceLabel.setForeground(new Color(255, 215, 0)); // Gold color
        panel.add(balanceLabel);

        // Input Field and Label
        JLabel inputLabel = new JLabel("Enter Amount:");
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        inputLabel.setForeground(Color.WHITE);
        inputLabel.setHorizontalAlignment(SwingConstants.CENTER);

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputField.setHorizontalAlignment(JTextField.CENTER);
        inputField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        inputField.setBackground(Color.LIGHT_GRAY);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(new Color(128, 0, 0));
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(inputField, BorderLayout.CENTER);
        panel.add(inputPanel);

        // Buttons
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        styleButton(depositButton, new Color(255, 215, 0));
        styleButton(withdrawButton, new Color(255, 69, 0));

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.setBackground(new Color(128, 0, 0));
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);

        panel.add(buttonPanel);

        // Links for Forgot Password and Create Account
        JPanel linkPanel = new JPanel();
        linkPanel.setBackground(new Color(128, 0, 0));
        linkPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel forgotPasswordLink = new JLabel("<html><a href=''>Forgot Password?</a></html>");
        forgotPasswordLink.setFont(new Font("Arial", Font.PLAIN, 14));
        forgotPasswordLink.setForeground(new Color(255, 215, 0)); // Gold color
        forgotPasswordLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgotPasswordLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JOptionPane.showMessageDialog(null, "Redirecting to Forgot Password page...");
            }
        });

        JLabel createAccountLink = new JLabel("<html><a href=''>Create an Account</a></html>");
        createAccountLink.setFont(new Font("Arial", Font.PLAIN, 14));
        createAccountLink.setForeground(new Color(255, 215, 0)); // Gold color
        createAccountLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createAccountLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JOptionPane.showMessageDialog(null, "Redirecting to Create Account page...");
            }
        });

        // Add links to the link panel
        linkPanel.add(forgotPasswordLink);
        linkPanel.add(Box.createHorizontalStrut(20)); // Space between links
        linkPanel.add(createAccountLink);

        // Add link panel to the main panel
        panel.add(linkPanel);

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        // Add panels to frame
        add(titlePanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void styleButton(JButton button, Color color) {
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        try {
            double amount = Double.parseDouble(inputField.getText());

            if (action.equals("Deposit")) {
                account.deposit(amount);
            } else if (action.equals("Withdraw")) {
                account.withdraw(amount);
            }

            balanceLabel.setText("Balance: $" + account.getBalance());
            inputField.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankBalanceApp::new);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}
