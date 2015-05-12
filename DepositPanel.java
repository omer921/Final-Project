//Omer Winrauke DepositPanel.java
import java.awt.*;
import java.awt.event.*;
import javax. swing. *;
import java.io.*;

public class DepositPanel extends JPanel
{
  private JLabel acct, amount;
  private JTextField tAcct, tAmount;
  private String theAcct, theAmount;
  private JButton back, deposit;
  private final int MAX_TRANSFER = 10000;
  public DepositPanel()
  {
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    back = new JButton("Back");
    deposit = new JButton("Deposit");
    acct = new JLabel("Account:");
    amount = new JLabel("Amount:");
    tAcct = new JTextField();
    tAmount = new JTextField();
    deposit.addActionListener(new depositButtonListener());
    back.addActionListener(new backButtonListener());
    setPreferredSize(new Dimension(550, 300));
    add(acct);
    add(tAcct);
    add(amount);
    add(tAmount);
    add(deposit);
    add(back);
  }
  
  private class backButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    { //takes the user back to the clerk page
      ClerkPanel panel = new ClerkPanel();      
      remove(acct);
      remove(amount);
      remove(tAcct);
      remove(tAmount);
      remove(deposit);
      remove(back);
      revalidate();
      add(panel);
    }
  }
  
  private class depositButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      try //accounting for spaces
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
            JOptionPane.showMessageDialog(null, "There is nothing the in the amount text box!");
          }
          else 
          {
            if (!(Tools.numCheck(theAcct)))  //checks the the account number is an actual number
              JOptionPane.showMessageDialog(null, "Invalid bank account.");
            else if (Integer.parseInt(theAcct) < 0 || Integer.parseInt(theAcct) >= AccountArrayList.accounts.size())
              JOptionPane.showMessageDialog(null, "Invalid bank account."); //checks if the account number is out of range
            else if (!(Tools.numCheck(theAmount))) //checks if the amount is an actual number
              JOptionPane.showMessageDialog(null, "Invalid amount.");
            else if (Double.parseDouble(theAmount) <= 0) //checks if the ammount is negative
              JOptionPane.showMessageDialog(null, "Invalid amount");
            else{
              if ((Double.parseDouble(theAmount)) < MAX_TRANSFER) // if the the amount is less than the MAX_TRANSFER then no manager pin is needed
              {
              AccountArrayList.accounts.get(Integer.parseInt(theAcct)).setValue('d', Double.parseDouble(theAmount));
              JOptionPane.showMessageDialog(null, "Deposit Accepted.");
              System.out.println("Executed");
              //pop up screen 
              ClerkPanel panel = new ClerkPanel();      
              remove(acct);
              remove(amount);
              remove(tAcct);
              remove(tAmount);
              remove(deposit);
              remove(back);
              revalidate();
              add(panel);
              }
              else 
              {
                String answer = JOptionPane.showInputDialog("Manager PIN required:"); //a manager pin is needed
                if (!(Tools.managerCheck(answer)))//checks if the pin matches any other pin
                {
                  AccountArrayList.accounts.get(Integer.parseInt(theAcct)).setValue('d', Double.parseDouble(theAmount));
                  JOptionPane.showMessageDialog(null, "Deposit Accepted.");
                  System.out.println("Executed");
                  //pop up screen 
                  ClerkPanel panel = new ClerkPanel();      
                  remove(acct);
                  remove(amount);
                  remove(tAcct);
                  remove(tAmount);
                  remove(deposit);
                  remove(back);
                  revalidate();
                  add(panel);
                }
                else 
                {
                  JOptionPane.showMessageDialog(null, "Invalid Manager PIN."); // if it doesn't we can't authorize the deposit
                  ClerkPanel panel = new ClerkPanel();      
                  remove(acct);
                  remove(amount);
                  remove(tAcct);
                  remove(tAmount);
                  remove(deposit);
                  remove(back);
                  revalidate();
                  add(panel);
                }
              }
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