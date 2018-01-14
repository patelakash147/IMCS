package problem2;

import java.sql.SQLException;

public interface IEmployeeOperations {

	void createEmployee(Employee employee) throws EmployeeNotFoundException, SQLException;

	Employee findEmployee(int empId) throws SQLException;

	Employee findEmployee(String name) throws SQLException;

	boolean deleteEmployee(int empId) throws EmployeeNotFoundException, SQLException;

	boolean updateEmployee(Employee employee) throws EmployeeNotFoundException, SQLException;

	Double calculateGrossSal(int empId) throws SQLException;
    
	

}
