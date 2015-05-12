//BankManagerLoginPanel.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankManagerLoginPanel extends JPanel
{
  private JLabel pin;
  private JTextField tPin;
  private JButton oK, back;
  private String thePin;
  public BankManagerLoginPanel() 
  {
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    pin = new JLabel("Pin:");
    tPin = new JTextField(40);
    oK = new JButton("Login");
    back = new JButton("Back");
    oK.addActionListener(new oKButtonListener());
    back.addActionListener(new backButtonListener());
    add(pin);
    add(tPin);
    add(oK);
    add(back);
  }
  
  private class backButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      //when the back button is clicked it takes the user back to the main window
      MainWindowPanel panel1 = new MainWindowPanel();      
      remove(pin);
      remove(tPin);
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
      //here we try to see if the user pressed the space bar and try to compensate for that
      try 
      {
        thePin = tPin.getText();
        int space = thePin.indexOf(' ');
        thePin = thePin.substring(0, space);
      }
      catch (Exception e) 
      {
        thePin = tPin.getText();
      }
      for (int i = 0; i < ManagerArrayList.managers.size(); i++)
      {
        if (thePin.compareTo(ManagerArrayList.managers.get(i).getPin() + "") == 0)
        {
          BankManagerPanel panel1 = new BankManagerPanel(i);      
          remove(pin);
          remove(tPin);
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