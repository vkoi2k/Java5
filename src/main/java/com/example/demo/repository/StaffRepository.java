package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Staff;

@Repository 
public interface  StaffRepository extends CrudRepository<Staff, String> {

}
