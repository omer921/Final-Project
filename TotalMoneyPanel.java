//TotalMoneyPanel.java
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.*;

public class TotalMoneyPanel extends JPanel
{
  private JLabel totalMoney;
  private JLabel totalMoneyLabel;
  private double totalMoneyVar;
  private JButton back;
  private int page;
  public TotalMoneyPanel(int i)
  {
    page = i;
    NumberFormat money = NumberFormat.getCurrencyInstance();
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    back = new JButton("Back");
    back.addActionListener(new backButtonListener());
    for (int g = 0; g < AccountArrayList.accounts.size(); g++) //adds all the money together from all the users
      totalMoneyVar += AccountArrayList.accounts.get(g).getValue();
    totalMoney = new JLabel(" Total Money in the bank:");
    //puts it in the label
    totalMoneyLabel = new JLabel(" "+money.format(totalMoneyVar) + " between " + AccountArrayList.accounts.size() + " customers"); 
    add(totalMoney);
    add(totalMoneyLabel);
    add(back);
  }
  
  private class backButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {//takes the user back to the manager page
      BankManagerPanel panel1 = new BankManagerPanel(page);      
      remove(totalMoney);
      remove(totalMoneyLabel);
      remove(back);
      revalidate();
      add(panel1);
    }
  }
}