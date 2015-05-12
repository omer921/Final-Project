//ManagerSignUpPanel.java
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ManagerSignUpPanel extends JPanel
{
  //manager sign up page
  private JLabel user, password, repassword;
  private JTextField tUser, tPassword, tRepassword;
  private JButton signUp, back;
  private String theUser, thePassword, theRepassword;
  private int page;
  public ManagerSignUpPanel(int i)
  {
    page = i;
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    signUp = new JButton("Sign Up");
    signUp.addActionListener(new oKButtonListener());
    back = new JButton("Back");
    back.addActionListener(new backButtonListener());
    user = new JLabel("User:");
    password = new JLabel("PIN:");
    repassword = new JLabel("Re-enter PIN:");
    tUser = new JTextField();
    tPassword = new JTextField();
    tRepassword = new JTextField();
    add(user);
    add(tUser);
    add(password);
    add(tPassword);
    add(repassword);
    add(tRepassword);
    add(signUp);
    add(back);
  }
  
  private class backButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    { //goes back to the manager page
      BankManagerPanel panel2 = new BankManagerPanel(page);      
      remove(user);
      remove(tUser);
      remove(password);
      remove(tPassword);
      remove(repassword);
      remove(tRepassword);
      remove(signUp);
      remove(back);
      revalidate();
      add(panel2);
    }
  }
  
  private class oKButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      //trying to catch for spaces
      theUser = tUser.getText();
      thePassword = tPassword.getText();
      theRepassword = tRepassword.getText();
      try
      {
        int space = theUser.indexOf(' ');
        theUser = theUser.substring(0, space);
      }
      catch (Exception e)
      {
      }
      
      try
      {
        int space = thePassword.indexOf(' ');
        theRepassword = theRepassword.substring(0, space);
        thePassword = thePassword.substring(0, space);
      }
      catch (Exception e)
      {
      }
      
      try
      {
        if (Tools.managerCheck(thePassword)) //if the pin is taken
        {
          if (thePassword.equals(theRepassword)) //if the pins match
          {
            if (Tools.numCheck(thePassword)) //if the pin is an actual number
            {
              System.out.println(theUser + " " + theRepassword + " sign up check");
              Tools.managerWriter(theUser, Integer.parseInt(thePassword));
              BankManagerPanel panel2 = new BankManagerPanel(page);      
              remove(user);
              remove(tUser);
              remove(password);
              remove(tPassword);
              remove(repassword);
              remove(tRepassword);
              remove(signUp);
              remove(back);
              revalidate();
              add(panel2);
              JOptionPane.showMessageDialog(null, "Your pin is: " + Integer.parseInt(thePassword));
            }
            else 
              JOptionPane.showMessageDialog(null, "Only numbers are alowed in the PIN.");
          }
          else 
            JOptionPane.showMessageDialog(null, "The pins do not match");
        }
        else 
          JOptionPane.showMessageDialog(null, "This pin is taken");
      }
      catch (Exception e)
      {
      }
      
    }
  }
}