package generic;

import problem2.Employee;

public interface WildcardGenericEmployeeService<E extends Employee> {
	
	void createEmployee( E  e );

	void selectEmployee();

	boolean deleteEmployee(int id);

	boolean updateEmployee( E  e );

}
