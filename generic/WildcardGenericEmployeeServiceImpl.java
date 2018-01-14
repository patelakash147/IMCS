package generic;

import java.util.ArrayList;
import java.util.List;

import problem2.Employee;
import problem2.EmployeeNotFoundException;

public class WildcardGenericEmployeeServiceImpl<E extends Employee> {

	List<E> list = new ArrayList<>();

	public void createEmployee(E e) {
		list.add(e);

	}

	public void selectEmployee() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	public boolean deleteEmployee(int id) {
		list.remove(id - 1);
		return true;
	}

	public boolean updateEmployee(E e) {

		for (int i = 0; i < list.size(); i++) {
			if (e.getNumber() == list.get(i).getNumber()) {
				list.get(i).setNumber(e.getNumber());
				list.get(i).setName(e.getName());
				list.get(i).setSalary(e.getSalary());
				list.get(i).setDoj(e.getDoj());
				list.get(i).setAge(e.getAge());
			}
		}
		return true;
	}
}
