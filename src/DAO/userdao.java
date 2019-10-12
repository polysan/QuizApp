package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.User;


public class UserDao {
//	private final String DRIVER_NAME = "org.h2.Driver";
//	private final String JDBC_URL = "jdbc:h2:~/quiz";
//	private final String DB_USER = "sa";
//	private final String DB_PASS = "";

	public User loginCheck(User user)  {
		Connection  connection = null;
		PreparedStatement pStmt = null;
		User loginuser = null;
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/Quiz");
			connection = ds.getConnection();

//			Class.forName(DRIVER_NAME);
//			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql =
			"SELECT USERID,NAME,PASSWORD FROM USER WHERE NAME =? AND PASSWORD =?";
			 pStmt = connection.prepareStatement(sql);

			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getPass());
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("USERID");
				String userName = rs.getString("NAME");
				String passWord = rs.getString("PASSWORD");
				loginuser = new User(id, userName, passWord);
			}

		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			if(connection != null) {
				try {
				pStmt.close();
				connection.close();
				}catch(SQLException e) {
				e.printStackTrace();
				return null;
				}
			}
		}
		return loginuser;
	}
}