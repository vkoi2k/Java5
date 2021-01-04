package com.example.demo.entity;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Staffs")
public class Staff {
	@Id
	private String staff_id;

	private String name;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyy" )
	private Date birthday;

	private String photo;

	private boolean gender;

	private String email;

	private String phone;

	private Float salary;

	private String notes;
	

	@ManyToOne
	@JoinColumn(name = "depart_id")
	private Depart depart_id;


	public Staff() {

	}

	public Staff(String staff_id, String name, Date birthday, String photo, boolean gender, String email, String phone,
			Float salary, String notes, Depart depart_id) {
		super();
		this.staff_id = staff_id;
		this.name = name;
		this.birthday = birthday;
		this.photo = photo;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.notes = notes;
		this.depart_id = depart_id;
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Depart getDepart_id() {
		return depart_id;
	}

	public void setDepart_id(Depart dp) {
		this.depart_id = dp;
	}

	
	

}
