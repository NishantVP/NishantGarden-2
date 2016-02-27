/**
 * COEN 275 OOAD - Individual Project
 * Automated Gardening System
 * 
 * By Nishant Phatangare (W1108022)
 */

/*
 * --About this <file>--
 * 
 */
package module.logs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author nishant
 *
 */
public class WriteLogs {
	
	private File file;
	private FileWriter writer;
	
	public WriteLogs(int id) {
		String Filename = "Logs_NishantGarden_Section_"+Integer.toString(id)+".csv";
		file = new File(Filename);
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 writer = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public synchronized void writeToFile(String incomingLog) throws IOException {
		writer.write(incomingLog); 
  	  	writer.write("\n"); 
	    writer.flush();  
	}
	
	public void finishedWritting() throws IOException {
		writer.close();
	}
}
