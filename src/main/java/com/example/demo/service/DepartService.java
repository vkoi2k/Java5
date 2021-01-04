package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Depart;
import com.example.demo.repository.DepartRepository;

@Service
@Transactional
public class DepartService {
	@Autowired private DepartRepository dpR;  
	public List<Depart> findAll() {
		return (List<Depart>) dpR.findAll();
	}
	public Optional<Depart> findById(final String id) {
		return dpR.findById(id);
	}
	public void save(final Depart customer) {
		// check if exist -> throw exception
		dpR.save(customer);
	}

	public void update(final Depart customer) {
		// check if not exist -> throw excpetion
		dpR.save(customer);
	}

	public void delete(final String id) {
			dpR.deleteById(id);
	}
}
