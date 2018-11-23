package com.beans;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class AptBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String code;
	private Date time;

	public List<AptCaseBean> getCaseList() {
		return caseList;
	}

	public void setCaseList(List<AptCaseBean> caseList) {
		this.caseList = caseList;
	}

	public List<AptImageBean> getImageList() {
		return imageList;
	}

	public void setImageList(List<AptImageBean> imageList) {
		this.imageList = imageList;
	}

	private List<AptCaseBean> caseList;
	private List<AptImageBean> imageList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
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
