//BankAccountLoginPanel.java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.ArrayList;
//this is where users login to the account to see the balance and the transaction history 
public class BankAccountLoginPanel extends JPanel
{
  private JLabel userName, passName;
  private JTextField user, pass;
  private JButton oK, back;
  private ArrayList<Account> accounts = new ArrayList<Account>();
  private Account account;
  private String userText, passwordText;
  
  public BankAccountLoginPanel()
  {
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    userName = new JLabel("User: (Case Sensitive)");
    passName = new JLabel("Password:");
    user = new JTextField(19);
    pass = new JTextField(19);
    oK = new JButton("Login");
    oK.addActionListener(new oKButtonListener());
    back = new JButton("Back");
    back.addActionListener(new backButtonListener());
    add(userName);
    add(user);
    add(passName);
    add(pass);
    add(oK);
    add(back);
  }
  
  private class backButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      //when the back button is clicked it takes the user back to the main window
      MainWindowPanel panel1 = new MainWindowPanel();      
      remove(userName);
      remove(user);
      remove(passName);
      remove(pass);
      remove(oK);
      remove(back);
      revalidate();
      add(panel1);      
    }
  }
  
  private class oKButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      //if the ok button is clicked it will try to check if the user name and passwords match anything in the file. 
      try 
      {
        userText = user.getText(); 
        passwordText = pass.getText(); 
        //here we try to see if the user pressed the space bar and try to compensate for that
        userText = user.getText(); 
        passwordText = pass.getText(); 
        int spaceU = userText.indexOf(" ");
        int spaceP = passwordText.indexOf(" ");
        userText = userText.substring(0, spaceU);
        passwordText = passwordText.substring(0, spaceP);
      }
      catch (Exception e)
      {
        
      }
      for (int i = 0; i < AccountArrayList.accounts.size(); i++)
      {
        if (userText.compareTo(AccountArrayList.accounts.get(i).getUser() + "") == 0)
        {
          if (passwordText.compareTo(AccountArrayList.accounts.get(i).getPassword() + "") == 0)
          {
            OwnerWindowPanel panel1 = new OwnerWindowPanel(i);      
            remove(userName);
            remove(user);
            remove(passName);
            remove(pass);
            remove(oK);
            remove(back);
            revalidate();
            add(panel1);
            break; //if we found a user break the for loop because we do not want to load more panels or continue the loop. 
          }
        }
      }
    }
  }
}