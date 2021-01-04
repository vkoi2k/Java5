package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Depart;

@Repository 
public interface  DepartRepository extends CrudRepository<Depart, String> {

}
