package com.service;

import com.beans.AptBean;
import com.mapper.AptMapper;
import com.tools.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AptService {
	public static List<AptBean> getList() {
		SqlSession session = DBTools.getSession();
		AptMapper mapper = session.getMapper(AptMapper.class);
		try {
			List<AptBean> users = mapper.getList();
			session.commit();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			return null;
		}
	}
}
