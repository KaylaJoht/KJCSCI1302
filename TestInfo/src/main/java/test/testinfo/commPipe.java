package test.testinfo;
import java.io.*;

public class commPipe{
  private static PipedReader input;
  private static PipedWriter output;
  public final static char LF = 12;  // ascii LF  
  public final static char EOT = 4;  // ascii END of Transmission 

  public commPipe(){
 	  try{
			  output = new PipedWriter();
				input = new PipedReader(output);
	  }
	  catch(Exception e){
		  System.out.println("Cannot build pipes)");
		  System.exit(0);
  }
  }
	  public void write(String Data){
		  try{
				output.write(Data);
				output.write(LF);
			  }
		  catch(Exception e){
			  close();
		  }
	  }
	  
	  public String read(){
		String line;
		line = readString();
		if (null == line){
			closeIn();
		}
		 return line;
	  }
   	public String readString(){
			char c;
			String line = "";
			c = readChar();
					if (EOT == c) return null;
			while (c != LF){
				line = line + c;
				c = readChar();
			}
            return line;
		}
		public char  readChar(){
			char c;
				try{
				c = (char) input.read(); // read a char
			}
			catch (Exception e) {
					return EOT;
			}
            return c;
		}	  
	  public void flush(){
		   try{
			  output.flush();
			 }
			 catch(Exception e){}
	  }
	  public void close(){
		  try{
			  output.write(EOT);
			  output.flush();
			  output.close();
			 }
			 catch(Exception e){}
	  }
	  public void closeIn(){
		  try{
			  input.close();
			}
			 catch(Exception e){}
	  }

  }
  
  