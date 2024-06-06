package test.testinfo;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class compGUI{
    /* 	
    Class:  compGUI
    Written By Glen Blood
    On:  29 July 2019
    Purpose:
    This is a complicated GUI to show off several types of GUI components
    each button has a listener.  
    */
    // define class variables
    private Frame2 aFrame;
    private compListener Listener;
    private JLabel outcome;
    private commPipe guiComm;
    private JTextField text;
    static final int SIZE = 300;
    String[] animals = {"", "Bird", "Cat", "Dog", "Rabbit", "Pig"};
    //constructor
    public compGUI(commPipe tempComm){
        guiComm = tempComm;
        aFrame = new Frame2("Components");          
	outcome = new JLabel("",JLabel.CENTER);
	kickoff();
    }
    // create and show the GUI
    public void createAndShowGUI()
    {		
        // set up the frame.
        aFrame.setSize(SIZE,SIZE);
        aFrame.setLayout(new GridLayout(3,1));
        // set up the first panel this one holds just a label.
	JPanel panel1 = new JPanel();
	panel1.setBackground(Color.RED);
	panel1.add(outcome);
	aFrame.add(panel1);
	
        // first component is a text field that they can input any data in.
	JTextField text = new JTextField("Change Me");
        text.setBorder(BorderFactory.createLineBorder(Color.black));
	docListener txtListener = new docListener("text",guiComm);
	text.addActionListener(txtListener);
			
        // second component is a combobox that they get to chose from our animals
	JComboBox  combobox = new JComboBox(animals);
	combobox.setSelectedIndex(0); 
        combobox.setBorder(BorderFactory.createLineBorder(Color.black));
        comboListener boxListener = new comboListener("animal combo", guiComm);
        combobox.addActionListener(boxListener);
			
        // these two componets are in our second JPanel
	JPanel panel2 = new JPanel();
	panel2.setLayout(new GridLayout(1,2));
        panel2.setBorder(BorderFactory.createLineBorder(Color.black));
	panel2.add(text);
	panel2.add(combobox);
	aFrame.add(panel2);
        
        //build radio buttons
	radioListener rbListener = new radioListener("animal radio Buttons", guiComm);
	ArrayList<JRadioButton> radiobox = buildRadioButtons(animals, rbListener);
	JPanel radioPanel = new JPanel();
        radioPanel.setBorder(BorderFactory.createLineBorder(Color.black));
	radioPanel.setLayout(new GridLayout(0,1));
	ButtonGroup radioGroup = new ButtonGroup();
        buildRadioGroup(radiobox,radioPanel,radioGroup);		
			
	//build the checkbox
	checkListener cListener = new checkListener("animal Check Box", guiComm);
	ArrayList<JCheckBox> checkbox = buildCheckBoxes(animals,cListener );
	JPanel checkPanel = new JPanel();
        checkPanel.setBorder(BorderFactory.createLineBorder(Color.black));
	checkPanel.setLayout(new GridLayout(0,1));
	ButtonGroup checkGroup = new ButtonGroup();
        buildCheckGroup(checkbox,checkPanel,checkGroup);		

	// Add these two groups to a third Jpanel and add that JPanel to the frame 
	JPanel panel3 = new JPanel();
	panel3.setLayout(new GridLayout(1,2));
        panel3.setBorder(BorderFactory.createLineBorder(Color.black));
	panel3.add(radioPanel);
	panel3.add(checkPanel);
	aFrame.add(panel3);
		
    }
		
    // this is the GUI thread
    public void kickoff(){
    // We want to run the GUI this way to avoid thread problems with the event driver.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        }
    );
    }
		
    // this is the API to modify the label.
    public  void updateLabel(String newText){
        outcome.setText(newText);
        outcome.setForeground(Color.WHITE);
	aFrame.repaint();
    }
    
    public ArrayList<JRadioButton> buildRadioButtons(String[] Input, radioListener rbListener){
        int size = Input.length - 1;
        JRadioButton anItem;
        ArrayList<JRadioButton> output = new ArrayList<JRadioButton>();
        for (int i = 0; i < size; ++i){
            anItem = new JRadioButton(Input[i+1]);
            anItem.addActionListener(rbListener);
            output.add(anItem);
        }
        return output;
    }
    
    public void buildRadioGroup(ArrayList<JRadioButton> input, JPanel outPanel, ButtonGroup outGroup){
        int size = input.size();
        JRadioButton anItem;
        for (int i = 0; i < size; ++i){
            anItem = input.get(i);
            outPanel.add(anItem);
            outGroup.add(anItem);
        }
    }
    
    public ArrayList<JCheckBox> buildCheckBoxes(String[] Input, checkListener cListener){
        int size = Input.length - 1;
        JCheckBox anItem;
        ArrayList<JCheckBox> output = new ArrayList<JCheckBox>();
        for (int i = 0; i < size; ++i){
            anItem = new JCheckBox(Input[i+1]);
            anItem.addActionListener(cListener);
            output.add(anItem);
        }
        return output;
    }
    
    public void buildCheckGroup(ArrayList<JCheckBox> input, JPanel outPanel, ButtonGroup outGroup){
        int size = input.size();
        JCheckBox anItem;
        for (int i = 0; i < size; ++i){
            anItem = input.get(i);
            outPanel.add(anItem);
            outGroup.add(anItem);
        }
    }
		
}