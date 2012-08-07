/**
 * 
 */
package dto;

import java.util.Date;

/**
 * @author yogi
 * Transfer Object for Tasks , 
 * This can be an inner class of ToDoList . 
 * The task status can be modified to accommodate an ENUM 
 * based on the requirement.
 */
public class Task {
	
	private int d_taskID= 0; 
	private String d_taskTitle ="";
   // private enum status{BEGIN, HALFWAY,COMPLETE};
    private boolean d_taskComplete =false;
    private Date d_dueDate;
    private String d_taskDescription ="";
    private String d_owner ="";
	/**
	 * @param d_taskTitle the d_taskTitle to set
	 */
	public void setTaskTitle(String d_Title) {
		this.d_taskTitle = d_Title;
	}

	/**
	 * @return the d_taskTitle
	 */
	public String getTaskTitle() {
		return d_taskTitle;
	}

	/**
	 * @param d_taskComplete the d_taskComplete to set
	 */
	public void setTaskComplete(boolean d_taskComplete) {
		this.d_taskComplete = d_taskComplete;
	}

	/**
	 * @return the d_taskComplete
	 */
	public boolean isTaskComplete() {
		return d_taskComplete;
	}

	/**
	 * @param d_dueDate the d_dueDate to set
	 */
	public void setDueDate(Date d_dueDate) {
		this.d_dueDate = d_dueDate;
	}

	/**
	 * @return the d_dueDate
	 */
	public Date getDueDate() {
		return d_dueDate;
	}

	/**
	 * @param d_taskDescription the d_taskDescription to set
	 */
	public void setTaskDescription(String d_taskDescription) {
		this.d_taskDescription = d_taskDescription;
	}

	/**
	 * @return the d_taskDescription
	 */
	public String getTaskDescription() {
		return d_taskDescription;
	}

	/**
	 * @param d_owner the d_owner to set
	 */
	public void setOwner(String d_owner) {
		this.d_owner = d_owner;
	}

	/**
	 * @return the d_owner
	 */
	public String getOwner() {
		return d_owner;
	}

	/**
	 * @param d_taskID the d_taskID to set
	 */
	public void setTaskID(int d_taskID) {
		this.d_taskID = d_taskID;
	}

	/**
	 * @return the d_taskID
	 */
	public int getTaskID() {
		return d_taskID;
	}

}
