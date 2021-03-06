//CustomerLookUpPanel.java
import java.awt.*;
import java.awt.event.*;
import javax. swing. *;
import java.text.*;

//this is where the manager looks up the customer 
public class CustomerLookUpPanel extends JPanel
{
  private JLabel customer;
  private JTextField customerNum;
  private JButton lookUp, back;
  private JLabel labelOwner, name, street, city, state, zipcode, pNumber, amount, accountNum, transactions, trans;
  private String customerNumber;
  private NumberFormat money = NumberFormat.getCurrencyInstance();
  private int page;
  public CustomerLookUpPanel(int i)
  {
    page = i;
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    back = new JButton("Back");
    back.addActionListener(new backButtonListener());
    customer = new JLabel("What is the account number?");
    customerNum = new JTextField(10);
    lookUp = new JButton("Look Up");
    lookUp.addActionListener(new lookUpButtonListener());
    name = new JLabel(" Name: ");
    street = new JLabel(" Street: ");
    city = new JLabel(" City: ");
    state = new JLabel(" State: ");
    zipcode = new JLabel(" Zipcode: ");
    pNumber = new JLabel(" Phone Number: ");
    amount = new JLabel(" Balance: ");
    accountNum = new JLabel(" Account Number: ");
    add(customer);
    add(customerNum);
    add(lookUp);
    add(name);
    add(street);
    add(city);
    add(state);
    add(zipcode);
    add(pNumber);
    add(amount);
    add(accountNum);
    add(back);
  }
  
  
  private class lookUpButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      try 
      {
        //try to get the account information 
        customerNumber = customerNum.getText();
        int i = Integer.parseInt(customerNumber);
        name.setText(" Name: " + AccountArrayList.accounts.get(i).getName());
        street.setText(" Street: " + AccountArrayList.accounts.get(i).getStreet());
        city.setText(" City: " + AccountArrayList.accounts.get(i).getCity());
        state.setText(" State: " + AccountArrayList.accounts.get(i).getState());
        zipcode.setText(" Zipcode: " + AccountArrayList.accounts.get(i).getZipcode());
        pNumber.setText(" Phone Number: " + AccountArrayList.accounts.get(i).getPhoneNum());
        amount.setText(" Balance: " + money.format(AccountArrayList.accounts.get(i).getValue()));
        accountNum.setText(" Account Number: " + AccountArrayList.accounts.get(i).getAcountNum());
      }
      catch (Exception e)
      {
        //but if an invalid number or character was entered then it will say that there was an invalid account number
        JOptionPane.showMessageDialog(null, "Invalid account number.");
      }
      
    }
  }
  
  private class backButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    { //takes the user back to the manager page
      BankManagerPanel panel = new BankManagerPanel(page);      
      remove(customer);
      remove(customerNum);
      remove(lookUp);
      remove(name);
      remove(street);
      remove(city);
      remove(state);
      remove(zipcode);
      remove(pNumber);
      remove(amount);
      remove(accountNum);
      remove(back); 
      revalidate();
      add(panel);
    }
  }
}