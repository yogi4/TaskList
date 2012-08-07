/**
 * 
 */
package tasklist;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONObject;

import util.TaskListsUtility;

import com.google.gson.Gson;
import com.sun.jersey.spi.resource.Singleton;

import dao.CurrentLists;
import dto.ToDoList;



/**
 * @author yogi
 * This class has Get and Post methods for writing the transactions
 * Currently using the file as persistent mechanism and this program 
 * can be tweaked to use databases. 
 */

@Produces("application/xml")
@Path("processlists")
@Singleton
public class ListProcess {

	  public ListProcess() {
			  
		
	   
	  }

	  /**
	   * GET method to get the todolist from a file if it exists
	   * @param cId
	   * @return
	   */
	  
	  @GET
	  @Path("{id}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public String getTodoList(@PathParam("id") int cId) {
		 ToDoList  currentList = null;
	    CurrentLists kl = new CurrentLists();
	    String json = "";
	    Gson gson = new Gson();

	    try {
			currentList = kl.getToDoListByID(cId);
			
			 json = gson.toJson(currentList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return json;
	  }
	  
	  /**
	   * GET method to get the todolist from a file if it exists
	   * @param cId
	   * @return
	   */
	  
	  @GET
	  @Path("/getlists")
	  @Produces(MediaType.APPLICATION_JSON)
	  public String getAllLists() {
		 ArrayList<ToDoList>  toDoLists = new ArrayList<ToDoList>();
	    CurrentLists kl = new CurrentLists();
	    String json = "";
	    Gson gson = new Gson();

	    try {
	    	toDoLists = kl.getCurrentToDoList();
			
			 json = gson.toJson(toDoLists);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return json;
	  }
	  
	  
	  /**
	   * Post method for the JSON object 
	   * This method takes JSON parameter and persists it to a file 
	   * This method can be changed to use mapping to persist objects in desired way
	   * @param obj
	   * @return
	   */
	  @POST
	  @Path("add")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces("text/plain")
	   public Response addTodoList(JSONObject obj) {
		  
		  String result = "Yogi rocks  and this To Do List has been added : " + obj;
		  TaskListsUtility.writeToFile(obj.toString());
		  return Response.status(Response.Status.ACCEPTED).entity(result).build();
	  }
	  
	
	  
	  
	  
	} 