/**
 * 
 */
package io.atmecs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.atmecs.model.Task;
import io.atmecs.model.User;
import io.atmecs.persistence.TaskRepository;

/**
 * @author ruchira.more
 *
 */
@Service
public class TaskService {

	@Autowired
	TaskRepository taskrepository;

	@Autowired
	UserService userService;

	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return taskrepository.findAll();
	}

	public Task save(Task task) {
		Task taskSave = null;
		Optional<User> employee = userService.findByEmpid(task.getEmpid());
		if (employee.isPresent()) {
			taskSave = taskrepository.save(task);
		}
		return taskSave;
	}

	public List<Task> findByEmpid(int empid) {
		// TODO Auto-generated method stub
		return taskrepository.findByEmpid(empid);
	}

}
