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
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS)); // Vertical layout

        // Load and resize the logo safely
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/JonesBankingLogo.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);

        JLabel logoLabel = new JLabel(resizedIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Main title
        JLabel titleLabel = new JLabel("Jones Banking");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(255, 215, 0)); // Gold color
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Tagline
        JLabel taglineLabel = new JLabel("Get Your Money Right, Hopefully ©");
        taglineLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        taglineLabel.setForeground(Color.WHITE);
        taglineLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add components to title panel
        titlePanel.add(Box.createVerticalStrut(10)); // Add spacing
        titlePanel.add(logoLabel);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(titleLabel);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(taglineLabel);

        // Wrap titlePanel inside a JPanel with FlowLayout for centering
        JPanel wrapperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        wrapperPanel.add(titlePanel);

        // Add title section to frame
        add(wrapperPanel, BorderLayout.NORTH);

        // Balance Label
        balanceLabel = new JLabel("Balance: $" + account.getBalance());
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(balanceLabel, BorderLayout.CENTER);

        // Input and Buttons Panel
        JPanel inputPanel = new JPanel();
        inputField = new JTextField(10);
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        inputPanel.add(new JLabel("Amount: "));
        inputPanel.add(inputField);
        inputPanel.add(depositButton);
        inputPanel.add(withdrawButton);

        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(inputField.getText());

            if (e.getSource() == depositButton) {
                account.deposit(amount);
            } else if (e.getSource() == withdrawButton) {
                if (!account.withdraw(amount)) {
                    JOptionPane.showMessageDialog(this, "Insufficient funds!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            balanceLabel.setText("Balance: $" + account.getBalance());
            inputField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount. Enter a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankBalanceApp::new);
    }
}

// BankAccount Class (Ensure this is in the same package)
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}
