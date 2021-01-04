package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Record;

@Repository 
public interface  RecordRepository extends CrudRepository<Record, String> {

}
