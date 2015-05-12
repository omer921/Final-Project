//ClerkArrayList.java
import java.io.*;
import java.util.*;

public class ClerkArrayList
{
  //this class is run when the program is started 
  static ArrayList<Clerk> clerks = new ArrayList<Clerk>();
  public static void clerkList() throws IOException
  {
    Scanner scan = new Scanner(new File("clerks.txt"));
    Clerk clerk;
    while(scan.hasNext())
    {
      //it reads in formation from the clerk file and sets up new clerk objects with the information and after adds them to the arraylist
      String name = scan.next();
      String user = scan.next();
      String password = scan.next();
      clerk = new Clerk(name, user, password);
      clerks.add(clerk);
    }
      System.out.println(clerks);//used for debugging purposes
    
  }
}
      