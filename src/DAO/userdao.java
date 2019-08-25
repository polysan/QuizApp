package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;


public class userdao {
	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:~/quiz";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	public User logincheck(User user) {
		Connection  conn = null;

		User loginuser = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql =
			"SELECT ID,NAME,PASS FROM USER where NAME =? AND PASS =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getPass());
			ResultSet rs = pStmt.executeQuery();
				if(rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("NAME");
				String passWord = rs.getString("PASS");
				loginuser = new User(id, userName, passWord);
				}

		}catch(SQLException e){
				e.printStackTrace();
				return null;
		}catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
						return null;
				}
			}
		}
		return loginuser;
	}
}