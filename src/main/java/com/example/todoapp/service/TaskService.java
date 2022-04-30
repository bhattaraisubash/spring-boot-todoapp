package com.example.todoapp.service;

/**
 * @author subash
 * @since Apr 30, 2022
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapp.model.Task;
import com.example.todoapp.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public List<Task> getTasks() {
		return taskRepository.findAll();
	}

	public void create(Task task) {
		taskRepository.save(task);
	}

	public Task getTaskById(Long id) {
		return taskRepository.getById(id);
	}

	public void update(Long id, Task newTask) {
		Task task = taskRepository.getById(id);
		task.setName(newTask.getName());
		task.setDate(newTask.getDate());
		taskRepository.save(task);
	}

	public void delete(Long id) {
		Task task = taskRepository.getById(id);
		taskRepository.delete(task);
	}

}
