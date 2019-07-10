/**
 * 
 */
package io.atmecs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.atmecs.model.Status;
import io.atmecs.model.Task;
import io.atmecs.persistence.StatusRepository;

/**
 * @author ruchira.more
 *
 */
@Service
public class StatusService {

	@Autowired 
	StatusRepository statusRepository;
	
	@Autowired
	TaskService taskservice;

	public List<Status> findAll() {
		// TODO Auto-generated method stub
		return statusRepository.findAll();
	}

	public Status save(Status status) {
		// TODO Auto-generated method stub
		Status savestatus=null;
		List<Task> task=taskservice.findByEmpid(status.getEmpid());
		for(Task ta:task) {
			if(ta.getTaskid()== status.getTaskid()) {
				savestatus= statusRepository.save(status);
			}
		}
		return savestatus;
	}

	public List<Status> findByEmpid(int empid) {
		// TODO Auto-generated method stub
		return statusRepository.findByEmpid(empid);
	}

	public List<Status> findByTaskId(int taskid) {
		// TODO Auto-generated method stub
		return statusRepository.findByTaskid(taskid);
	}
	
}
