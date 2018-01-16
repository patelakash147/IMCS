package assignments;

import java.util.Comparator;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class Employee implements Comparable<Employee> {

	@Getter @Setter public static String COMPANY_NAME;

	@Getter @Setter private int id;

	@Getter @Setter private int number;
	@Getter @Setter private String name;
	@Getter @Setter private float salary;
	@Getter @Setter private Date doj;
	@Getter @Setter private int age;

	static {
		COMPANY_NAME = "XYZ Comp";
	}

	{
		salary = 10000;
	}

	public float getHRA() {

		return 20 * salary / 100;

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
