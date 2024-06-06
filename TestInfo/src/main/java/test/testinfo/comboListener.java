	package test.testinfo;
	import javax.swing.*;
	import java.awt.event.*;

	public class comboListener extends abstractCompListener{
	/* 	
		Class:  comboListener
	
		Written By Glen Blood
		On:  29 July 2019
		Purpose:
			This class is for JComboBox

		*/
		// constructor	   
    
		public comboListener(String inSource, commPipe guiComm){
			super(inSource,guiComm);
		}
		public String getText(Object comp){
			//JComboBox's use getSelectedItem()
			JComboBox combo = (JComboBox) comp;
			String line = (String)combo.getSelectedItem();
			return line;
		}
	}
	  
 