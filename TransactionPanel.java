//TransactionPanel.java
import java.awt.*;
import java.awt.event.*;
import javax. swing. *;
import java.io.*;

public class TransactionPanel extends JPanel
{
  private JLabel acct1, acct2, amount;
  private JTextField tAcct1, tAcct2, tAmount;
  private JButton back, transfer;
  private String theAcct, theAcct2, theAmount;
  public TransactionPanel()
  {
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    back = new JButton("Back");
    transfer = new JButton("Transfer");
    transfer.addActionListener(new transferButtonListener());
    acct1 = new JLabel("Account From:");
    acct2 = new JLabel("Account To:");
    amount = new JLabel("Amount:");
    tAcct1 = new JTextField();
    tAcct2 = new JTextField();
    tAmount = new JTextField();
    back.addActionListener(new backButtonListener());
    setPreferredSize(new Dimension(550, 300));
    add(acct1);
    add(tAcct1);
    add(acct2);
    add(tAcct2);
    add(amount);
    add(tAmount);
    add(transfer);
    add(back);
  }
  
  private class backButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    { //takes the user back to the clerk panel
      ClerkPanel panel = new ClerkPanel();      
      remove(acct1);
      remove(tAcct1);
      remove(acct2);
      remove(tAcct2);
      remove(amount);
      remove(tAmount);
      remove(transfer);
      remove(back);
      revalidate();
      add(panel);
    }
  }
  
  private class transferButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      try {
        theAcct = tAcct1.getText();
        theAcct2 = tAcct2.getText();
        theAmount = tAmount.getText();
        if (!(Tools.numCheck(theAcct))) //if the account is an actual number
              JOptionPane.showMessageDialog(null, "Invalid bank account.");
        else if (!(Tools.numCheck(theAcct2)))  //if the account is an actual number
              JOptionPane.showMessageDialog(null, "Invalid bank account.");
        else if (!(Tools.numCheck(theAmount))) //if the amount is an actual number
              JOptionPane.showMessageDialog(null, "Invalid amount.");
        else if (Integer.parseInt(theAcct) < 0 || Integer.parseInt(theAcct) >= AccountArrayList.accounts.size()) //if the account number is in range
          JOptionPane.showMessageDialog(null, "Invalid bank account.");
        else if (Integer.parseInt(theAcct2) < 0 || Integer.parseInt(theAcct2) >= AccountArrayList.accounts.size()) //if the account number is in range
          JOptionPane.showMessageDialog(null, "Invalid bank account.");
        else if (Double.parseDouble(theAmount) <= 0) //checks if the amount is greater than zero
          JOptionPane.showMessageDialog(null, "Invalid amount");
        else 
        {
          Tools.wireTransfer(AccountArrayList.accounts.get(Integer.parseInt(theAcct)), AccountArrayList.accounts.get(Integer.parseInt(theAcct2)), Double.parseDouble(theAmount), Integer.parseInt(theAcct), Integer.parseInt(theAcct2));
          ClerkPanel panel = new ClerkPanel();   
          remove(acct1);
          remove(tAcct1);
          remove(acct2);
          remove(tAcct2);
          remove(amount);
          remove(tAmount);
          remove(transfer);
          remove(back);
          revalidate();
          add(panel);
        }
      }
      catch (IOException e) 
      {
        //oh noes!
      }
    }
  }
} 