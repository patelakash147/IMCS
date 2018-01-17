package empSearch;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcLiberary.EmloyeeDBOperations;
import jdbcLiberary.Employee;
import jdbcLiberary.IEmployeeOperations;

public class EmployeeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int num = 0;

	public EmployeeSearch() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		num = 0;
		RequestDispatcher rd = request.getRequestDispatcher("pages/empSearch.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		num = 1;
		String empNum = request.getParameter("empNumber");
		IEmployeeOperations empl = new EmloyeeDBOperations();
		Employee emp = null;
		try {
			emp = empl.findEmployee(Integer.parseInt(empNum));
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (emp.getId() == 0) {
			request.setAttribute("error", "No Employee found");
			doGet(request, response);
		} else {
			request.setAttribute("emp", emp);
			doGet(request, response);
		}

	}

}
