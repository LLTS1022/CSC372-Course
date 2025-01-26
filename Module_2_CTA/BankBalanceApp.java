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
        account = new BankAccount(1000.0); // Default initial balance

        setTitle("Bank Balance Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        balanceLabel = new JLabel("Balance: $" + account.getBalance());
        panel.add(balanceLabel);

        inputField = new JTextField();
        panel.add(new JLabel("Enter amount: "));
        panel.add(inputField);

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        panel.add(depositButton);
        panel.add(withdrawButton);

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
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
}
