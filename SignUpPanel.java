//Omer Winrauke SignUpPanel.java
import java.awt.*;
import java.awt.event.*;
import javax. swing. *;
import java.io.*;

public class SignUpPanel extends JPanel
{
  private JLabel user, pass, pass2, signUpLabel, name, street, city, state, zipcode, pNumber;
  private JTextField tUser, tPass, tPass2, tName, tStreet, tCity, tState, tZipcode, tPnumber;
  private String theUser, thePass, thePass2, theName, theStreet, theState, theCity, theZip, thePnum;
  private JButton back, signUp;
  
  public SignUpPanel() 
  {
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    back = new JButton("Back");
    signUp = new JButton("Sign Up");
    signUp.addActionListener(new signUpButtonListener());
    back.addActionListener(new backButtonListener());
    signUpLabel = new JLabel("Sign Up Page");
    user = new JLabel("User: (Without Spaces!)");
    pass = new JLabel("Password:");
    pass2 = new JLabel("Re-enter Password:");
    name = new JLabel("Name:");
    street = new JLabel("Street:");
    city = new JLabel("City:");
    state = new JLabel("State");
    zipcode = new JLabel("Zipcode:");
    pNumber = new JLabel("Phone Number:");
    tUser = new JTextField(8);
    tPass = new JTextField(8);
    tPass2 = new JTextField(8);
    tName = new JTextField(8);
    tStreet = new JTextField(8);
    tCity = new JTextField(8);
    tState = new JTextField(8);
    tZipcode = new JTextField(8);
    tPnumber = new JTextField(8);
    //tPnumber.addActionListener(new tNumberListener());
    add(user);
    add(tUser);
    add(pass);
    add(tPass);
    add(pass2);
    add(tPass2);
    add(name);
    add(tName);
    add(street);
    add(tStreet);
    add(city);
    add(tCity);
    add(state);
    add(tState);
    add(zipcode);
    add(tZipcode);
    add(pNumber);
    add(tPnumber);
    add(signUp);
    add(back);
  }
  
  private class backButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    { //takes them back to the main window
      MainWindowPanel panel = new MainWindowPanel();      
      remove(user);
      remove(tUser);
      remove(pass);
      remove(tPass);
      remove(pass2);
      remove(tPass2);
      remove(name);
      remove(tName);
      remove(street);
      remove(tStreet);
      remove(city);
      remove(tCity);
      remove(state);
      remove(tState);
      remove(zipcode);
      remove(tZipcode);
      remove(pNumber);
      remove(tPnumber);
      remove(signUp);
      remove(back);
      revalidate();
      add(panel);
      
    }
  } 
  
/*  private class tNumberListener implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {
      theUser = tUser.getText(); 
      thePass = tPass.getText(); 
      theName = tName.getText(); 
      theStreet = tStreet.getText(); 
      theCity = tCity.getText(); 
      theState = tState.getText(); 
      theZip = tZipcode.getText(); 
      thePnum = tPnumber.getText();
      
    }
  }*/
  
  private class signUpButtonListener implements ActionListener 
  {
    public void actionPerformed(ActionEvent event) 
    { //accounting for spaces
      theUser = tUser.getText();
      try 
      {
        theUser = theUser.replace(' ', '_');
      }
      catch (Exception e)
      {
      }
      thePass = tPass.getText();
      thePass2 = tPass2.getText();
      if (thePass.equals(thePass2)) //if the passwords were equal
      {
        theName = tName.getText(); 
        theStreet = tStreet.getText(); 
        theCity = tCity.getText(); 
        theState = tState.getText(); 
        theZip = tZipcode.getText(); 
        if (Tools.numCheck(theZip)) //if the zipcode is an acutal number
        {
          thePnum = tPnumber.getText();
          if (Tools.numCheck(thePnum)) // if the phone number is an actual number
          {
            if (Tools.userCheck(theUser)) // if the user does not match any other user
            {
              try {
                UserWriter.fileWriter(theUser, thePass, thePass2, theName, theStreet, theState, theCity, theZip, thePnum);
                MainWindowPanel panel = new MainWindowPanel();      
                remove(user);
                remove(tUser);
                remove(pass);
                remove(tPass);
                remove(pass2);
                remove(tPass2);
                remove(name);
                remove(tName);
                remove(street);
                remove(tStreet);
                remove(city);
                remove(tCity);
                remove(state);
                remove(tState);
                remove(zipcode);
                remove(tZipcode);
                remove(pNumber);
                remove(tPnumber);
                remove(signUp);
                remove(back);
                revalidate();
                add(panel);
                JOptionPane.showMessageDialog(null, "Your username is: " + theUser + " password: " + thePass);
              }
              catch (IOException e) {
                //oh noes!
              }
            }
            else 
              JOptionPane.showMessageDialog(null, "This user name is taken");
          }
          
          else 
            JOptionPane.showMessageDialog(null, "This is not a real phone number");
        }
        else 
          JOptionPane.showMessageDialog(null, "This is not a real Zipcode");
      }
      else 
        JOptionPane.showMessageDialog(null, "Your passwords do not match!");
    }
  } 
  
}