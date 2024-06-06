	package test.testinfo;
	import javax.swing.*;
	import java.awt.*;
	public class changeLabel
				/* 	
		Class:  changeLabel
	
		Written By Glen Blood
		On:  29 July 2019
		Purpose:
			This is a simple GUI with two buttons and a label.
			each button has a listener.  
			

		*/
	{
        
		// set up the data
		private JLabel label;
		private Frame2 aFrame;
		private commPipe pipe;
		
		static final int SIZE = 300;
		
        // constructor
		public changeLabel(commPipe guiComm){
			aFrame = new Frame2("Events");
                        label = new JLabel("Press Button",JLabel.CENTER);
			pipe = guiComm;
			kickoff();
		}
        // gui method
		public void createAndShowGUI()
		{
		    // set up the frame
			aFrame.setSize(SIZE,SIZE);
			aFrame.setLayout(new GridLayout(3,1));
			// add the label
			aFrame.add(label);
			// add the first button and his listener
			JButton PushMe = new JButton("PUSH ME");
			aFrame.add(PushMe);
			commListener pushListener = new commListener("push",pipe); 
			PushMe.addActionListener(pushListener);
			// add the second button and his listener
			JButton PullYou = new JButton("PULL YOU");
			aFrame.add(PullYou);
			commListener pullListener = new commListener("pull",pipe);
			PullYou.addActionListener(pullListener);
			
		}
		
		// start the GUI job
		public void kickoff(){
			// We want to run the GUI this way to avoid thread problems with the event driver.
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
          public void run() {
                createAndShowGUI();
            }
        });
		
		}
		// API to change the label.  this is run by the business logic.
		public void updateLabel(String newText){
			label.setText(newText);
			aFrame.repaint();
		}
	}