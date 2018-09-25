package com.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.Serializable;

public class UserInfoBean implements Serializable {

	private static final long serialVersionUID = 1L;


	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	private Integer id;

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String name;
	private String address;


	public UserInfoBean() {
		super();
	}

	public UserInfoBean(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public UserInfoBean(Integer id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException Ex) {
			Ex.printStackTrace();
			return "{}";
		}
	}
}
