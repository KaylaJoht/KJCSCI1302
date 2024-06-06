	
	package test.testinfo;
	import java.awt.event.*;
	public abstract class abstractCompListener implements ActionListener{
	/* 	
		Class:  abstractCompListener
	
		Written By Glen Blood
		On:  29 July 2019
		Purpose:
			This is an abstraction of a simple listener for a GUI component.
			It uses the abstract method getText to get some text 
			which it sends down the pipe to the business logic.

		*/
		// variables	
		private commPipe writer;
		// source object name - set by source.
		private String source;
		
		// constructor
		public abstractCompListener(String inSource, commPipe guiComm){
			writer = guiComm;
			source = inSource;
		}
		// handler 
		public void actionPerformed(ActionEvent e){
			// Get the data from the source object
			// and send it down the pipe.
			Object comp = e.getSource();
			String line = getText(comp);
			writer.write(source + ": " + line);
		}
		// each source object will have its own way to get text.
		// hence its own class
		abstract public String getText(Object comp);
		}
	
	