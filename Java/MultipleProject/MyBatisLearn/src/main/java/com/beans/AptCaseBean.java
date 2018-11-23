package com.beans;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class AptCaseBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAptId() {
		return aptId;
	}

	public void setAptId(Integer aptId) {
		this.aptId = aptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	private Integer aptId;
	private String name;
	private String link;


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
