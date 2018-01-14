package problem2;

import java.util.Comparator;
import java.util.Date;

public class Employee implements Comparable<Employee> {

	public static String COMPANY_NAME;

	private int id;

	private int number;
	private String name;
	private float salary;
	private Date doj;
	private int age;

	static {
		COMPANY_NAME = "XYZ Comp";
	}

	{
		salary = 10000;
	}

	public static String getCompanyName() {
		return COMPANY_NAME;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public float getHRA() {

		return 20 * salary / 100;

	}

	public static String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}

	public static void setCOMPANY_NAME(String cOMPANY_NAME) {
		COMPANY_NAME = cOMPANY_NAME;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", number=" + number + ", name=" + name + ", salary=" + salary + ", doj=" + doj
				+ ", age=" + age + "]";
	}

	@Override
	public int compareTo(Employee o) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;
		if (name.compareTo(o.name) > 0)
			return AFTER;
		if (name.compareTo(o.name) < 0)
			return BEFORE;
		return EQUAL;
	}

	static class EmployeeComparator implements Comparator<Employee> {

		@Override
		public int compare(Employee s1, Employee s2) {
			final int BEFORE = -1;
			final int EQUAL = 0;
			final int AFTER = 1;

			if (s1.age > s2.age)
				return AFTER;
			if (s1.age < s2.age)
				return BEFORE;

			if (s1.salary > s2.salary)
				return BEFORE;
			if (s1.salary < s2.salary)
				return AFTER;

			return EQUAL;
		}
	}

}
