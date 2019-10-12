package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.QuizCount;
import model.User;

public class RegistQuizResultDao {
	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:~/quiz";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public boolean resistQuizResult(User user,QuizCount quiz) {

		Connection  conn = null;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			conn.setAutoCommit(false);

			String sql =
			"INSERT INTO QUIZ_RESULT(CORRECTCOUNT,QUESTIONCOUNT,USERID) VALUES (?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, quiz.getKaitoCount());
			pStmt.setInt(2, quiz.getQuesCount()-1);
			pStmt.setInt(3, user.getId());
			pStmt.executeUpdate();

			conn.commit();
		}catch(SQLException e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
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
