//Omer Winrauke - OwnerWindowPanel.java
import java.awt.*;
import java.awt.event.*;
import javax.swing. *;
import java.text.*;
import java.util.*;

public class OwnerWindowPanel extends JPanel
{
  private JLabel labelOwner, name, street, city, state, zipcode, pNumber, amount, accountNum, transactions, trans;
  private ArrayList<JLabel> labels = new ArrayList<JLabel>();
  private JButton back;
  private int g;
    public OwnerWindowPanel(int i)
    {
    g = i;
    NumberFormat money = NumberFormat.getCurrencyInstance();
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    back = new JButton(" Logout");
    back.addActionListener(new backButtonListener());
    setPreferredSize(new Dimension(550, 300));
    labelOwner = new JLabel(" Owner Page");
    name = new JLabel(" Name: " + AccountArrayList.accounts.get(i).getName());
    street = new JLabel(" Street: " + AccountArrayList.accounts.get(i).getStreet());
    city = new JLabel(" City: " + AccountArrayList.accounts.get(i).getCity());
    state = new JLabel(" State: " + AccountArrayList.accounts.get(i).getState());
    zipcode = new JLabel(" Zipcode: " + AccountArrayList.accounts.get(i).getZipcode());
    pNumber = new JLabel(" Phone Number: " + AccountArrayList.accounts.get(i).getPhoneNum());
    amount = new JLabel(" Balance: " + money.format(AccountArrayList.accounts.get(i).getValue()));
    accountNum = new JLabel(" Account Number: " + AccountArrayList.accounts.get(i).getAcountNum());
    trans = new JLabel(" Transaction History:");
    add(labelOwner);
    add(name);
    add(street);
    add(city);
    add(state);
    add(zipcode);
    add(pNumber);
    add(amount);
    add(accountNum);
    add(trans);
    for (int h = 1; h < AccountArrayList.accounts.get(i).getTransList().size(); h++) //gets the arraylist size and starts at one because of the space that is read in the beginning
    {
      Scanner scan = new Scanner(AccountArrayList.accounts.get(i).getTrans(h));
      char transType = scan.next().charAt(0);
      // if it is a deposit
      if (transType == 'd')
        transactions = new JLabel(" " + money.format(Double.parseDouble((scan.next()))) + " was deposited into your account on " + scan.nextLine());
      // if it is a withdraw
      else if (transType == 'w')
        transactions = new JLabel(" " + money.format(Double.parseDouble(scan.next())) + " was withdrawn from your account on " + scan.nextLine());
      // if it is a transfer
      else 
      {
        Double amount = scan.nextDouble();
        int accountNum = scan.nextInt();
        //if it is a transfer from or to
        if (amount < 0)
          transactions = new JLabel(" "+ money.format((-1*amount)) + " was wired from your account to account number " + accountNum + " on " + scan.nextLine());
        else 
          transactions = new JLabel(" "+money.format(amount) + " was wired to your account from account number " + accountNum + " on " + scan.nextLine());
      }
      //adds it to the labels arraylist
      labels.add(transactions);
      //adds it to the panel
      add(labels.get(h-1));
    }
    add(back);
    }
 
 private class backButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      MainWindowPanel panel = new MainWindowPanel();      
      remove(labelOwner);
      remove(name);
      remove(street);
      remove(city);
      remove(state);
      remove(zipcode);
      remove(pNumber);
      remove(amount);
      remove(accountNum);
      remove(back);
      remove(labelOwner);
      remove(trans);
      //we remove all the labels
      for (int h = 1; h < AccountArrayList.accounts.get(g).getTransList().size(); h++)
      {
        //starting at 1 because we already accounted for the space
        remove(labels.get(h-1));
      }
      revalidate();
      add(panel);
    }
  }
}