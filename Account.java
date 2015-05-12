//Account.java 
import java.util.*;
import java.io.*;

public class Account //(CL)
{
  //this class serves as the template for all the customers
  private Scanner scan;
  private String user, name, password, street, city, state, zipcode, phoneNum, transaction = "";
  private int accountNum; 
  private double value;
  private ArrayList<String> transList = new ArrayList<String>();
  //the date class comes form java.util directory and gives the current date and time and time zone
  private Date date = new Date();
  //in order to setup a new account object a user name password and account number must be available
  public Account(String user, String password, int accountNum) throws IOException
  {
    this.user = user;
    this.password = password;
    this.accountNum = accountNum;
    //once the variables are imported the scanner object reads in the rest of the information from the specific file that is 
    //named according to the account number
    scan = new Scanner(new File(accountNum+".txt"));// (I/O)
    name = scan.nextLine();
    street = scan.nextLine();
    city = scan.nextLine();
    state = scan.nextLine();
    zipcode = scan.nextLine();
    phoneNum = scan.nextLine();
    value = scan.nextDouble();
    //the first seven values area always the same meaning zipcode will always be the 6th line but there can be different amounts of transactions
    while (scan.hasNext())
    {
      transList.add(scan.nextLine()); //adds all the transactions to the arraylist
    }
  }
  //this method is used change the balance in the account it does this by taking all the information and rewriting a new file
  public void setValue(double amount) throws IOException
  {
    value += amount;
    FileWriter fw = new FileWriter (accountNum+".txt");
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter fileOut = new PrintWriter (bw);
    fileOut.println(name);
    fileOut.println(street);
    fileOut.println(city);
    fileOut.println(state);
    fileOut.println(zipcode);
    fileOut.println(phoneNum);
    fileOut.println(value);
    //prints out all the transaction information, starts at 1 because when scan.nextLine() is used to read in it always reads in a space so we skip it
    for (int i = 1; i < transList.size(); i++)
      fileOut.println(transList.get(i));
    fileOut.close();
  }
  
  //this method is used for withdraw and deposit panels
  public void setValue(char t, double amount) throws IOException
  {
    ArrayList<String> trans = new ArrayList<String>();
    if (t == 'd')
    {
      //in a deposit we add to the current balance
      value += amount;
      Scanner fileIn = new Scanner(new File(accountNum+".txt"));
      //then we need to skip down to the transcations
      for (int i = 0; i<7; i++)
        fileIn.nextLine();
      while (fileIn.hasNext())
      {
        trans.add(fileIn.nextLine()); //adding all the transactions to an arraylist
      }
      if (transList.size() == 0) //if the size of the list is zero we must add 2 because we always skip the first one because of the space error
      {
        transList.add("skip");
        transList.add("d " + amount + " " + date);
      }
      else //if not we just add the deposit to the array with the date object
      transList.add("d " + amount + " " + date);
      trans.add("d " + amount + " " + date);
      //and the file needs to be rewritten again just like the setValue() method
      FileWriter fw = new FileWriter (accountNum+".txt");
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter fileOut = new PrintWriter (bw);
      fileOut.println(name);
      fileOut.println(street);
      fileOut.println(city);
      fileOut.println(state);
      fileOut.println(zipcode);
      fileOut.println(phoneNum);
      fileOut.println(value);
      for (int i = 0; i < trans.size(); i++)
        fileOut.println(trans.get(i));
      fileOut.close();
    }
    else 
    { //this is the same thing but for the withdraaw panel
      value -= amount;
      Scanner fileIn = new Scanner(new File(accountNum+".txt"));
      for (int i = 0; i<7; i++)
        fileIn.nextLine();
      int count  = 0;
      while (fileIn.hasNext())
      {
        trans.add(fileIn.nextLine());
      }
      if (transList.size() == 0)
      {
        transList.add("skip");
        transList.add("w " + amount + " " + date);
      }
      else
      transList.add("w " + amount + " " + date);
      trans.add("w " + amount + " " + date);
      FileWriter fw = new FileWriter (accountNum+".txt");
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter fileOut = new PrintWriter (bw);
      fileOut.println(name);
      fileOut.println(street);
      fileOut.println(city);
      fileOut.println(state);
      fileOut.println(zipcode);
      fileOut.println(phoneNum);
      fileOut.println(value);
      for (int i = 0; i < trans.size(); i++)
        fileOut.println(trans.get(i));
      fileOut.close();
    }
  }
  //to add to the transaction array
  public void addTransList(String stuff)
  {
    transList.add(stuff);
  }
  //to get the arraylist itself
  public ArrayList getTransList()
  {
    return transList;
  }
  //get the object in the arraylist
  public String getTrans(int i)
  {
    return transList.get(i);
  }
  //get the current balance or value of the account
  public double getValue()
  {
    return value;
  }
  //get the account number of the account
  public int getAcountNum()
  {
    return accountNum;
  }
  //get the city of the account
  public String getCity()
  {
    return city;
  }
  //get the name of the account
  public String getName()
  {
    return name;
  }
  //get the street of the account
  public String getStreet()
  {
    return street;
  }
  //get the state of the account
  public String getState()
  {
    return state;
  }
  //get the zipcode of the account
  public String getZipcode()
  {
    return zipcode;
  }
  //get the phone number of the account
  public String getPhoneNum()
  {
    return phoneNum;
  }
  //get the user of the account
  public String getUser()
  {
    return user;
  }
  //get the password of the account
  public String getPassword()
  {
    return password;
  }
  
  public String toString()
  {
    String result;
    result = user + " " + password;
    return result;
  }
  
}
