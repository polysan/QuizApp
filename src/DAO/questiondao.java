package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.QuizOneSet;

public class QuestionDao {

	public QuizOneSet getQuestionAnswer(int quescount) {

		Connection  connection = null;
		PreparedStatement pStmt = null;
		QuizOneSet quizOneset = new QuizOneSet();

		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/Quiz");
			connection = ds.getConnection();

			String sql =
			"SELECT Q.QUESTION, QA.ANSWER FROM QUESTION Q LEFT OUTER JOIN QUESTION_ANSWER QA ON Q.ID = QA.QID WHERE Q.ID =? AND QA.QID =?";
			pStmt = connection.prepareStatement(sql);

			pStmt.setInt(1, quescount);
			pStmt.setInt(2, quescount);

			ResultSet rs = pStmt.executeQuery();
			int i = 0;
			while(rs.next()) {
				quizOneset.setQuestion(rs.getString("QUESTION"));
				quizOneset.getAnswers()[i] = rs.getString("ANSWER");
				if(i == 0) {
//					正解の回答を変数に格納
					quizOneset.setcorrectAnswer(quizOneset.getAnswers()[i]);
				}
				i++;
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
		return quizOneset;
	}
}
