package io.atmecs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.atmecs.model.User;
import io.atmecs.persistence.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public Optional<User> findById(int id) {
        return userRepository.findById(id);
}
	
	  public User save(User user) {
	        return userRepository.save(user);
	}

	public Optional<User> findByEmpid(int empid) {
		// TODO Auto-generated method stub
		return userRepository.findByEmpid(empid);
	}
}
