/**
 * 
 */
package client;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import dto.Task;
import dto.ToDoList;

/**
 * @author yogi
 * This class can be refined to add tasks if the item already exists.
 *
 */
public class TaskListClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	
	
	postToDoList( getTaskObject());
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
	
	
	
	/**
	 * Return Sample JSON object 
	 * This method can be tweaked to get the elements from table or different datasource like a webform
	 * @return JSON objectin formatted  String 
	 */
	public static String getTaskObject()
	{
		
		ArrayList<Task> tasks = new ArrayList<Task>();
		
		Task t = new Task();
		t.setOwner("yogi");
		t.setTaskComplete(true);
		t.setTaskDescription("PLEASE EAT");
		t.setTaskTitle("EAT");

		tasks.add(t);
	
		t.setOwner("yogi4");
		t.setTaskComplete(true);
		t.setTaskDescription("PLEASE Study");
		t.setTaskTitle("STUDY");
		tasks.add(t);
		
		ToDoList tdl = new ToDoList();
		tdl.setListID(1);
		tdl.setListOwner("yogi");
		tdl.setListTitle("TO Do List 1");
		tdl.setTaskList(tasks);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String json = gson.toJson(tdl);
	
		 return json;
	}

	
	
	/**
	 * Client method to post the JSON object
	 * @param string
	 * @throws IOException
	 */
	public static void postToDoList(String string)throws IOException
	  {
		String url = "http://localhost:8080/TaskLists/tasklist/processlists/add";    
		Client client = Client.create();
		
		// Add the condition to see if the object exists in the file. 
				
		WebResource wr = client.resource(url);
		ClientResponse response = wr.type(MediaType.APPLICATION_JSON)
		   .post(ClientResponse.class, string);
		
			       
			if (response.getStatus() != 202) {
				throw new RuntimeException("Invalid Request: "
				     + response.getStatus());
			}
	 
			String output = response.getEntity(String.class);
			System.out.println(output);
			
		}
	
}
