package com.pratiit.service;

import java.util.List;

import com.pratiit.entity.Mytask;
import com.pratiit.request.SearchTask;
import com.pratiit.request.newTask;

public interface TaskService {
	
	public Mytask createTask(newTask task);
	
	public Mytask updateTask(Integer taskId,newTask task);
	
	public void changeStatusOfTask(Integer taskId,String status);
	
	public void deleteTask(Integer taskId);
	
	public List<Mytask> searchTask(SearchTask searchTask);
	
	public List<Mytask> getAlltask();
	
	public Mytask gettaskbyId(Integer id);
	

}
