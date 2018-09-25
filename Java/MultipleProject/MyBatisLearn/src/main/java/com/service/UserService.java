package com.service;

import com.beans.UserBean;
import com.mapper.UserMapper;
import com.tools.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserService {
	/**
	 * 新增用户
	 */
	public static void insertUser(String username, String password, Double account) {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		UserBean user = new UserBean(username, password, account);
		try {
			mapper.insertUser(user);
			System.out.println(user.toString());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}


	/**
	 * 删除用户
	 */
	public static void deleteUser() {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			mapper.deleteUser(1);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

	/**
	 * 根据id查询用户
	 */
	public static UserBean selectUserById(int id) {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			UserBean user = mapper.selectUserById(id);
			session.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			return null;
		}
	}

	/**
	 * 查询所有的用户
	 */
	public static List<UserBean> selectAllUser() {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			List<UserBean> users = mapper.selectAllUser();
			session.commit();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			return null;
		}
	}
}
