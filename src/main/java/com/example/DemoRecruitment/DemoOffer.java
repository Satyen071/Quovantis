package com.example.DemoRecruitment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class DemoOffer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	 @Column(unique = true)
	private String jobTitle;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date startDate;
	@JsonManagedReference
	@OneToMany
	private List<DemoApplication> applications = new ArrayList<DemoApplication>();
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<DemoApplication> getApplications() {
		return applications;
	}
	public void setApplications(List<DemoApplication> applications) {
		this.applications = applications;
	}
	
	
	

}
