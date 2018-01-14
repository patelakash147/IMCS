package generic;

import static problem2.EmployeeUtil.getDetailsFromUsers;
import static problem2.EmployeeUtil.menuForGenerics;

import java.util.Scanner;

import problem2.Employee;

public class GenericWildcardApp {

	public static void main(String[] args) {
		WildcardGenericEmployeeServiceImpl<Employee> emp = new WildcardGenericEmployeeServiceImpl<Employee>();

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (true) {
			menuForGenerics();
			System.out.println(" 4 = Update Employee");
			System.out.println("enter your choice");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				emp.createEmployee(getDetailsFromUsers());

				break;

			case 2:
				emp.selectEmployee();
				break;

			case 3:
				System.out.println("Enter EMPLOYEE number");
				int num = sc.nextInt();
				emp.deleteEmployee(num);
				break;
			case 4:
				emp.updateEmployee(getDetailsFromUsers());

			}

		}
	}

}
