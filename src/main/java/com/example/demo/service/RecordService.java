package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Record;
import com.example.demo.repository.RecordRepository;

@Service
@Transactional
public class RecordService {
	@Autowired private RecordRepository dpR;  
	public List<Record> findAll() {
		return (List<Record>) dpR.findAll();
	}
	public Optional<Record> findById(final String id) {
		return dpR.findById(id);
	}
	public void save(final Record customer) {
		// check if exist -> throw exception
		dpR.save(customer);
	}

	public void update(final Record customer) {
		// check if not exist -> throw excpetion
		dpR.save(customer);
	}

	public void delete(final String id) {
			dpR.deleteById(id);
	}
}
