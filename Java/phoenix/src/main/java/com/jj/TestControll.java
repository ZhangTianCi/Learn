package com.jj;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class TestControll {

	public Object getTags(String userId) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:phoenix:154.8.157.163:2181");
			Statement statement = connection.createStatement();
			ResultSet userResultSet = statement.executeQuery("SELECT * FROM \"tagResult\" WHERE \"calculationDate\"='" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "' AND \"userId\"='" + userId + "'");
			ResultSetMetaData columnResultSetMetaData = userResultSet.getMetaData();
			List<Map> tagList = new ArrayList<>();
			while (userResultSet.next()) {
				LinkedHashMap item = new LinkedHashMap();
				for (int i = 0; i < columnResultSetMetaData.getColumnCount(); i++) {
					String columnLabel = columnResultSetMetaData.getColumnLabel(i + 1);
					item.put(columnLabel, userResultSet.getString(columnLabel));
				}
				tagList.add(item);
			}
			return tagList;
		} catch (Exception ex) {
			return ex.getMessage();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}
