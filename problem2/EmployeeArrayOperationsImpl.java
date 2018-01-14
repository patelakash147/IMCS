package problem2;

import problem2.EmployeeNotFoundException;

public class EmployeeArrayOperationsImpl implements IEmployeeOperations {

	int empSize = 0;
	int arrTrackSize = 0;
	int dummy = 0;
	private Employee[] array = null;

	public EmployeeArrayOperationsImpl() {

	};

	public EmployeeArrayOperationsImpl(int empSize) {
		this.empSize = empSize;
		array = new Employee[empSize];

	}

	public void createEmployee(Employee employee) {
		try {
			if (employee.getSalary() < 5000) {
				throw new InvalidSalaryException("salary should be more than 5000$");
			} else {
				array[dummy] = employee;
				dummy++;
				arrTrackSize++;
			}
		} catch (InvalidSalaryException e) {
			System.out.println("salary should be more than 5000$");
		}
	}

	public Employee findEmployee(int empId) {
		return array[empId - 1];

	}

	public Employee findEmployee(String name) {

		int findID = 0;
		for (int i = 0; i < arrTrackSize; i++) {
			if (array[i].getName().equals(name)) {
				findID = i;
				break;
			}
		}
		return array[findID];
	}

	public boolean deleteEmployee(int empId) throws EmployeeNotFoundException {
		boolean check = false;
		for (int i = 0; i < arrTrackSize; i++) {
			if (array[i].getId() == empId) {
				check = true;
				break;
			}
		}
		try {
			if (check == false) {
				throw new EmployeeNotFoundException("There is no employee with given employeeId");
			} else {
				int k = empId;
				int n = arrTrackSize;
				int j;
				j = k;
				while (j < n) {
					array[j - 1] = array[j];
					j = j + 1;
				}
				n = n - 1;
				arrTrackSize = n;
				return true;
			}
		} catch (EmployeeNotFoundException e) {
			System.out.println("There is no employee with given employeeId");

		}
		return true;

	}

	public boolean updateEmployee(Employee employee) throws EmployeeNotFoundException {
		boolean check = false;
		for (int i = 0; i < arrTrackSize; i++) {
			if (array[i].getNumber() == employee.getNumber()) {
				check = true;
			}
		}
		if (check == false) {
			throw new EmployeeNotFoundException("There is no employee with given employeeId");
		} else {
			for (int i = 0; i < arrTrackSize; i++) {
				if (employee.getNumber() == array[i].getNumber()) {
					array[i].setNumber(employee.getNumber());
					array[i].setName(employee.getName());
					array[i].setSalary(employee.getSalary());
					array[i].setDoj(employee.getDoj());
					array[i].setAge(employee.getAge());
				}
			}
			array[employee.getId() - 1] = employee;
			return false;
		}
	}

	public Double calculateGrossSal(int empId) {
		Object ob = null;
		ob = array[empId - 1];

		return EmployeeUtil.calculateDAandHRA((Employee) ob);
	}

	public void displayEmployee() {
		for (int i = 0; i < arrTrackSize; i++) {
			System.out.println(array[i]);
		}
	}

	public Employee[] csvWriter() {
		return array;

	}

}
