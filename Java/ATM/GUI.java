import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI {
    private JPanel panel1;
    private JButton withdraw;
    private JButton balance;
    private JButton deposit;
    private JTextField ATMTextField;
    private JTextArea ATMOutPut;
    private JLabel messageLabel;
    private JButton transfer;
    private ATM atm1;
    private ATM atm2;


    public GUI() {

        atm1 = new ATM("Spider-man", 101, 500);
        atm2 = new ATM("Tony Start", 102, 500);

        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(ATMTextField.getText());
                    String result = atm1.witdraw(amount);
                    ATMOutPut.setText(result);
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Please enter a valid amount for withdrawal.");
                }
            }
        });
        deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(ATMTextField.getText());
                    String result = atm1.deposit(amount);
                    ATMOutPut.setText(result);
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Please enter a valid amount for deposit.");
                }
            }
        });
        balance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String balance = "ATM1 Balance: $" + atm1.getBalance() + "\nATM2 Balance: $" + atm2.getBalance();
                ATMOutPut.setText(balance);
            }
        });

        transfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(ATMTextField.getText());
                    String result = atm1.transfer(atm2, amount);
                    ATMOutPut.setText(result);
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Please enter a valid amount for transfer.");
                }
            }
        });
    }
        public static void main (String[] args){
            JFrame frame = new JFrame("BANK ATM");
            frame.setContentPane(new GUI().panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(505, 500);
            frame.setVisible(true);
        }
    }
