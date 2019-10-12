package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.User;

public class RegistUserDao {
//	private final String DRIVER_NAME = "org.h2.Driver";
//	private final String JDBC_URL = "jdbc:h2:~/quiz";
//	private final String DB_USER = "sa";
//	private final String DB_PASS = "";

	public boolean newRegist(User user) {
		Connection  connection = null;
		PreparedStatement pStmt = null;

		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/Quiz");
			connection = ds.getConnection();

//			Class.forName(DRIVER_NAME);
//			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			connection.setAutoCommit(false);

			String sql =
			"INSERT INTO USER (NAME,PASSWORD) VALUES (?,?)";
			pStmt = connection.prepareStatement(sql);

			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getPass());
			pStmt.executeUpdate();

			connection.commit();
		}catch(Exception e){
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
				e.printStackTrace();
				return false;
		}finally {
			if(connection != null) {
				try {
					pStmt.close();
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}
}
