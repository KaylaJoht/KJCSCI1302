
	package test.testinfo;
	import javax.swing.*;
	import java.awt.event.*;

	public class docListener extends abstractCompListener{
 	/* 	
		Class:  docListener
	
		Written By Glen Blood
		On:  29 July 2019
		Purpose:
			This class is for JTextField

		*/
		// constructor	   
    
		public docListener(String inSource, commPipe guiComm){
			super(inSource,guiComm);
		}
		public String getText(Object comp){
			//JTextField's use getText.
			JTextField field = (JTextField) comp;
			String line = field.getText();
			return line;
		}
	}

	  
 