package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.User;

public class SelectQuizResultDao {
//	private final String DRIVER_NAME = "org.h2.Driver";
//	private final String JDBC_URL = "jdbc:h2:~/quiz";
//	private final String DB_USER = "sa";
//	private final String DB_PASS = "";

	public Map<List <Integer>,List <Integer>> selectQuizResult(User user) {

		Connection  connection = null;
		PreparedStatement pStmt = null;

		List <Integer> ansCount = new ArrayList <Integer>();
		List <Integer> quesCount = new ArrayList <Integer>();
		Map<List <Integer>,List <Integer>> qizResultMap = new HashMap<List <Integer>,List <Integer>>();
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/Quiz");
			connection = ds.getConnection();

//			Class.forName(DRIVER_NAME);
//			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql =
			"SELECT CORRECTCOUNT,QUESTIONCOUNT FROM QUIZ_RESULT WHERE USERID =?";
			pStmt = connection.prepareStatement(sql);

			pStmt.setInt(1, user.getId());
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				int correctCount = rs.getInt("CORRECTCOUNT");
				int questionCount = rs.getInt("QUESTIONCOUNT");
				ansCount.add(correctCount);
				quesCount.add(questionCount);
				}
			qizResultMap.put(ansCount, quesCount);

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
	return qizResultMap;
	}
}
