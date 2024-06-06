
package test.testinfo;
import java.awt.event.*;

public abstract class abstractListener {
    String source;
    
    public abstractListener(String inSource){
        source = inSource;
    }
    public void actionPerformed(ActionEvent e){
        Object comp = e.getSource();
        String line = getText(comp);
        System.out.println(source + ": " + line);
    }
    
    abstract public String getText(Object comp);
}
