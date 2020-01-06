package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuestionDao;
import dao.RegistQuizResultDao;
import model.QuizCount;
import model.QuizOneSet;
import model.User;

/**
 * Servlet implementation class Question
 */
@WebServlet("/Question")
public class Question extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Question() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int quescountnumber;
		QuizOneSet[] questionlist = new QuizOneSet[10];
		QuestionDao qdao = new QuestionDao();
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

//		1問目
		if(action == null){
			QuizCount quizcount = new QuizCount();
			quizcount.setQuesCount(1);
			quescountnumber = quizcount.getQuesCount();
			session.setAttribute("QUIZCOUNT",quizcount);
			for(int i = 0; i < 10; i++){
				QuizOneSet QSET = qdao.getQuestionAnswer(i+1);
				QuizOneSet.ArrayOrderRandom(QSET.getAnswers());
				questionlist[i] = QSET;
			}
			QuizOneSet.ArrayOrderRandom(questionlist);
			session.setAttribute("QUESTIONLIST",questionlist);
//		2問目以降
		}else {
			request.setCharacterEncoding("UTF-8");
			String ques = request.getParameter("ques");
//			何問目かカウントするオブジェクトをセッションから取得
			QuizCount quizcount = (QuizCount)session.getAttribute("QUIZCOUNT");
			quescountnumber = quizcount.getQuesCount();
//			回答が選択されているかチェック
			if(ques != null && ques.length() != 0) {
//				セッションから問題オブジェクトリストを取得
				QuizOneSet[] quizoneset  = (QuizOneSet[])session.getAttribute("QUESTIONLIST");
				QuizOneSet qesset  = quizoneset[quescountnumber-1];
//				選択した回答が正解かチェック
				if(ques.equals(qesset.getcorrectAnswer())) {
					int correctAnswerCount = quizcount.getCorrectAnswerCount();
					correctAnswerCount++;
					quizcount.setCorrectAnswerCount(correctAnswerCount);
				}
				quescountnumber++;
				quizcount.setQuesCount(quescountnumber);
				session.setAttribute("QUIZCOUNT",quizcount);
			}else {
				request.setAttribute("errorMsg", "回答を選択してください");
			}
		}
//		クイズ終了時
		if(quescountnumber > 10) {
//			クイズの成績をユーザーに登録
			User loginuser = (User)session.getAttribute("USER");
			QuizCount quizcount = (QuizCount)session.getAttribute("QUIZCOUNT");
			RegistQuizResultDao aa = new RegistQuizResultDao();
			boolean resultset = aa.resistQuizResult(loginuser, quizcount);
//			クイズ結果画面に遷移
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/questionresult.jsp");
			dispatcher.forward(request, response);
		}else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question.jsp");
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
