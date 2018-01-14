package batch;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import problem2.Employee;
import problem2.CSVfile;

public class FileLoader implements FileLoaderService {

	CSVfile csv = new CSVfile();

	@Override
	public void loadFile(String fileName) throws Exception {
		System.out.println("Started loading file... " + fileName);
		File file = new File(fileName);
		insertData(csv.readEmployees(file));
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed loading file... " + fileName);
	}

	public void insertData(List<Employee> list) throws SQLException, ClassNotFoundException {
		final int BATCH_SIZE = 5;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
			String insertQuery = "insert into employees (empNumbers,name,salary,doj,age) values (?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			con.setAutoCommit(false);
			int count = 1;
			boolean hasLeftOverBatchRecords = true;
			for (Employee employee : list) {
				if (employee == null)
					break;
				con.setAutoCommit(false);
				pstmt.setInt(1, employee.getNumber());
				pstmt.setString(2, employee.getName());
				pstmt.setFloat(3, employee.getSalary());
				pstmt.setDate(4, java.sql.Date.valueOf(String.valueOf("2013-10-10")));
				pstmt.setInt(5, employee.getAge());
				pstmt.addBatch();
				if (count++ % BATCH_SIZE == 0) {
					int[] updateCount = pstmt.executeBatch();
					hasLeftOverBatchRecords = false;
				} else {
					hasLeftOverBatchRecords = true;
				}
			}
			if (hasLeftOverBatchRecords) {
				int[] updateCount = pstmt.executeBatch();
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		}
	}
}