package jdbcLiberary;

public class EmployeeApp {

	public static void main(String[] args) {

		EmployeeHelper help = new EmployeeHelper();
		Employee emp1 = new Employee();
		// emp1 = EmployeeUtil.constructEmployee(1, "akash", 60000,
		// EmployeeUtil.getDate(2014), 24);
		EmployeeUtil.displayEMployee(emp1);
		EmployeeHelper helper = new EmployeeHelper(emp1);
		helper.increaseSalary();
		helper.findService();

		System.out.println("");

		Employee emp2 = new Employee();
		// emp2 = EmployeeUtil.constructEmployee(2, "rahul", 50000,
		// EmployeeUtil.getDate(2017), 30);
		EmployeeUtil.displayEMployee(emp2);
		EmployeeHelper helper2 = new EmployeeHelper(emp2);
		helper2.increaseSalary();
		helper2.findService();

		System.out.println("");

		EmployeeUtil.displayEMployee(EmployeeUtil.constructNewEmployee(emp1));
		System.out.println("Higest salary is = " + EmployeeUtil.higestSalary(emp1, emp2));
		help.findSeniorEmployee(emp1, emp2);
		help.olderEmployee(emp1, emp2);
		Department.getDepartmentName();

	}

}
