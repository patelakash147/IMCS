package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import impl.CustomerDAOimpl;
import service.CustomerService;
import service.CustomerServiceImpl;

public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestAction = request.getParameter("requestAction");
		if (requestAction.equals("DIS_CUS")) {
			request.setAttribute("page", "pages/csdisplay.jsp");
		} else if (requestAction.equals("ADD_CUS")) {
			request.setAttribute("page", "pages/addcustomer.jsp");
		} else if (requestAction.equals("UPD_CUS")) {
			request.setAttribute("page", "pages/updatecustomer.jsp");
		} else if (requestAction.equals("DIS_ADD")) {
			request.setAttribute("page", "pages/displayaddress.jsp");
		} else if (requestAction.equals("ADD_ADD")) {
			request.setAttribute("page", "pages/addaddress.jsp");
		} else if (requestAction.equals("UPD_ADD")) {
			request.setAttribute("page", "pages/updateaddress.jsp");
		} else if (requestAction.equals("DIS_ORD")) {
			request.setAttribute("page", "pages/displayorder.jsp");
		} else if (requestAction.equals("ADD_ORD")) {
			request.setAttribute("page", "pages/csdisplay.jsp");
		} else if (requestAction.equals("UPD_ORD")) {
			request.setAttribute("page", "pages/csdisplay.jsp");
		}
		RequestDispatcher homeDisp = request.getRequestDispatcher("home.jsp");
		homeDisp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerDAO impl = new CustomerDAOimpl();
		CustomerService cimpl = new CustomerServiceImpl();
		String requestAction = request.getParameter("val");

		if (requestAction.equals("DIS_CUS")) {
			String id = request.getParameter("id");
			try {
				request.setAttribute("display", impl.findCustomerById(Integer.parseInt(id)));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("page", "pages/csdisplay.jsp");
		} else if (requestAction.equals("ADD_CUS")) {
			try {
				cimpl.addCustomer(request);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("page", "pages/addcustomer.jsp");
		} else if (requestAction.equals("UPD_CUS")) {
			try {
				cimpl.UpdateCustomer(request);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("page", "pages/updatecustomer.jsp");
		} else if (requestAction.equals("DIS_ADD")) {
			String id = request.getParameter("id");
			try {
				request.setAttribute("display", impl.findAddressById(Integer.parseInt(id)));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("page", "pages/displayaddress.jsp");
		} else if (requestAction.equals("ADD_ADD")) {
			try {
				cimpl.addAddress(request);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("page", "pages/addaddress.jsp");
		} else if (requestAction.equals("UPD_ADD")) {
			try {
				cimpl.updateAddress(request);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("page", "pages/updateaddress.jsp");
		} else if (requestAction.equals("DIS_ORD")) {
			String id = request.getParameter("id");
			try {
				request.setAttribute("display", impl.findOrderById(Integer.parseInt(id)));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("page", "pages/displayorder.jsp");
		}
		RequestDispatcher homeDisp2 = request.getRequestDispatcher("home.jsp");
		homeDisp2.forward(request, response);

	}
}
