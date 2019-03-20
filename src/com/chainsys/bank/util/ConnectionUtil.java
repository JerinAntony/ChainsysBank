package com.chainsys.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			connection = DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void close(Connection conn, PreparedStatement prmt,
			ResultSet resultset) {
		try {
			if (resultset != null) {
				resultset.close();
			}
			if (prmt != null) {
				prmt.close();
			}
			if (resultset != null) {
				resultset.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
