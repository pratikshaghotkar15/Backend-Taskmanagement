package com.pratiit.service;

import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.pratiit.entity.Mytask;
import com.pratiit.entity.UserInfo;
import com.pratiit.repo.MyTaskRepo;
import com.pratiit.repo.UserInfoRepo;
import com.pratiit.request.SearchTask;
import com.pratiit.request.newTask;

import io.micrometer.common.util.StringUtils;


@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private MyTaskRepo myTaskRepo;
	
	@Autowired
	private UserInfoRepo userInfoRepo;
	
	
	@Override
	public Mytask createTask(newTask task) {
		Mytask mytask=new Mytask();
		BeanUtils.copyProperties(task, mytask);
		Integer user_id = task.getUser_id();
		UserInfo userInfo = userInfoRepo.findById(user_id).get();
		mytask.setUser_id(userInfo);
		Mytask save = myTaskRepo.save(mytask);
		return save;
	}

	@Override
	public Mytask updateTask(Integer taskId, newTask task) {
		Mytask mytask = myTaskRepo.findById(taskId).get();
		mytask.setTitle(task.getTitle());
		mytask.setDescription(task.getDescription());
		mytask.setDuedate(task.getDuedate());
		mytask.setStatus(task.getStatus());
		Mytask upadtedTask = myTaskRepo.save(mytask);
		return upadtedTask;
	}

	@Override
	public void changeStatusOfTask(Integer taskId, String status) {
		Mytask task = myTaskRepo.findById(taskId).get();
		System.out.println(status);
		task.setStatus(status);
		myTaskRepo.save(task);
		
		
	}

	@Override
	public void deleteTask(Integer taskId) {
		myTaskRepo.deleteById(taskId);
	}

	@Override
	public List<Mytask> searchTask(SearchTask searchTask) {
		System.out.println(searchTask.getTitle()+searchTask.getDescription()+searchTask.getDuedate()+searchTask.getStatus());
		Mytask mytask=new Mytask();
		
		if(StringUtils.isNotBlank(searchTask.getTitle())) {
			mytask.setTitle(searchTask.getTitle());
		}
		
		if(StringUtils.isNotBlank(searchTask.getDescription())) {
			mytask.setDescription(searchTask.getDescription());
		}
		
		if(StringUtils.isNotBlank(searchTask.getStatus())) {
			mytask.setStatus(searchTask.getStatus());
		}
		
		if(null != searchTask.getDuedate()) {
			mytask.setDuedate(searchTask.getDuedate());
		}
		
		Example<Mytask> of = Example.of(mytask);
		List<Mytask> list = myTaskRepo.findAll(of);
		return list;
	}

	@Override
	public List<Mytask> getAlltask() {
		List<Mytask> findAll = myTaskRepo.findAll();
		return findAll;
	}

	@Override
	public Mytask gettaskbyId(Integer id) {
		Mytask mytask = myTaskRepo.findById(id).get();
		return mytask;
	}

}
