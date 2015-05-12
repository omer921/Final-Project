//ManagerArrayList.java
import java.io.*;
import java.util.*;

public class ManagerArrayList
{
  static ArrayList<Manager> managers = new ArrayList<Manager>();
  public static void managerList() throws IOException
  {
    //reads in data from manager.txt
    Scanner scan = new Scanner(new File("managers.txt"));
    while(scan.hasNext())
    {
      String check1 = scan.nextLine(); //reads in the whole line
      int find = check1.indexOf(' '); // finds the space 
      int check3 = Integer.parseInt(check1.substring(find+1)); //gets the pin from right after where the pin starts
      Manager m = new Manager(check1.substring(0,find),  check3); //creates a new manager object using the information
      managers.add(m);//adds it to the array
    }
      System.out.println(managers);//for debugging purposes
  }
}