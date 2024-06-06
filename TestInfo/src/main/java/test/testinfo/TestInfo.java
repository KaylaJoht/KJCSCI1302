package test.testinfo;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class TestInfo {
    
    public static JFrame BuildJFrame(JFrame fram){
        fram.setSize(500, 500);  
        fram.setLocationRelativeTo(null);  
        fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        fram.setVisible(true);
        return fram;
    }
    
    public static JLabel buildLabel(String text){
        JLabel label = new JLabel(text);
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        return label;
    }
    
    //static final int SIZE = 300;
    public static void main(String[] args) {
        commPipe guiComm = new commPipe();
        compGUI GUI = new compGUI(guiComm);
        commActions2 actions = new commActions2(guiComm, GUI);
        actions.start();
        
        /*
        listener buttonListener = new listener();
        JFrame fram = new JFrame("Hello World");
        BuildJFrame(fram);
        fram.setSize(SIZE, SIZE);
        fram.setLayout(new GridLayout(3,2));
        JLabel label = new JLabel("Press Button", JLabel.CENTER);
        fram.add(label);
        JButton button = new JButton("PUSH ME");
        fram.add(button);
        button.addActionListener(buttonListener);
        JButton button2 = new JButton("PULL ME");
        fram.add(button2);
        button2.addActionListener(buttonListener);
        /*
       JLabel statement1 = buildLabel("First");
       fram.add(statement1);
       JLabel statement2 = buildLabel("Second");
       fram.add(statement2);
       JLabel statement3 = buildLabel("Third");
       fram.add(statement3);
       JLabel statement4 = buildLabel("Fourth");
       fram.add(statement4);
       JLabel statement5 = buildLabel("Fifth");
       fram.add(statement5);
       JLabel statement6 = buildLabel("Sixth");
       fram.add(statement6);
       fram.setLayout(new FlowLayout());
        /*
        String message = "Please select your card activation criteria";
        int choice;
        Object[] options = {"Notes", "Combo", "Perfects"};
            choice = JOptionPane.showOptionDialog(null, message, "Choosing" , 
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
                    null, options,options[2]);
            
            if (choice == 0){
                JOptionPane.showMessageDialog(null, "You chose notes");
            }
            if (choice == 1){
                JOptionPane.showMessageDialog(null, "You chose combo");
            }
            if (choice == 2){
                JOptionPane.showMessageDialog(null, "You chose perfects");
            }
            */
        }
    }
