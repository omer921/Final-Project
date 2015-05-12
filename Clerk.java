//Clerk.java
import java.util.*;
import java.io.*;

//this is the clerk object which setsup clerk objects when the program is run

public class Clerk
{
  private Scanner scan;
  private String user, name, password;

  public Clerk(String name, String user, String password)
  {
     this.user = user;
     this.name = name;
     this.password = password;
  }
  //gets the user
  public String getUser()
  {
    return user;
  }
  //gets the name
  public String getName()
  {
    return name;
  }
  //gets the password
  public String getPassword()
  {
    return password;
  }
  
  public String toString()
  {
    return user + " " + password;
  }
}

    