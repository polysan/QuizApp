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

public class QuestionDao {
//	private final String DRIVER_NAME = "org.h2.Driver";
//	private final String JDBC_URL = "jdbc:h2:~/quiz";
//	private final String DB_USER = "sa";
//	private final String DB_PASS = "";

	public Map<String,List<String>> getQuestionAnswer(int quescount) {


		Connection  connection = null;
		PreparedStatement pStmt = null;
		Map<String,List<String>> qaMap = new HashMap<String,List<String>>();
		String Q = "";
		String A = "";
		List <String> answerList = new ArrayList <String>();
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/Quiz");
			connection = ds.getConnection();

//			Class.forName(DRIVER_NAME);
//			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql =
			"SELECT Q.QUESTION, QA.ANSWER FROM QUESTION Q LEFT OUTER JOIN QUESTION_ANSWER QA ON Q.ID = QA.QID WHERE Q.ID =? AND QA.QID =?";
			pStmt = connection.prepareStatement(sql);

			pStmt.setInt(1, quescount);
			pStmt.setInt(2, quescount);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				Q = rs.getString("QUESTION");
				A = rs.getString("ANSWER");
				answerList.add(A);
			}
			qaMap.put(Q, answerList);

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
		return qaMap;
	}
}
