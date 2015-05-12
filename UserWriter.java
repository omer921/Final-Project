//UserWriter.java
import java.io.*;
import java.util.*;

public class UserWriter 
{
  //writes out a file according to the information given from the sign up panel
  static Account account1;
  public static void fileWriter(String theUser,String thePass,String thePass2,String theName,String theStreet,String theState,String theCity,String theZip,String thePnum) throws IOException
  {
    FileWriter fw = new FileWriter ("customers.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter fileOut = new PrintWriter (bw);
    fileOut.println(theUser + " " + thePass + " " + AccountArrayList.accounts.size()); //prints this out to the customer file
    //writing to the personal file
    FileWriter fw2 = new FileWriter (AccountArrayList.accounts.size()+".txt"); //creates a new file with the account number
    BufferedWriter bw2 = new BufferedWriter(fw2);
    PrintWriter fileOut2 = new PrintWriter (bw2);
    fileOut2.println(theName);
    fileOut2.println(theStreet);
    fileOut2.println(theCity);
    fileOut2.println(theState);
    fileOut2.println(theZip);
    fileOut2.println(thePnum);
    fileOut2.println(0.0); //this is the balance
    fileOut2.close();
    account1 = new Account(theUser, thePass, AccountArrayList.accounts.size());
    AccountArrayList.accounts.add(account1); //adds a new user to the arraylist
    fileOut.close(); 
  }
  
  
}