package com.mapper;

import com.beans.UserInfoBean;

import java.util.List;

public interface UserInfoMapper {
	/**
	 * 新增用戶
	 *
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int insertUser(UserInfoBean user) throws Exception;

	/**
	 * 修改用戶
	 *
	 * @param user
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updateUser(UserInfoBean user, int id) throws Exception;

	/**
	 * 刪除用戶
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteUser(int id) throws Exception;

	/**
	 * 根据id查询用户信息
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserInfoBean selectUserById(int id) throws Exception;

	/**
	 * 查询所有的用户信息
	 *
	 * @return
	 * @throws Exception
	 */
	public List<UserInfoBean> selectAllUserInfo() throws Exception;
}
