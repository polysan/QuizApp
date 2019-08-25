package filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet Filter implementation class FilterLoginCheck
 */
@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST,
				DispatcherType.FORWARD
		}
					,
		urlPatterns = {
				"/FilterLoginCheck",
				"/Main",
				"/Question",
				"/Questionresult",
				"/logout"
		})
public class FilterLoginCheck implements Filter {

    /**
     * Default constructor.
     */
    public FilterLoginCheck() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest)request).getSession();
		User userIslogin = (User) session.getAttribute("USER");

		if(userIslogin != null) {
			chain.doFilter(request, response);
		}else {
			request.setAttribute("errorMsg", "ログインしてください");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
