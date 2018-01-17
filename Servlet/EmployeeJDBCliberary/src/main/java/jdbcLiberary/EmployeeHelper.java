package jdbcLiberary;

import java.util.Calendar;

public class EmployeeHelper {

	Employee employee = null;

	public EmployeeHelper() {
	};

	public EmployeeHelper(Employee employee) {
		this.employee = employee;
	}

	public void increaseSalary() {

		float val = 20 * employee.getSalary() / 100;
		float ans = employee.getSalary() + val;
		employee.setSalary(ans);
		System.out.println("increased salary is = " + ans);
	}

	public void findService() {

		int year = Calendar.getInstance().get(Calendar.YEAR);
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(employee.getDoj());
		int year2 = calendar1.get(Calendar.YEAR);
		System.out.println("employee gave service " + (year - year2) + " years");

	}

	public void findSeniorEmployee(Employee employee1, Employee employee2) {

		if (employee1.getDoj().compareTo(employee2.getDoj()) < 0) {
			System.out.println("Senior is " + employee1.getName());
		} else {
			System.out.println("Senior is " + employee2.getName());
		}

	}

	public void olderEmployee(Employee e1, Employee e2) {

		if (e1.getAge() < e2.getAge()) {
			System.out.println("Older is " + e2.getName());
		} else {
			System.out.println("Older is " + e1.getName());
		}
	}

	public void updateEmployeeSalary() {
		if (employee.getSalary() < 10000 && employee.getAge() > 35) {
			employee.setSalary((15 * employee.getSalary() / 100) + employee.getSalary());
		} else if (employee.getSalary() < 15000 && employee.getAge() > 45) {
			employee.setSalary((20 * employee.getSalary() / 100) + employee.getSalary());
		} else if (employee.getSalary() < 20000 && employee.getAge() > 55) {
			employee.setSalary((25 * employee.getSalary() / 100) + employee.getSalary());
		}
	}

	public void calculateDAandHRA() {
		float DA, HRA;
		if (employee.getSalary() < 10000) {
			DA = 8 * employee.getSalary() / 100;
			HRA = 15 * employee.getSalary() / 100;
			System.out.println("Grocc salary is " + (employee.getSalary() + DA + HRA));
		} else if (employee.getSalary() < 20000) {
			DA = 10 * employee.getSalary() / 100;
			HRA = 20 * employee.getSalary() / 100;
			System.out.println("Grocc salary is " + (employee.getSalary() + DA + HRA));
		} else if (employee.getSalary() < 20000 && employee.getAge() >= 40) {
			DA = 15 * employee.getSalary() / 100;
			HRA = 27 * employee.getSalary() / 100;
			System.out.println("Grocc salary is " + (employee.getSalary() + DA + HRA));
		} else if (employee.getSalary() < 30000 && employee.getAge() < 40) {
			DA = 13 * employee.getSalary() / 100;
			HRA = 25 * employee.getSalary() / 100;
			System.out.println("Grocc salary is " + (employee.getSalary() + DA + HRA));
		} else {
			DA = 17 * employee.getSalary() / 100;
			HRA = 30 * employee.getSalary() / 100;
			System.out.println("Grocc salary is " + (employee.getSalary() + DA + HRA));
		}

	}

}
