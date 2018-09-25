package com.service;

import com.tools.DBTools;
import com.beans.UserInfoBean;
import com.mapper.UserInfoMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserInfoService {
	/**
	 * 新增用户
	 */
	public static void insertUser(String username, String password, Double account) {
		SqlSession session = DBTools.getSession();
		UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
		UserInfoBean user = new UserInfoBean();
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
		UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
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
	public static UserInfoBean selectUserById(int id) {
		SqlSession session = DBTools.getSession();
		UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
		try {
			UserInfoBean user = mapper.selectUserById(id);
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
	public static List<UserInfoBean> selectAllUser() {
		SqlSession session = DBTools.getSession();
		UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
		try {
			List<UserInfoBean> users = mapper.selectAllUserInfo();
			session.commit();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			return null;
		}
	}
}
