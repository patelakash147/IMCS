package jdbcLiberary;

import java.util.ArrayList;
import java.util.List;

public class CollectionEmployeeOperations implements IEmployeeOperations {

	private List<Employee> list = new ArrayList<Employee>();

	@Override
	public void createEmployee(Employee employee) throws InvalidSalaryException {
		if (employee.getSalary() < 5000)
			throw new InvalidSalaryException("salary should be more than 5000$");
		else
			list.add(employee);
	}

	@Override
	public Employee findEmployee(int empId) {
		return list.get(empId - 1);
	}

	@Override
	public Employee findEmployee(String name) {
		int findId = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				findId = i;
				break;
			}
		}
		return list.get(findId);
	}

	@Override
	public boolean deleteEmployee(int empId) throws EmployeeNotFoundException {
		boolean check = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == empId) {
				check = true;
				break;
			}
		}
		if (check == false) {
			throw new EmployeeNotFoundException("There is no employee with given employeeId");
		} else {
			list.remove(empId - 1);
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) throws EmployeeNotFoundException {
		boolean check = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNumber() == employee.getNumber()) {
				check = true;
			}
		}
		if (check == false) {
			throw new EmployeeNotFoundException("There is no employee with given employeeId");
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (employee.getNumber() == list.get(i).getNumber()) {
					list.get(i).setNumber(employee.getNumber());
					list.get(i).setName(employee.getName());
					list.get(i).setSalary(employee.getSalary());
					list.get(i).setDoj(employee.getDoj());
					list.get(i).setAge(employee.getAge());
				}
			}
			return true;
		}
	}

	@Override
	public Double calculateGrossSal(int empId) {
		Employee ob = null;
		ob = list.get(empId - 1);
		return EmployeeUtil.calculateDAandHRA(ob);
	}

	public void displayEmployee() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public List<Employee> getListData(){
		return list;
		
	}

}
