/**
 * 
 */
package io.atmecs.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.atmecs.model.Task;

/**
 * @author ruchira.more
 *
 */
public interface TaskRepository extends JpaRepository<Task, Integer>{

	List<Task> findByEmpid(int empid);


}
