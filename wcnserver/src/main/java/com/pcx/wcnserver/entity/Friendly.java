package com.pcx.wcnserver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Friendly {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String a_id;

	@Column(nullable = false)
	private String b_id;
	

	@Column(nullable = false)
	private String b_name;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getA_id() {
		return a_id;
	}


	public void setA_id(String a_id) {
		this.a_id = a_id;
	}


	public String getB_id() {
		return b_id;
	}


	public void setB_id(String b_id) {
		this.b_id = b_id;
	}


	public String getB_name() {
		return b_name;
	}


	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	
	
	
}
