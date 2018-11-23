package com.stariches.demo.domain;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Take {

	public String Id;
	public String CourierNumber;
	public String AnalysisUnitName;
	public String Latitude;
	public String Longitude;
	public String UserId;
	public String UserName;
	public String AnalysisItems;
	public Map AnalysisItemsObject;
	public Date InsertTime;

	public String getCourierNumber() {
		return CourierNumber;
	}

	public void setCourierNumber(String courierNumber) {
		CourierNumber = courierNumber;
	}

	public String getAnalysisUnitName() {
		return AnalysisUnitName;
	}

	public void setAnalysisUnitName(String analysisUnitName) {
		AnalysisUnitName = analysisUnitName;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public Date getInsertTime() {
		return InsertTime;
	}

	public void setInsertTime(Date insertTime) {
		InsertTime = insertTime;
	}

	public Map getAnalysisItems() {
		try {
			return new ObjectMapper().readValue(AnalysisItems, Map.class);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}


	public void setAnalysisItems(String analysisItems) {
		AnalysisItems = analysisItems;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}
}
