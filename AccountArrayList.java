//AccountArrayList.java (AR)
import java.io.*;
import java.util.*;
//this class is initialized when the program is run, it reads in all the data from the customer file and from there creates
//new account objects by giving it the username, password, and account number
public class AccountArrayList
{
  static ArrayList<Account> accounts = new ArrayList<Account>();
  public static void arrayList() throws IOException
  {
    Scanner scan = new Scanner(new File("customers.txt"));
    Account account;
    while (scan.hasNext())
    {
      String user = scan.next();
      String pass = scan.next();
      int number = scan.nextInt();
      account = new Account(user, pass, number);
      accounts.add(account);
    }
      System.out.println(accounts);//used for debugging purposes, so I won't forget the usernames and passwords. 
  }
}