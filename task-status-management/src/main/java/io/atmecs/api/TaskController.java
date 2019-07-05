/**
 * 
 */
package io.atmecs.api;

import java.util.List;
import java.util.Optional;

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
		return ResponseEntity.ok(taskService.findAll());
	}

	@PostMapping
	public ResponseEntity<Task> save(@Valid @RequestBody Task task) {
		return ResponseEntity.ok(taskService.save(task));
	}

	@GetMapping("/{empid}")
	public ResponseEntity<List<Task>> findByEmpid(@PathVariable int empid){
		return ResponseEntity.ok(taskService.findByEmpid(empid));
		
	}
}
