package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.questiondao;
import model.Quiz_count;

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
		HttpSession session = request.getSession();
//		Quiz_count count = (Quiz_count)session.getAttribute("QUIZCOUNT");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
//		1問目
//		if(count == null){
		if(action == null){
			Quiz_count quizcount = new Quiz_count();
			quizcount.setQues_count(1);
			quescount = quizcount.getQues_count();
			session.setAttribute("QUIZCOUNT",quizcount);

			questiondao qdao = new questiondao();
			session.setAttribute("QDAO",qdao);
			Map<String,List<String>> QA = qdao.getQuestion_Answer(quescount);
			session.setAttribute("QAMAP",QA);
//		2問目以降
		}else {
			request.setCharacterEncoding("UTF-8");
			String ques = request.getParameter("ques");
			Quiz_count quizcount = (Quiz_count)session.getAttribute("QUIZCOUNT");
			if(ques != null && ques.length() != 0) {
				if(ques.equals("good")) {
					int kaitoCount = quizcount.getKaito_count();
					kaitoCount++;
					quizcount.setKaito_count(kaitoCount);
				}
				quescount = quizcount.getQues_count();
				quescount++;
				quizcount.setQues_count(quescount);
				session.setAttribute("QUIZCOUNT",quizcount);
				questiondao qdao = (questiondao)session.getAttribute("QDAO");
				Map<String,List<String>> QA = qdao.getQuestion_Answer(quescount);
				session.setAttribute("QAMAP",QA);
			}else {
				request.setAttribute("errorMsg", "回答を選択してください");
			}
		}

		if(quescount > 10) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Questionresult.jsp");
			dispatcher.forward(request, response);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
