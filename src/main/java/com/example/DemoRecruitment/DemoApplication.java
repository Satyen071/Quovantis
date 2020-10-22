package com.example.DemoRecruitment;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class DemoApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	 @Column(unique = true)
	private String candidateEmail;
	private String text;
	private String applicationStatus;
	@JsonBackReference
	@ManyToOne
//	@JoinColumn(name = "cart_id")
	private DemoOffer relatedOffer;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public DemoOffer getRelatedOffer() {
		return relatedOffer;
	}
	public void setRelatedOffer(DemoOffer relatedOffer) {
		this.relatedOffer = relatedOffer;
	}
	public String getCandidateEmail() {
		return candidateEmail;
	}
	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	
	
	
	

}
