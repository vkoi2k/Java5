package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Records")
public class Record {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	@Column(name = "record_id")
	private long record_id;

	@Column(name = "Type")
	private boolean type;

	@Column(name = "Reason")
	private String reason;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "Date")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff_id;

	public Record() {

	}

	public Record(long record_id, boolean type, String reason, Date date, Staff staff_id) {
		super();
		this.record_id = record_id;
		this.type = type;
		this.reason = reason;
		this.date = date;
		this.staff_id = staff_id;
	}

	public Record(boolean type, String reason, Date date, Staff staff_id) {
		this.type = type;
		this.reason = reason;
		this.date = date;
		this.staff_id = staff_id;
	}

	public long getRecord_id() {
		return record_id;
	}

	public void setRecord_id(long record_id) {
		this.record_id = record_id;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Staff getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Staff staff_id) {
		this.staff_id = staff_id;
	}

}
