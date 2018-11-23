package com.beans;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class AptImageBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private int aptId;
	private String fileName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAptId() {
		return aptId;
	}

	public void setAptId(int aptId) {
		this.aptId = aptId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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
