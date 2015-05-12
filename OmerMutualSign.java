//OmerMutualSign.java
import javax.swing.*;
import java.awt.*;
//this is the logo for the bank
public class OmerMutualSign extends JPanel
{
  
  public OmerMutualSign()
  {
    
  }
  
  public void draw(Graphics page)  
  {
    page.setColor(Color.yellow);
    page.fillRect(430,0,550,100);
    page.setColor(Color.blue);
    page.fillOval(440, 0, 100, 100);
    page.setColor(Color.yellow);
    page.fillOval(455, 10, 70, 80);
  }
}