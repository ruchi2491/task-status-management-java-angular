/**
 * 
 */
package io.atmecs.persistence;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.atmecs.model.User;

/**
 * @author ruchira.more
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByEmpid(int empid);

	//public List<User> FindByUser_name(String user_name);
}
