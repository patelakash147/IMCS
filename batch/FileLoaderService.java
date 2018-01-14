package batch;

import java.sql.SQLException;
import java.util.List;

import problem2.Employee;

public interface FileLoaderService {

	void loadFile(String fileName) throws Exception;
	void insertData(List<Employee> list) throws SQLException, ClassNotFoundException;

}
