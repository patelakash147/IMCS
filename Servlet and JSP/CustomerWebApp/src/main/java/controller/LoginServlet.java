package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cmn.HttpRequestConstants;
import cmn.UserInfo;
import service.CustomerService;
import service.CustomerServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter(HttpRequestConstants.USER_NAME);
		String password = request.getParameter(HttpRequestConstants.PASSWORD);

		UserInfo user = new UserInfo();
		user.setUserId(userName);
		user.setPassword(password);

		CustomerService userHelper = new CustomerServiceImpl();
		boolean validUser = userHelper.validateUser(user, getServletConfig());

		if (validUser) {
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", user);
			request.setAttribute("page", "body.jsp");
			RequestDispatcher homeDisp = request.getRequestDispatcher("home.jsp");
			homeDisp.forward(request, response);
		} else {
			request.setAttribute("error1", "Invalid Password");
			request.setAttribute("error2", "Try Again!!!");
			RequestDispatcher homeDisp = request.getRequestDispatcher("login.jsp");
			homeDisp.forward(request, response);
		}
	}
}
