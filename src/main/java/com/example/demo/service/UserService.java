package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired private UserRepository dpR;  
	public List<User> findAll() {
		return (List<User>) dpR.findAll();
	}
	public Optional<User> findById(final String id) {
		return dpR.findById(id);
	}
	public void save(final User customer) {
		// check if exist -> throw exception
		dpR.save(customer);
	}

	public void update(final User customer) {
		// check if not exist -> throw excpetion
		dpR.save(customer);
	}

	public void delete(final String id) {
			dpR.deleteById(id);
	}
}
