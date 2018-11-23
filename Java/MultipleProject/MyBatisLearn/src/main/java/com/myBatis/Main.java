package com.myBatis;

import com.service.*;

public class Main {
	public static void main(String[] args) {
		System.out.println("MyBatisLearn");
		//Test.insertUser("张天赐", "472546", 11111.0);
		//System.out.println(UserService.selectUserById(6));
		//System.out.println(UserService.selectAllUser());
		//System.out.println(UserInfoService.selectAllUser());
		System.out.println(AptService.getList());
	}
}
