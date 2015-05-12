//Manager.java
import java.io.*;
import java.util.*;
//manager object class
public class Manager
{
  private String name;
  private int pin;
  
  public Manager(String name, int pin)
  {
    this.name = name;
    this.pin = pin;
  }
  //returns name
  public String getName()
  {
    return name;
  }
  //returns pin
  public int getPin()
  {
    return pin;
  }
  
  public String toString()
  {
    return name + " " + pin;
  }
}