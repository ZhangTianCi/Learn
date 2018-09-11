package com.stariches.demo.domain;

import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USER")
    List<User> selectAll();
}
