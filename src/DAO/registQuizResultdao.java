package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.QuizCount;
import model.User;

public class RegistQuizResultDao {
//	private final String DRIVER_NAME = "org.h2.Driver";
//	private final String JDBC_URL = "jdbc:h2:~/quiz";
//	private final String DB_USER = "sa";
//	private final String DB_PASS = "";

	public boolean resistQuizResult(User user,QuizCount quiz) {

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
			"INSERT INTO QUIZ_RESULT(CORRECTCOUNT,QUESTIONCOUNT,USERID) VALUES (?,?,?)";
			pStmt = connection.prepareStatement(sql);

			pStmt.setInt(1, quiz.getKaitoCount());
			pStmt.setInt(2, quiz.getQuesCount()-1);
			pStmt.setInt(3, user.getId());
			pStmt.executeUpdate();

			connection.commit();
		}catch(Exception e){
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
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
