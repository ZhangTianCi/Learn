package com.tools;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBTools {
	public static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			//使用MyBatis提供的Resources类加载mybatis的配置文件
			Reader reader = Resources.getResourceAsReader("mybatis.config.xml");
			//构建sqlSession的工厂
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception Ex) {
			System.err.println("sqlSessionFactory 初始化失败。");
			Ex.printStackTrace();
		}
	}

	//创建能执行映射文件中sql的sqlSession
	public static SqlSession getSession() {
		if (sqlSessionFactory == null) throw new NullPointerException("sqlSessionFactory is null。");
		return sqlSessionFactory.openSession();
	}

}