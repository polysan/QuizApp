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

		int quescount = 0;
		QuizOneSet[] questionlist = new QuizOneSet[10];
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

//		1問目
		if(action == null){
			QuizCount quizcount = new QuizCount();
			quizcount.setQuesCount(1);
			quescount = quizcount.getQuesCount();
			session.setAttribute("QUIZCOUNT",quizcount);
			QuestionDao qdao = new QuestionDao();
			session.setAttribute("QDAO",qdao);
			for(int i=0; i < 10; i++){
				QuizOneSet QSET = qdao.getQuestionAnswer(i);
				QuizOneSet.ArrayOrderRandom(QSET.getAnswers());
				questionlist[i] = QSET;
			}
			QuizOneSet.ArrayOrderRandom(questionlist);
			session.setAttribute("QUESTIONLIST",questionlist);
//		2問目以降
		}else {
			request.setCharacterEncoding("UTF-8");
			String ques = request.getParameter("ques");
			QuizCount quizcount = (QuizCount)session.getAttribute("QUIZCOUNT");
			if(ques != null && ques.length() != 0) {
				if(ques.equals("good")) {
					int kaitoCount = quizcount.getKaitoCount();
					kaitoCount++;
					quizcount.setKaitoCount(kaitoCount);
				}
				quescount = quizcount.getQuesCount();
				quescount++;
				quizcount.setQuesCount(quescount);
				session.setAttribute("QUIZCOUNT",quizcount);
				QuestionDao qdao = (QuestionDao)session.getAttribute("QDAO");
				QuizOneSet QA = qdao.getQuestionAnswer(quescount);
				session.setAttribute("QAMAP",QA);
			}else {
				request.setAttribute("errorMsg", "回答を選択してください");
			}
		}

		if(quescount > 10) {
			User loginuser = (User)session.getAttribute("USER");
			QuizCount quizcount = (QuizCount)session.getAttribute("QUIZCOUNT");
			RegistQuizResultDao aa = new RegistQuizResultDao();
			boolean resultset = aa.resistQuizResult(loginuser, quizcount);

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
