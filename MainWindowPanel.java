//Omer Winrauke - MainWindowPanel.java
import java.awt.*;
import java.awt.event.*;
import javax. swing. *;
import javax.swing.JOptionPane;


public class MainWindowPanel extends JPanel
{
  private JButton oK;
  private JLabel labelWelcome;
  private JRadioButton owner, newUser, manager, clerk;
  private OmerMutualSign sign = new OmerMutualSign();
  //draws the omer mutual logo
  public void paintComponent (Graphics page) //(DR)
  {
    super.paintComponent (page);
    sign.draw(page); 
  }
  
  public MainWindowPanel()
  {
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS)); //(LM)
    
    oK = new JButton("OK");
    owner = new JRadioButton("Bank Account Owner Login");
    newUser = new JRadioButton("Signup for a Bank Account");
    manager = new JRadioButton("Bank Manager");
    clerk = new JRadioButton("Bank Clerk");
    oK.addActionListener(new oKButtonListener());
    labelWelcome = new JLabel(" Welcome to Omer Mutual Bank, What would you like to login as?");
    ButtonGroup group = new ButtonGroup();//making sure they toggle
    
//groups the buttons so that when one is clicked the other one is unselected
    group.add(owner); //(GUI1)
    group.add(newUser);
    group.add(manager);
    group.add(clerk);

    add(labelWelcome); //(GUI2)
    add(newUser);
    add(owner);
    add(manager);
    add(clerk);
    add(oK); //(GUI3)
    
    setPreferredSize(new Dimension(550, 500));
  }
  
  private class oKButtonListener implements ActionListener //(LI)
  {
    public void actionPerformed(ActionEvent event) 
    {
      //when the ok button it checks which radio button was clicked
      if (owner.isSelected())
      { //goes to bank account login
        BankAccountLoginPanel owner1 = new BankAccountLoginPanel();
        remove(labelWelcome);
        remove(owner);
        remove(newUser);
        remove(manager);
        remove(clerk);
        remove(oK);
        revalidate();
        repaint();
        add(owner1);
      }
      
      else if (newUser.isSelected())
      { //goes to sign up a new user
        SignUpPanel newUser1 = new SignUpPanel();
        remove(labelWelcome);
        remove(owner);
        remove(newUser);
        remove(manager);
        remove(clerk);
        remove(oK);
        revalidate();
        repaint();
        add(newUser1);
      }
      else if (manager.isSelected())
      {//goes to bank manager login
        BankManagerLoginPanel manager1 = new BankManagerLoginPanel();
        remove(labelWelcome);
        remove(owner);
        remove(newUser);
        remove(manager);
        remove(clerk);
        remove(oK);
        revalidate();
        repaint();
        add(manager1);
      }
      else if (clerk.isSelected())
      {//goes to clerk login
        ClerkLoginPanel manager1 = new ClerkLoginPanel();
        remove(labelWelcome);
        remove(owner);
        remove(newUser);
        remove(manager);
        remove(clerk);
        remove(oK);
        revalidate();
        repaint();
        add(manager1);
      }
      else //if none of the buttons were selected it says so
        JOptionPane.showMessageDialog(null, "You have not selcted anything!");
    }
  }
}