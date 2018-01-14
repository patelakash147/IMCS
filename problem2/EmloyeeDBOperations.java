package problem2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmloyeeDBOperations implements IEmployeeOperations {
	Connection con;

	public EmloyeeDBOperations() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createEmployee(Employee employee) throws EmployeeNotFoundException, SQLException {
		ResultSet rs = null;
		if (employee.getSalary() < 5000)
			throw new InvalidSalaryException("salary should be more than 5000$");
		else
			try {
				String insertQuery = "insert into employees (empNumbers,name,salary,doj,age) values (?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(insertQuery);
				pstmt.setInt(1, employee.getNumber());
				pstmt.setString(2, employee.getName());
				pstmt.setFloat(3, employee.getSalary());
				pstmt.setDate(4, java.sql.Date.valueOf(String.valueOf("2013-10-10")));
				pstmt.setInt(5, employee.getAge());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			}
	}

	@Override
	public Employee findEmployee(int empId) throws SQLException {
		ResultSet rs = null;
		Employee emp = new Employee();
		try {
			rs = con.createStatement().executeQuery("select * from employees where empNumbers=" + empId);
			while (rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setNumber(rs.getInt("empNumbers"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getFloat("salary"));
				emp.setDoj(rs.getDate("doj"));
				emp.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
		return emp;
	}

	@Override
	public Employee findEmployee(String name) throws SQLException {

		ResultSet rs = null;
		Employee emp = new Employee();
		try {
			rs = con.createStatement().executeQuery("select * from employees where name= '" + name + "'");
			while (rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setNumber(rs.getInt("empNumbers"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getFloat("salary"));
				emp.setDoj(rs.getDate("doj"));
				emp.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
		return emp;
	}

	@Override
	public boolean deleteEmployee(int empId) throws EmployeeNotFoundException, SQLException {
		ResultSet rs = null;
		try {
			rs = con.createStatement().executeQuery("select name from employees where empNumbers=" + empId);
			if (rs.next()) {
				con.createStatement().executeUpdate("delete from employees where empNumbers=" + empId);
			} else {
				throw new EmployeeNotFoundException("Employee not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) throws EmployeeNotFoundException, SQLException {
		ResultSet rs = null;
		try {
			rs = con.createStatement()
					.executeQuery("select name from employees where empNumbers=" + employee.getNumber());
			if (rs.next()) {
				con.createStatement()
						.executeUpdate("update employees SET empNumbers = " + employee.getNumber() + ", name = '"
								+ employee.getName() + "', salary=" + employee.getSalary() + ", doj='2008-10-10', age="
								+ employee.getAge() + " WHERE empNumbers=" + employee.getNumber());
			} else {
				throw new EmployeeNotFoundException("Employee not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Double calculateGrossSal(int empId) throws SQLException {
		ResultSet rs = null;
		Employee emp = new Employee();
		try {
			rs = con.createStatement().executeQuery("select * from employees where empNumbers=" + empId);
			while (rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setNumber(rs.getInt("empNumbers"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getFloat("salary"));
				emp.setDoj(rs.getDate("doj"));
				emp.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
		return EmployeeUtil.calculateDAandHRA(emp);
	}

	public void displayEmployee() throws SQLException {
		ResultSet rs = null;
		try {
			rs = con.createStatement().executeQuery("select * from employees ");
			while (rs.next()) {
				System.out.printf("%6s %6s %6s %6s %6s %6s\n", rs.getInt("id"), rs.getInt("empNumbers"),
						rs.getString("name"), rs.getFloat("salary"), rs.getDate("doj"), rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
	}

	public void sortBy(int num) throws SQLException {
		ResultSet rs = null;
		try {
			switch (num) {
			case 1:
				rs = con.createStatement().executeQuery("select * from employees order by name ");
				break;
			case 2:
				rs = con.createStatement().executeQuery("select * from employees order by age, salary ");
				break;
			}
			while (rs.next()) {
				System.out.printf("%6s %6s %6s %6s %6s %6s\n", rs.getInt("id"), rs.getInt("empNumbers"),
						rs.getString("name"), rs.getFloat("salary"), rs.getDate("doj"), rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
	}

	public void uniqueName() throws SQLException {
		ResultSet rs = null;
		try {
			rs = con.createStatement().executeQuery("select DISTINCT name from employees ");
			while (rs.next()) {
				System.out.printf("%6s \n", rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
	}

	public void sortByAgeRange() throws SQLException {
		ResultSet rs = null;
		ResultSet rs1 = null;
		try {
			rs = con.createStatement().executeQuery("select count(*) from employees e where e.age between 20 and 30");
			rs1 = con.createStatement().executeQuery("select count(*) from employees e where e.age between 31 and 40");
			while (rs.next()) {
				System.out.println("Age range 20-30 = " + rs.getString("count(*)"));
			}
			while (rs1.next()) {
				System.out.println("Age range 31-40 = " + rs1.getString("count(*)"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
	}
}
