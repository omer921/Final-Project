//Tools.java
import java.util.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Tools
{
  static Date date = new Date();
  //does the wire transfer
  public static void wireTransfer(Account acct1, Account acct2, double amount, int acct1Num, int acct2Num) throws IOException
  {
    final int LIMIT = 10000;
    double acct1Balance, acct2Balance;
    acct1Balance = acct1.getValue();
    acct2Balance = acct2.getValue();
    if (balanceChecker(acct1, amount)) //checks if the the account has enough money to transfer
    {
      if (amount < LIMIT) // if the amount is less than the limit then we transfer
      {
        wireWriter(acct1, acct2, amount, acct1Num, acct2Num);
      }
      else { // if not we need manager authorization
        String answer = JOptionPane.showInputDialog("Manager PIN required:"); 
        if (!(Tools.managerCheck(answer)))
        {
          wireWriter(acct1, acct2, amount, acct1Num, acct2Num);
        }
      }
    }
    else
      JOptionPane.showMessageDialog(null, "Insufficient funds.");
  }
  
  //adds a new clerk to the system  
  public static void clerkWriter(String name, String user, String password) throws IOException
  {
    FileWriter fw = new FileWriter ("clerks.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter fileOut = new PrintWriter (bw);
    fileOut.println(name + " " + user + " " + password);
    fileOut.close();
    Clerk c = new Clerk(name, user, password);
    ClerkArrayList.clerks.add(c);
  }
  
  //adds a new manager to the system
  public static void managerWriter(String user, int password) throws IOException
  {
    FileWriter fw = new FileWriter ("managers.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter fileOut = new PrintWriter (bw);
    System.out.println(user + " " + password + " new user");
    fileOut.println(user + " " + password);
    fileOut.close();
    Manager c = new Manager(user, password);
    System.out.println(user + " " + password + " after add new user");
    ManagerArrayList.managers.add(c);
  }
  //checks if the string inputed can be paresed into a number
  public static boolean numCheck(String num)
  {
    try 
    {
      double number = Double.parseDouble(num);
      return true;
    }
    catch (Exception e)
    {
      return false;
    }
  }
  //checks if the user name is taken or not
  public static boolean userCheck(String name)
  {
    boolean result = false;
    for (int i = 0; i < AccountArrayList.accounts.size(); i++)
    {
      if (name.equals(AccountArrayList.accounts.get(i).getUser()))
      {
        result = false;
        break;
      }
      else
        result = true;
    }
    return result;
  }
  //checks if the clerk user name is taken
  public static boolean clerkCheck(String name)
  {
    boolean result = false;
    for (int i = 0; i < ClerkArrayList.clerks.size(); i++)
    {
      if (name.compareTo(ClerkArrayList.clerks.get(i).getUser()) == 0)
      {
        result = false;
        break;
      }
      else
        result = true;
    }
    return result;
  }
  //checks if the manger name is taken
  public static boolean managerCheck(String pin)
  {
    boolean result = false;
    for (int i = 0; i < ManagerArrayList.managers.size(); i++)
    {
      if (!(pin.equals("")))
      {
        if ((Integer.parseInt(pin) - ManagerArrayList.managers.get(i).getPin()) == 0)
        {
          result = false;
          break;
        }
        else
        {
          result = true;
        }
      }
    }
    
    return result;
  }
  //checks if the amount is greated then the balance
  public static boolean balanceChecker(Account a, double amount)
  {
    boolean result = false;
    if(a.getValue() < amount)
      result = false;
    else
      result = true;
    return result;
  }
  
  //this writes out the the wire transfer and adds it to the system
  private static void wireWriter(Account acct1, Account acct2, double amount, int acct1Num, int acct2Num) throws IOException
  {
    JOptionPane.showMessageDialog(null, "Transfer Accepted.");
    FileWriter fw = new FileWriter (acct1Num+".txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter fileOut = new PrintWriter (bw);
    if (AccountArrayList.accounts.get(acct1Num).getTransList().size() == 0)
    {
      fileOut.println("");
      fileOut.println("t " + (-1*amount) + " " + acct2Num + " " + date);
      fileOut.close();
      acct1.addTransList("skip");
      acct1.addTransList("t " + (-1*amount) + " " + acct2Num + " " + date);
    }
    else
    {
      fileOut.println("t " + (-1*amount) + " " + acct2Num + " " + date);
      fileOut.close();
      acct1.addTransList("t " + (-1*amount) + " " + acct2Num + " " + date);
    }
    
    FileWriter fw2 = new FileWriter (acct2Num+".txt", true);
    BufferedWriter bw2 = new BufferedWriter(fw2);
    PrintWriter fileOut2 = new PrintWriter (bw2);
    if (AccountArrayList.accounts.get(acct2Num).getTransList().size() == 0)
    {
      fileOut2.println("");
      fileOut2.println("t " + amount + " " + acct1Num + " " + date);
      fileOut2.close();
      acct2.addTransList("skip");
      acct2.addTransList("t " + amount + " " + acct1Num + " " + date);
    }
    else 
    {
      fileOut2.println("t " + amount + " " + acct1Num + " " + date);
      fileOut2.close();
      acct2.addTransList("t " + amount + " " + acct1Num + " " + date);
    }
    acct1.setValue(-1*amount);
    acct2.setValue(amount);
  }
}