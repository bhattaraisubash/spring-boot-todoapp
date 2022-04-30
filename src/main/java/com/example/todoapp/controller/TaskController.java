package com.example.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.todoapp.model.Task;
import com.example.todoapp.service.TaskService;

/**
 * @author subash
 * @since Apr 30, 2022
 */

@Controller
public class TaskController {
	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard() {
		return "redirect:/dashboard/tasks";
	}

	@RequestMapping(value = "/dashboard/tasks", method = RequestMethod.GET)
	public String tasks(Model model) {
		model.addAttribute("name", "Boris");
		List<Task> taskList = taskService.getTasks();
		model.addAttribute("taskList", taskList);
		return "dashboard";
	}

	@RequestMapping(value = "/dashboard/tasks/add", method = RequestMethod.GET)
	public String addTask(Model model) {
		model.addAttribute("task", new Task());
		return "addtask";
	}

	@RequestMapping(value = "/dashboard/tasks/add", method = RequestMethod.POST)
	public String submitTask(@ModelAttribute Task task, RedirectAttributes redirectAttributes) {
		taskService.create(task);
		redirectAttributes.addFlashAttribute("success", "Task Added !");
		return "redirect:/dashboard/tasks";
	}

	@RequestMapping(value = "/dashboard/tasks/edit/{id}", method = RequestMethod.GET)
	public String addTask(@PathVariable Long id, Model model) {
		Task task = taskService.getTaskById(id);
		model.addAttribute("task", task);
		return "edittask";
	}

	@RequestMapping(value = "/dashboard/tasks/update/{id}", method = RequestMethod.POST)
	public String updateTask(@PathVariable Long id, @ModelAttribute Task task, RedirectAttributes redirectAttributes) {
		taskService.update(id, task);
		redirectAttributes.addFlashAttribute("success", "Task Updated !");
		return "redirect:/dashboard/tasks";
	}

	@RequestMapping(value = "/dashboard/tasks/delete/{id}", method = RequestMethod.POST)
	public String deleteTask(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		taskService.delete(id);
		redirectAttributes.addFlashAttribute("success", "Task Deleted !");
		return "redirect:/dashboard/tasks";
	}

}
