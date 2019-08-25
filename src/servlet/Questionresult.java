package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Question;

/**
 * Servlet implementation class Questionresult
 */
@WebServlet("/Questionresult")
public class Questionresult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Questionresult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ques2 = request.getParameter("ques2");
		if(ques2 != null && ques2.length() != 0) {
			HttpSession session = request.getSession();
			Question question =(Question)session.getAttribute("QUESTION");
			question.setAnswer2(ques2);

			ArrayList<String> questionlist = new ArrayList<String>();
			questionlist.add(question.getAnswer1());
			questionlist.add(question.getAnswer2());
			session.setAttribute("QUESTIONLIST",questionlist);

			session.setAttribute("QUESTION",question);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Questionresult.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("errorMsg", "回答を選択してください");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question2.jsp");
			dispatcher.forward(request, response);
		}

//		 int count = 0;
//		 for(int i = 0; i < questionlist.size(); i++) {
//			 if(questionlist.get(i).equals("good")) {
//				 count++;
//			 }
//		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
