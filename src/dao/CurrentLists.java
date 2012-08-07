/**
 * 
 */
package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import util.TaskListProps;

import com.google.gson.Gson;

import dto.ToDoList;

/**
 * @author yogi
 * Brings in the data from Current List
 */
public class CurrentLists {

	public CurrentLists()
	{
		TaskListProps props = new TaskListProps();
		props.setProperties();
	}
	 public String fileName = TaskListProps.TASKLIST_FILE; 
	ArrayList<ToDoList>  todoList = new ArrayList<ToDoList>();
	
	/**
	 * Reads data from a file and Maps the JSON to Java object and returns the object
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public  ArrayList<ToDoList> getCurrentToDoList() throws IOException
	{
		File f1 = new File(fileName);
		Gson gson = new Gson();

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(f1));
			
			
			String str;
			  while ((str = br.readLine())!=null )
			  {    
				ToDoList tdl = gson.fromJson(str, ToDoList.class);
				todoList.add(tdl);
			  }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return todoList;
	}
	
	
	
	/**
	 * Reads data from a file and Maps the JSON to Java object and returns the object
	 * @param fileName
	 * @return toDo List
	 * @throws IOException
	 */
	public  ToDoList getToDoListByID(int ID) throws IOException
	{
		File f1 = new File(fileName);
		Gson gson = new Gson();
		ToDoList toDoList = null;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(f1));
			
			
			String str;
			  while ((str = br.readLine())!=null )
			  {    
				ToDoList tdl = gson.fromJson(str, ToDoList.class);
				
				if(tdl.getListID()==ID)
				{
					toDoList = tdl;
				}
				
			  }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return toDoList;
	}
	
	
	
	  
	



}
