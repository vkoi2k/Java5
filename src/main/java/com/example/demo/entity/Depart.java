package com.example.demo.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.example.demo.entity.Staff;

@Entity
@Table(name = "Departs")
public class Depart {
	@Id
	@Column(name="depart_id")
	private String depart_id;
	
	@Column(name="Name")
	private String name;

	@OneToMany(mappedBy = "depart_id",fetch = FetchType.EAGER)
	private Collection<Staff> staff_id;
	 
	public Depart(String id, String name) {
		this.depart_id = id;
		this.name = name;
	}
	
	public Depart() {
	}

	public String getDepart_id() {
		return depart_id;
	}

	public void setDepart_id(String depart_id) {
		this.depart_id = depart_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Staff> getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Collection<Staff> staff_id) {
		this.staff_id = staff_id;
	}
	
	

	
	
}
