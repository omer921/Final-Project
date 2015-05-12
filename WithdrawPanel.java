//Omer Winrauke WithdrawPanel.java
import java.awt.*;
import java.awt.event.*;
import javax. swing. *;
import java.io.*;

public class WithdrawPanel extends JPanel
{
  private JLabel acct, amount;
  private JTextField tAcct, tAmount;
  private String theAcct, theAmount;
  private JButton back, withdraw;
  private final int MAX_TRANSFER = 10000;
  public WithdrawPanel()
  {
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    back = new JButton("Back");
    withdraw = new JButton("Withdraw");
    acct = new JLabel("Account:");
    amount = new JLabel("Amount:");
    tAcct = new JTextField();
    tAmount = new JTextField();
    withdraw.addActionListener(new withdrawButtonListener());
    back.addActionListener(new backButtonListener());
    setPreferredSize(new Dimension(550, 300));
    add(acct);
    add(tAcct);
    add(amount);
    add(tAmount);
    add(withdraw);
    add(back);
  }
  
  private class backButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    { //takes the user back to the clerk panel
      ClerkPanel panel = new ClerkPanel();      
      remove(acct);
      remove(amount);
      remove(tAcct);
      remove(tAmount);
      remove(withdraw);
      remove(back);
      revalidate();
      add(panel);
    }
  }
  
  private class withdrawButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {//accounting for spaces
      try 
      {
        theAcct = tAcct.getText();
        theAmount = tAmount.getText();
        System.out.println(theAcct);
        if (theAcct.equals(""))
        {
          JOptionPane.showMessageDialog(null, "There is nothing the in the account text box!");
        }
        else
        {
          if (theAmount.equals(""))
          {
            JOptionPane.showMessageDialog(null, "There is nothing the in the account text box!");
          }
          else 
          {
            if (!(Tools.numCheck(theAcct))) //checks if the account number is an actual number 
              JOptionPane.showMessageDialog(null, "Invalid bank account.");
            else if (Integer.parseInt(theAcct) < 0 || Integer.parseInt(theAcct) >= AccountArrayList.accounts.size()) //checks if it is in range
              JOptionPane.showMessageDialog(null, "Invalid bank account.");
            else if (!(Tools.numCheck(theAmount)))//checks if the amount is an actual number
              JOptionPane.showMessageDialog(null, "Invalid amount.");
            else if (Double.parseDouble(theAmount) <= 0) //checks if the amount if not negative
              JOptionPane.showMessageDialog(null, "Invalid amount.");
            else
            {
              if (Tools.balanceChecker(AccountArrayList.accounts.get(Integer.parseInt(theAcct)), Double.parseDouble(theAmount)))
              { //checks if the balance is sufficient
              if ((Double.parseDouble(theAmount)) < MAX_TRANSFER)
              {
                AccountArrayList.accounts.get(Integer.parseInt(theAcct)).setValue('w', Double.parseDouble(theAmount));
                JOptionPane.showMessageDialog(null, "Withdraw Accepted.");
                System.out.println("Executed");
                //pop up screen 
                ClerkPanel panel = new ClerkPanel();      
                remove(acct);
                remove(amount);
                remove(tAcct);
                remove(tAmount);
                remove(withdraw);
                remove(back);
                revalidate();
                add(panel);
              }
              else 
              {
                String answer = JOptionPane.showInputDialog("Manager PIN required:"); 
                if (!(Tools.managerCheck(answer)))
                {
                  AccountArrayList.accounts.get(Integer.parseInt(theAcct)).setValue('w', Double.parseDouble(theAmount));
                  JOptionPane.showMessageDialog(null, "Withdraw Accepted.");
                  ClerkPanel panel = new ClerkPanel();      
                  remove(acct);
                  remove(amount);
                  remove(tAcct);
                  remove(tAmount);
                  remove(withdraw);
                  remove(back);
                  revalidate();
                  add(panel);
                }
                else 
                {
                  JOptionPane.showMessageDialog(null, "Invalid Manager PIN.");
                  ClerkPanel panel = new ClerkPanel();      
                  remove(acct);
                  remove(amount);
                  remove(tAcct);
                  remove(tAmount);
                  remove(withdraw);
                  remove(back);
                  revalidate();
                  add(panel);
                }
                
              }
            }
              else 
                JOptionPane.showMessageDialog(null, "Insuficient funds.");
            }
          }
        }
      }
      catch (IOException e) 
      {
        
      }
    }
  }
}