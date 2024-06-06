	package test.testinfo;
	import java.awt.event.*;
	public class compListener implements ActionListener{

	public compListener(){
		
	}
	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
		System.out.println(command);
	
	}
	}