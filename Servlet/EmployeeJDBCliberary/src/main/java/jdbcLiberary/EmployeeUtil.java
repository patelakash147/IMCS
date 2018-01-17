package jdbcLiberary;

import java.io.File;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeUtil {

	static Scanner sc = new Scanner(System.in);
	static int id = 1;
	static Employee obj = null;

	public static Employee constructEmployee(int num, int number, String name, float salary, int doj, int age) {
		Employee employee = new Employee();
		employee.setId(num);
		employee.setNumber(number);
		employee.setName(name);
		employee.setSalary(salary);
		employee.setDoj(getDate(doj));
		employee.setAge(age);
		return employee;
	}

	public static void displayEMployee(Employee employee) {
		System.out.println(employee);
	}

	public static float higestSalary(Employee employee1, Employee employee2) {
		return (employee1.getSalary() < employee2.getSalary()) ? employee2.getSalary() : employee1.getSalary();
	}

	public static Employee constructNewEmployee(Employee employee) {
		Employee emp = new Employee();
		emp = employee;
		return emp;
	}

	public static Date getDate(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		return calendar.getTime();
	}

	public static double calculateDAandHRA(Employee employee) {
		float DA, HRA;
		if (employee.getSalary() < 10000) {
			DA = 8 * employee.getSalary() / 100;
			HRA = 15 * employee.getSalary() / 100;
			return employee.getSalary() + DA + HRA;
		} else if (employee.getSalary() < 20000) {
			DA = 10 * employee.getSalary() / 100;
			HRA = 20 * employee.getSalary() / 100;
			return employee.getSalary() + DA + HRA;
		} else if (employee.getSalary() < 20000 && employee.getAge() >= 40) {
			DA = 15 * employee.getSalary() / 100;
			HRA = 27 * employee.getSalary() / 100;
			return employee.getSalary() + DA + HRA;
		} else if (employee.getSalary() < 30000 && employee.getAge() < 40) {
			DA = 13 * employee.getSalary() / 100;
			HRA = 25 * employee.getSalary() / 100;
			return employee.getSalary() + DA + HRA;
		} else {
			DA = 17 * employee.getSalary() / 100;
			HRA = 30 * employee.getSalary() / 100;
			return employee.getSalary() + DA + HRA;
		}

	}

	public static Employee getDetailsFromUsers() {
		System.out.println("Enter employee number ");
		int number = sc.nextInt();
		System.out.println("Enter employee name ");
		String name = sc.next();
		System.out.println("Enter employee salary ");
		float salary = sc.nextFloat();
		System.out.println("Enter employee join date (only year) ");
		int doj = sc.nextInt();
		System.out.println("Enter age of employee");
		int age = sc.nextInt();
		return constructEmployee(id++, number, name, salary, doj, age);
	}

	public static int getValueForArray() {
		System.out.println("Enter value for EMPLOYEE array");
		int e_number = sc.nextInt();
		return e_number;
	}

	public static void importFileData(CollectionEmployeeOperations impl) throws Exception {
		String str = "C:/file.csv";
		File file = new File(str);
		CSVfile csv = new CSVfile();
		csv.numberOfLine(file);
		csv.findNumbers(file);
		int csvId = 1;
		List<Employee> list = csv.readEmployees(file);
		for (int i = 0; i < list.size(); i++) {
			impl.createEmployee(list.get(i));
			csvId++;
		}
		id = csvId;
	}

	public static void printMenu() {
		System.out.println("");
		System.out.println("ENTER CHARACTER FOR REQUIRED FUNCTION");
		System.out.println(" 1 = Enter new EMPLOYEE");
		System.out.println(" 2 = Find EMPLOYEE by id");
		System.out.println(" 3 = Find EMPLOYEE by name");
		System.out.println(" 4 = Delete EMPLOYEE");
		System.out.println(" 5 = Update EMPLOYEE");
		System.out.println(" 6 = Calculate gross salary");
		System.out.println(" 7 = Display all information of EMPLOYEE");
		System.out.println(" 8 = Sort data");
		System.out.println(" 9 = Dispaly unique EMPLOYEE name");
		System.out.println(" 10 = Display Employee Age Range wise count ");
		System.out.println(" 11 =  EXIT");
		System.out.println("");
	}

	public static void printSortMenu() {
		System.out.println("");
		System.out.println("1 Sort based on name");
		System.out.println("2 sort based on age and salary");
	}

	public static void uniqueName(List<Employee> emp) {
		Set<String> al = new TreeSet<String>();

		for (int i = 0; i < emp.size(); i++) {
			al.add(emp.get(i).getName());
		}

		System.out.println(al);

	}
	
	public static void menuForGenerics() {
		
		System.out.println("");
		System.out.println("ENTER CHARACTER FOR REQUIRED FUNCTION");
		System.out.println(" 1 = Enter new EMPLOYEE");
		System.out.println(" 2 = Select all EMPLOYEE");
		System.out.println(" 3 = Delete EMPLOYEE by id");
		System.out.println("");
		
	}

	public static void ageRangeOfEmployee(List<Employee> emp) {
		
		int rangeCount1=0;
		int rangeCount2=0;
	for(int i=0;i<emp.size();i++) {
		if(emp.get(i).getAge()>= 20 && emp.get(i).getAge() <= 30) {
			rangeCount1++;
		}
		else if(emp.get(i).getAge()>= 30 && emp.get(i).getAge() <= 40) {
			rangeCount2++;
		}
		
		
	}
	System.out.println("20-30 : " + rangeCount1);
	System.out.println("30-40 : " +rangeCount2);
	}

	public static void sortMenu(List<Employee> emp) {
		int num = sc.nextInt();
		switch (num) {
		case 1:
			Collections.sort(emp);
			for (Employee counter : emp) {
				System.out.println(counter);
			}
			break;
		case 2:
			Collections.sort(emp, new Employee.EmployeeComparator());
			for (Employee counter : emp) {
				System.out.println(counter);
			}
			break;

		}
	}

}
