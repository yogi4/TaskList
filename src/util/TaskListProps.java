/**
 * 
 */
package util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author yogi
 *Constants for TaskLists Application
 * This class retrieves the constants from tasklist.properties file
 */
public class TaskListProps {

	Properties d_configFile = new Properties();

	private static String d_configfilename = "C:\\J2EE\\workspace\\TaskLists\\WebContent\\WEB-INF\\conf\\tasklist.properties";

	public static String sourceFile = "";
	static Properties props = new Properties();


	public static String URI = "";
	public static String TASKLIST_FILE= "";

	public static void setProperties(String configfilename) {
		try {

			props.load(new FileInputStream(configfilename));

			
			URI					= props.getProperty("uri");
			TASKLIST_FILE 		= props.getProperty("persistentFile");
					
		} catch (FileNotFoundException fnfe) {
			

		} catch (IOException ioe) {
			
		}
	}

	public TaskListProps(String configfilename) {
		
		if(configfilename ==null ||configfilename.isEmpty())
		{
			configfilename =d_configfilename;
		}
		setProperties(configfilename);
	}

	public TaskListProps() {
		// TODO Auto-generated constructor stub
		setProperties(d_configfilename);
	}
	
	public void setProperties()
	{
		setProperties(d_configfilename);
	}

}
