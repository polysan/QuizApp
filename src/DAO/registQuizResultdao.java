package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Quiz_count;
import model.User;

public class registQuizResultdao {
	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:~/quiz";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public boolean resistQuizResult(User user,Quiz_count quiz) {

		Connection  conn = null;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql =
			"INSERT INTO QUIZ_RESULT(CORRECTCOUNT,QUESTIONCOUNT,USERID) VALUES (?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, quiz.getKaito_count());
			pStmt.setInt(2, quiz.getQues_count()-1);
			pStmt.setInt(3, user.getId());
			pStmt.executeUpdate();
		}catch(SQLException e){
				e.printStackTrace();
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
