//Omer Winrauke BankManagerPanel.java
import java.awt.*;
import java.awt.event.*;
import javax. swing. *;

public class BankManagerPanel extends JPanel
{
  private JLabel bankManagerLabel;
  private JButton back, newClerk, newManager, totalMoney, customerLookUp;
  private int page;
  //This is where the manager logs in. 
  public BankManagerPanel(int i) //there is a parameter because it shows the name of the manager logged in
    {
      page = i; //this page variable is used to set which manager is logged in on all the other manager related pages
      setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
      newClerk = new JButton("New Clerk");
      newClerk.addActionListener(new signUpButtonListener());
      newManager = new JButton("New Manager");
      newManager.addActionListener(new newManagerButtonListener());
      totalMoney = new JButton("Total Money in Bank");
      totalMoney.addActionListener(new totalMoneyButtonListener());
      customerLookUp = new JButton("Customer Lookup");
      customerLookUp.addActionListener(new customerLookUpListener());
      back = new JButton("Logout");
      bankManagerLabel = new JLabel("Welcome " + ManagerArrayList.managers.get(i).getName());
      back.addActionListener(new backButtonListener());
      setPreferredSize(new Dimension(550, 300));
      add(bankManagerLabel);
      add(newClerk);
      add(newManager);
      add(totalMoney);
      add(customerLookUp);
      add(back);
    }

 private class backButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      //takes the user back to the main page
      MainWindowPanel panel1 = new MainWindowPanel();      
      remove(newClerk);
      remove(newManager);
      remove(totalMoney);
      remove(back);
      remove(bankManagerLabel);
      remove(customerLookUp);
      revalidate();
      add(panel1);
    }
  }
 
 private class customerLookUpListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      //takes the user to the customer lookup page
      CustomerLookUpPanel panel1 = new CustomerLookUpPanel(page);      
      remove(newClerk);
      remove(newManager);
      remove(totalMoney);
      remove(back);
      remove(bankManagerLabel);
      remove(customerLookUp);
      revalidate();
      add(panel1);
    }
  }
 
 private class signUpButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      //takes user to the clerk sign up page
      ClerkSignUpPanel panel1 = new ClerkSignUpPanel(page);      
      remove(newClerk);
      remove(newManager);
      remove(totalMoney);
      remove(back);
      remove(bankManagerLabel);
      remove(customerLookUp);
      revalidate();
      add(panel1);
    }
  }
 
 private class newManagerButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      //takes user to manager sign up page
      ManagerSignUpPanel panel1 = new ManagerSignUpPanel(page);      
      remove(newClerk);
      remove(newManager);
      remove(totalMoney);
      remove(back);
      remove(bankManagerLabel);
      remove(customerLookUp);
      revalidate();
      add(panel1);
    }
  }
 
 private class totalMoneyButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      TotalMoneyPanel panel1 = new TotalMoneyPanel(page);      
      remove(newClerk);
      remove(newManager);
      remove(totalMoney);
      remove(back);
      remove(bankManagerLabel);
      remove(customerLookUp);
      revalidate();
      add(panel1);
    }
  }
}