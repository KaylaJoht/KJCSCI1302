	package test.testinfo;
	import javax.swing.*;
	import java.awt.event.*;

	public class commListener extends abstractCompListener{
	/* 	
		Class:  buttonListener
	
		Written By Glen Blood
		On:  29 July 2019
		Purpose:
			This class is for JRadioButtons

		*/
			
		// constructor
		public commListener(String inSource, commPipe guiComm){
			super(inSource,guiComm);
		}
		public String getText(Object comp){
			//JRadioButton's use getText.
			JButton button = (JButton) comp;
			String line = (String)button.getText();
			return line;
		}
	}
	