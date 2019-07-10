/**
 * 
 */
package io.atmecs.api;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.atmecs.model.Task;
import io.atmecs.service.TaskService;

/**
 * @author ruchira.more
 *
 */
@RestController
@RequestMapping("/dailystatus/task")
public class TaskController {

	@Autowired
	TaskService taskService;

	@GetMapping
	public ResponseEntity<List<Task>> findAll() {
		List<Task> tasks=taskService.findAll();
		if(tasks.isEmpty()) {
			ResponseEntity.notFound();
		}
		return ResponseEntity.ok(tasks);
	}

	@PostMapping
	public ResponseEntity<Task> save(@Valid @RequestBody Task task) {
		Task taskSave=taskService.save(task);
		if(taskSave.equals(null) ) {
			ResponseEntity.notFound();
		}
		return ResponseEntity.ok(taskSave);
	}

	@GetMapping("/{empid}")
	public ResponseEntity<List<Task>> findByEmpid(@PathVariable int empid){
		return ResponseEntity.ok(taskService.findByEmpid(empid));
		
	}
}
