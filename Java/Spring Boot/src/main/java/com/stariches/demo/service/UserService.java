package com.stariches.demo.service;

import com.stariches.demo.domain.User;
import org.springframework.stereotype.*;
import com.stariches.demo.domain.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService implements UserMapper {
    @Autowired
    public UserMapper userMapperp;

    @Override
    public List<User> selectAll() {
        return userMapperp.selectAll();
    }
}
