	package test.testinfo;
	import javax.swing.*;
	import java.awt.event.*;

	public class checkListener extends abstractCompListener{
 	/* 	
		Class:  checkListener
	
		Written By Glen Blood
		On:  29 July 2019
		Purpose:
			This class is for JCheckBox

		*/
		// constructor	   
		public checkListener(String inSource, commPipe guiComm){
			super(inSource,guiComm);
		}
		public String getText(Object comp){
			//JCheckBox's use getText.
			JCheckBox check = (JCheckBox) comp;
			String line = (String)check.getText();
			return line;
		}
	}
	  
 