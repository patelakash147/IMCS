package generic;

import problem2.Employee;
import static problem2.EmployeeUtil.*;

import java.util.Scanner;

public class GnericEmployeeApp {

	public static void main(String[] args) {
		GenericEmployeeService<Employee, Integer> emp = new GenericEmployeeServiceImpl<>();

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (true) {
			menuForGenerics();
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

			}

		}
	}

}
