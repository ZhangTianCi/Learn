package com.stariches.demo.domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface TakeMapper {
	@Select("SELECT * FROM`t_take`WHERE `Id`= #{id} ;")
	Take getById(String id);

	@Update("UPDATE`t_take`SET`AnalysisItems`= #{analysisItems} WHERE Id= #{id} ;")
	int updateAnalysisItems(@Param("id") String id, @Param("analysisItems") String analysisItems);
}
