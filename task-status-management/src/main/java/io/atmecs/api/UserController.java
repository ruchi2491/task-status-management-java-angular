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

import io.atmecs.model.User;
import io.atmecs.service.UserService;

/**
 * @author ruchira.more
 *
 */
@RestController
@RequestMapping("/dailystatus/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok(userService.findAll());
	}
	
	@GetMapping("/emp/{empid}")
	public ResponseEntity<User> findByEmpid(@PathVariable int empid){
		//return ResponseEntity.ok(userService.findByEmpid(empid));
		Optional<User> prod = userService.findByEmpid(empid);
		if(!prod.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(prod.get());
	}
	
	 @PostMapping
	    public ResponseEntity<User> create(@Valid @RequestBody User user) {
	        return ResponseEntity.ok(userService.save(user));
	}
}
