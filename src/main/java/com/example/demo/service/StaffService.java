package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Staff;
import com.example.demo.repository.StaffRepository;

@Service
@Transactional
public class StaffService {
	@Autowired private StaffRepository dpR;  
	public List<Staff> findAll() {
		return (List<Staff>) dpR.findAll();
	}
	public Optional<Staff> findById(final String id) {
		return dpR.findById(id);
	}
	public void save(final Staff customer) {
		// check if exist -> throw exception
		dpR.save(customer);
	}

	public void update(final Staff customer) {
		// check if not exist -> throw excpetion
		dpR.save(customer);
	}

	public void delete(final String id) {
			dpR.deleteById(id);
	}
}
