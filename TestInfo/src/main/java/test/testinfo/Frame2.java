/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.testinfo;
import javax.swing.*;
import java.awt.*;
public class Frame2 extends JFrame{
final static int INITSIZE = 500;
public Frame2(String title){
super(title);
this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
Font headlineFont = new Font("Arial", Font.BOLD, 36);
setDefaultLookAndFeelDecorated(true);
int width = (int)((monitorwidth() - INITSIZE + 0.5)/2) ;
int height = (int)((monitorheight() - INITSIZE + 0.5)/2);
this.setLocation(width,height);
this.setSize(INITSIZE,INITSIZE);
} //end Constructor

public static double monitorwidth(){
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
double width = screenSize.getWidth();

  return width;
}
public static double monitorheight(){
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
double height = screenSize.getHeight();
return height;
}
} // end FRAME2
