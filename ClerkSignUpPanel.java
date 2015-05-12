//ClerkSignUpPanel.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//this is where the manager signs up the clerk
public class ClerkSignUpPanel extends JPanel
{
  private JLabel name, user, password, repassword;
  private JTextField tName, tUser, tPassword, tRepassword;
  private String theName, theUser, thePassword, theRepassword;
  private JButton signUp, back;
  private int page;
  public ClerkSignUpPanel(int i)
  {
    page = i;
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    signUp = new JButton("Sign Up");
    signUp.addActionListener(new oKButtonListener());
    back = new JButton("Back");
    back.addActionListener(new backButtonListener());
    user = new JLabel("User:");
    password = new JLabel("Password:");
    repassword = new JLabel("Re-enter Password");
    name = new JLabel("Full Name");
    tUser = new JTextField(8);
    tName = new JTextField();
    tPassword = new JTextField();
    tRepassword = new JTextField();
    add(name);
    add(tName);
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
    {
      BankManagerPanel panel2 = new BankManagerPanel(page);      
      remove(name);
      remove(tName);
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
      theUser = tUser.getText(); 
      thePassword = tPassword.getText();
      theRepassword = tRepassword.getText();
      try //trying to account for the spaces 
      {
        theName = tName.getText(); 
        theName = theName.replace(' ', '_');
        theUser = theUser.replace(' ', '_');
      }
      catch(Exception e)
      {
        theName = tName.getText(); 
        theUser = tUser.getText(); 
      }
      if (Tools.clerkCheck(theUser)) //checks if the user name is already takes.
      {
        if (thePassword.equals(theRepassword)) //checks if the passwords match
        {
          try //try because clerkWriter throws IOException
          {
            Tools.clerkWriter(theName, theUser, thePassword);
            BankManagerPanel panel2 = new BankManagerPanel(page);      
            remove(name);
            remove(tName);
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
            JOptionPane.showMessageDialog(null, "Your user name is: " + theUser + " Password: " + thePassword); //gives the user name and password
          }
          catch (Exception e)
          {
          }
        }
        else 
          JOptionPane.showMessageDialog(null, "The passwords do not match.");
      }
      else 
        JOptionPane.showMessageDialog(null, "This user name is taken.");
    }
  }
}
