package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegistLogic;
import model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String forwardPath = null;

		String action = request.getParameter("action");

		if(action == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
			dispatcher.forward(request, response);
		}
		else if(action.equals("done")) {
			HttpSession session = request.getSession();
			User registuser = (User)session.getAttribute("REGISTUSER");
			RegistLogic logic = new RegistLogic();
			boolean result = logic.execute(registuser);
			if(result) {
				session.removeAttribute("REGISTUSER");
				request.setAttribute("CANNEWREGIST", result);
				forwardPath = "/WEB-INF/jsp/registresult.jsp";
			}else {
				response.sendRedirect("/WEB-INF/jsp/registresult.jsp");
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("pass");

		if((name != null && name.length() != 0)&&(password != null && password.length() != 0)) {
			User registuser = new User(name,password);
			HttpSession session = request.getSession();
			session.setAttribute("REGISTUSER", registuser);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerconfirm.jsp");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("errorMsg", "IDとパスワードを入力してください");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
			dispatcher.forward(request, response);
		}
	}

}
