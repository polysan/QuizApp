package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class questiondao {
	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:~/quiz";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public Map<String,List<String>> getQuestion_Answer(int quescount) {

		Connection  conn = null;
		Map<String,List<String>> QA_map = new HashMap<String,List<String>>();
		String Q = "";
		String A = "";
		List <String> answerlist = new ArrayList <String>();
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql =
			"SELECT QUESTION FROM QUESTION where ID =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, quescount);

			String sql2 =
			"SELECT ANSWER FROM QUESTION_ANSWER where QID =?";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			pStmt2.setInt(1, quescount);

			ResultSet rs = pStmt.executeQuery();
				while(rs.next()) {
					Q = rs.getString("QUESTION");
				}
			ResultSet rs2 = pStmt2.executeQuery();
				while(rs2.next()) {
					A = rs2.getString("ANSWER");
					answerlist.add(A);
				}
				QA_map.put(Q, answerlist);
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
		return QA_map;
	}
}
