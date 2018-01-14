package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericEmployeeServiceImpl<C, T> implements GenericEmployeeService<C, T> {

	List<C> list = new ArrayList<>();

	@Override
	public void createEmployee(C e) {
		list.add(e);
	}

	@Override
	public boolean deleteEmployee(int id) {
		list.remove(id - 1);
		return true;
	}

	@Override
	public void selectEmployee() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
