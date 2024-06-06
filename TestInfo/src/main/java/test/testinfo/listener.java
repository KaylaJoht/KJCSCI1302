
package test.testinfo;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class listener implements ActionListener{
    public void  actionPerformed(ActionEvent e){
        Object comp = e.getSource();
        JButton button = (JButton) comp;
        String line = button.getText();
        System.out.println("Button clicked" + line);
    }
}
