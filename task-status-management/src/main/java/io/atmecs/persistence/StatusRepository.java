/**
 * 
 */
package io.atmecs.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.atmecs.model.Status;


/**
 * @author ruchira.more
 *
 */
public interface StatusRepository extends JpaRepository<Status, Integer>{

	List<Status> findByEmpid(int empid);

	List<Status> findByTaskid(int taskid);

}
