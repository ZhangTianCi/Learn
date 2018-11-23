package com.stariches.demo.service;

import java.util.List;
import java.util.Map;

import com.stariches.demo.domain.Take;
import com.stariches.demo.domain.TakeMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TakeService implements TakeMapper {
	@Autowired
	public TakeMapper takeMapper;

	@Override
	public Take getById(String id) {
		return takeMapper.getById(id);
	}

	@Override
	public int updateAnalysisItems(String id, String analysisItems) {
		return takeMapper.updateAnalysisItems(id, analysisItems);
	}
}
