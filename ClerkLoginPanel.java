//ClerkLoginPanel.java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ClerkLoginPanel extends JPanel
{ //this is where the clerks login
  private JLabel userName, passName;
  private JTextField user, pass;
  private String userText, passText;
  private JButton oK, back;
  public ClerkLoginPanel()
  {
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    userName = new JLabel("User:");
    passName = new JLabel("Password:");
    user = new JTextField(8);
    pass = new JTextField(8);
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
    {//takes the user back to the main page
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
      userText = user.getText();
      passText = pass.getText();
      
      try
      { //tries to compensate for if the user entered a space after the username or password
       int space = passText.indexOf(' ');
       passText = passText.substring(0, space);
      }
      catch (Exception e)
      {
      }
      
      try
      {
       int space = userText.indexOf(' ');
       userText = userText.substring(0, space);
      }
      catch (Exception e)
      {
      }
      
      for (int i = 0; i < ClerkArrayList.clerks.size(); i++)
      {
        if (userText.compareTo(ClerkArrayList.clerks.get(i).getUser() + "") == 0)
        {
          if (passText.compareTo(ClerkArrayList.clerks.get(i).getPassword() + "") == 0)
          {
            
            ClerkPanel panel1 = new ClerkPanel();      
            remove(userName);
            remove(user);
            remove(passName);
            remove(pass);
            remove(oK);
            remove(back);
            revalidate();
            add(panel1);
            break;//if we found a user break the for loop because we do not want to load more panels or continue the loop. 
          }
        }
      }
    }
  }
}
