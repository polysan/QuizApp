package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class registuserdao {
	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:~/quiz";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	public boolean NewRegist(User user) {
		Connection  conn = null;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql =
			"INSERT INTO USER (NAME,PASSWORD) VALUES (?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getPass());
			pStmt.executeUpdate();

		}catch(SQLException e){
				e.printStackTrace();
				return false;
		}catch (ClassNotFoundException e) {
				e.printStackTrace();
				return false;
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
						return false;
				}
			}
		}
		return true;
	}
}
