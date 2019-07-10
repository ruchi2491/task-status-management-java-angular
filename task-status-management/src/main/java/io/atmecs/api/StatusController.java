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

import io.atmecs.exceptions.StatusNotFoundException;
import io.atmecs.model.Status;
import io.atmecs.service.StatusService;

/**
 * @author ruchira.more
 *
 */
@RestController
@RequestMapping("/dailystatus/status")
public class StatusController {

	@Autowired
	StatusService statusService;

	@GetMapping
	public ResponseEntity<List<Status>> getAllRecords() {

		List<Status> statuses = statusService.findAll();
		if(statuses.isEmpty()) {
			throw new StatusNotFoundException("Record not found");
		}
		return ResponseEntity.ok(statuses);
	}

	@PostMapping
	public ResponseEntity<Status> createNewStatus(@Valid @RequestBody Status status) {

		return ResponseEntity.ok(statusService.save(status));
	}

	@GetMapping("/employee/{empid}")
	public ResponseEntity<List<Status>> getStatusByEmployee(@PathVariable int empid) {
		return ResponseEntity.ok(statusService.findByEmpid(empid));
	}

	@GetMapping("/task/{taskid}")
	public ResponseEntity<List<Status>> getStatusByTask(@PathVariable int taskid) {
		return ResponseEntity.ok(statusService.findByTaskId(taskid));
	}
}
