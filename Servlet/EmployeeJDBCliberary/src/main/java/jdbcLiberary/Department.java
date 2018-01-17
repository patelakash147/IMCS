package jdbcLiberary;

import java.util.Scanner;

public enum Department {
	SALES(10), PURCHASE(20), ADMINISTRATION(30), RESEARCH(40);

	int val;

	private Department(int val) {
		this.val = val;
	}

	public static void getDepartmentName() {
		System.out.println("Enter code for Department");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int user = sc.nextInt();
		Department val = null;
		for (Department dep : Department.values()) {
			if (dep.val == user) {
				val = dep;
			}
		}
		if (val != null) {
			System.out.println("Department is " + val);
		} else {
			System.out.println("There have no department exist");
		}

	}

}
