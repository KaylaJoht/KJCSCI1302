	package test.testinfo;
	import javax.swing.*;
	import java.awt.*;

	public  class commActions  extends Thread{
		/* 	
		Class:  commActions
	
		Written By Glen Blood
		On:  29 July 2019
		Purpose:
			This is a The business logic a simple tiered GUI.
			All it does is waits for a message in the pipe.
			once it gets the message,
			it sends it back to the GUI via an API updatelabel.
			

		*/
	private commPipe input;
	private changeLabel GUI;

    // constructor
	public commActions(commPipe guicomm, changeLabel myGUI){
		input = guicomm;
		GUI = myGUI;
	}
	
	// thread process
	public void run(){
		// primer read	
       String newText = input.read();
	   // keeps going until the GUI closes the pipe
	   while (null != newText){
		// updates the label in the GUI   
		GUI.updateLabel(newText);
		// reads the next entry in the pipe
		newText = input.read();
	   }
	     ///  closes the pipe and quits
		input.closeIn();
	}
	
	}