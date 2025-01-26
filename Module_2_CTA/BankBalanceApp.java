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
        account = new BankAccount(1000.0); 

        
        setTitle("CSU Global Banking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250); 
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); 

      
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10)); 
        panel.setBackground(new Color(128, 0, 0)); 

        
        balanceLabel = new JLabel("Balance: $" + account.getBalance(), SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        balanceLabel.setForeground(new Color(255, 215, 0)); // Gold color
        panel.add(balanceLabel);

       
        JLabel inputLabel = new JLabel("Enter amount:");
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

       
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        styleButton(depositButton, new Color(255, 215, 0)); 
        styleButton(withdrawButton, new Color(255, 69, 0)); 

        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.setBackground(new Color(128, 0, 0)); 
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);

        panel.add(buttonPanel);

      
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        
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
