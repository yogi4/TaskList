/**
 * 
 */
package dto;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yogi
 * Transfer object for Collection of tasks. 
 * 
 */
@XmlRootElement 
public class ToDoList
{
private int d_listID =0;
private ArrayList<Task> d_taskList = new ArrayList<Task>();
private String d_listTitle ="";
private String d_listOwner ="";



/**
 * @param d_taskList the d_taskList to set
 */
public void setTaskList(ArrayList<Task> d_taskList) {
	this.d_taskList = d_taskList;
}

/**
 * @return the d_taskList
 */
public ArrayList<Task> getTaskList() {
	return d_taskList;
}

/**
 * @param d_listTitle the d_listTitle to set
 */
public void setListTitle(String d_listTitle) {
	this.d_listTitle = d_listTitle;
}

/**
 * @return the d_listTitle
 */
public String getListTitle() {
	return d_listTitle;
}

/**
 * @param d_listOwner the d_listOwner to set
 */
public void setListOwner(String d_listOwner) {
	this.d_listOwner = d_listOwner;
}

/**
 * @return the d_listOwner
 */
public String getListOwner() {
	return d_listOwner;
}

/**
 * @param d_listID the d_listID to set
 */
public void setListID(int d_listID) {
	this.d_listID = d_listID;
}

/**
 * @return the d_listID
 */
public int getListID() {
	return d_listID;
}
	

}
