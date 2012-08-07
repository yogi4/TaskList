/**
 * 
 */
package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yogi
 *
 */
public class TaskListsUtility {
	static String outputFile = "C:\\Users\\uporla2\\Desktop\\tbr\\listoftasks.txt";
	
	
	

	public static void writeToFile(String text) {
		PrintWriter fw = null;
		try
		{
			File theFile = 
				new File(outputFile);

			if (theFile.exists())
				fw = new PrintWriter(new FileOutputStream(theFile, true), true);
			else {
				fw = new PrintWriter(new FileOutputStream(theFile));
			}
			fw.println(text);
		}
		catch (IOException localIOException) {
		}
		finally {
			if (fw != null) {
				fw.close();
			}
			fw = null;
		}
		
	
		
	}

}
