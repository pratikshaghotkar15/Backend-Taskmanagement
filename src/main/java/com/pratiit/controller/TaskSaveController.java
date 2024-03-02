package com.pratiit.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratiit.entity.Mytask;
import com.pratiit.repo.MyTaskRepo;
import com.pratiit.request.SearchTask;
import com.pratiit.request.newTask;
import com.pratiit.service.TaskService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "tasksavecontroller", description = "task creation")
@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class TaskSaveController {

	@Autowired
	private TaskService taskService;

	@PostMapping("/tasks")
	public ResponseEntity<Mytask> saveTask(@RequestBody newTask task) {

		Mytask response = taskService.createTask(task);
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);

	}
	
	@GetMapping("/tasks")
	public ResponseEntity<List<Mytask>> getAlltasks(){
		List<Mytask> alltask = taskService.getAlltask();
		return new ResponseEntity<>(alltask,HttpStatus.OK);
		
	}

	@GetMapping("/tasks/{id}")
	public ResponseEntity<Mytask> getTaskById(@PathVariable Integer id){
		Mytask mytask = taskService.gettaskbyId(id);
		return new ResponseEntity<>(mytask,HttpStatus.OK);
	}
	
	
	@PutMapping("/tasks/{taskId}")
	public ResponseEntity<Mytask> updateTask(@PathVariable Integer taskId, @RequestBody newTask task) {
		Mytask updatedTask = taskService.updateTask(taskId, task);
		return new ResponseEntity<>(updatedTask, HttpStatus.OK);

	}

	@GetMapping("/tasks/changestatus/{id}/{status}")
	public ResponseEntity<String> updateStatusofTask(@PathVariable("id") Integer taskId, @PathVariable("status") String status) {
		taskService.changeStatusOfTask(taskId, status);
		return new ResponseEntity<>("status change successfully", HttpStatus.OK);

	}

	@DeleteMapping("/tasks/{taskId}")
	public ResponseEntity<String> deleteTask(@PathVariable Integer taskId) {
		taskService.deleteTask(taskId);
		return new ResponseEntity<>("task deleted succesfully", HttpStatus.OK);
	}
	
	@PostMapping("/tasks/filter-task")
	public ResponseEntity<List<Mytask>> filterData(@RequestBody SearchTask searchTask){
		List<Mytask> list = taskService.searchTask(searchTask);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}

}
