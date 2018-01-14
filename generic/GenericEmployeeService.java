package generic;




public interface GenericEmployeeService<C,T> {
	
	void createEmployee(C e);

	void selectEmployee();

	boolean deleteEmployee(int id);	
}
