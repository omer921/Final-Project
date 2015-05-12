//Omer Winrauke ClerkPanel.java
import java.awt.*;
import java.awt.event.*;
import javax. swing. *;

public class ClerkPanel extends JPanel
{
  private JLabel clerkLabel;
  private JButton back, withdraw, deposit, transaction;
  public ClerkPanel()
  {
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    transaction = new JButton("Transaction");
    withdraw = new JButton("Withdraw");
    deposit = new JButton("Deposit");
    back = new JButton("Logout");
    transaction.addActionListener(new transactionButtonListener());
    withdraw.addActionListener(new withdrawButtonListener());
    deposit.addActionListener(new depositButtonListener());
    back.addActionListener(new backButtonListener());
    clerkLabel = new JLabel("Clerk Panel");
    setPreferredSize(new Dimension(550, 300));
    add(clerkLabel);
    add(transaction);
    add(withdraw);
    add(deposit);
    add(back);
  }
  private class backButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    { //takes the user back to the main screen 
      MainWindowPanel panel = new MainWindowPanel();      
      remove(withdraw);
      remove(deposit);
      remove(back);
      remove(clerkLabel);
      remove(transaction);
      revalidate();
      add(panel);
    }
  }
  private class withdrawButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    { //takes the user back to the withdraw panel
      WithdrawPanel panel = new WithdrawPanel();      
      remove(withdraw);
      remove(deposit);
      remove(back);
      remove(clerkLabel);
      remove(transaction);
      revalidate();
      add(panel);
    }
  }
  private class depositButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    { //takes the user back to the deposit panel
      DepositPanel panel = new DepositPanel();      
      remove(withdraw);
      remove(deposit);
      remove(back);
      remove(clerkLabel);
      remove(transaction);
      revalidate();
      add(panel);
    }
  }
  
  private class transactionButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    { //takes the user back to the transaction panel
      TransactionPanel panel = new TransactionPanel();      
      remove(withdraw);
      remove(deposit);
      remove(back);
      remove(clerkLabel);
      remove(transaction);
      revalidate();
      add(panel);
    }
  }
}