package assinmnets;

import java.util.Scanner;

import assignments.Choice;
import assignments.EmloyeeDBOperations;
import assignments.IEmployeeOperations;
import static assignments.EmployeeUtil.*;


public class EmployeeOperationsApp {

	public static void main(String[] args) throws Exception {

		menusForMain();

	}

	public static void menusForMain() throws Exception {
		IEmployeeOperations impl = new EmloyeeDBOperations();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
         while (true) {
			printMenu();
           int val = sc.nextInt();
			Choice ch = Choice.getDepartmentName(val);
			switch (ch) {
			case ENTER:
				try {
					impl.createEmployee(getDetailsFromUsers());
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				break;
			case FINDID:
				System.out.println("Enter the employee id number");
				int num = sc.nextInt();
				displayEMployee(impl.findEmployee(num));
				break;
			case FINDNAME:
				System.out.println("Enter Employee name");
				String empName = sc.next();
				displayEMployee(impl.findEmployee(empName));
				break;
			case DELETE:
				System.out.println("Enter id which employee you want to delete");
				int num2 = sc.nextInt();
				try {
					impl.deleteEmployee(num2);
					System.out.println("Employee Deleted");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case UPDATE:
				try {
					impl.updateEmployee(getDetailsFromUsers());
					System.out.println("Employee updated");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case GROSS:
				System.out.println("Enter employee id number which you want to know gross salary ");
				int num4 = sc.nextInt();
				System.out.println(impl.calculateGrossSal(num4));
				break;
			case DISPLAYALL:
				((EmloyeeDBOperations) impl).displayEmployee();
				break;
			case SORT:
				printSortMenu();
				int nums=sc.nextInt();
				((EmloyeeDBOperations) impl).sortBy(nums);
				break;
			case UNIQUENAME:
				((EmloyeeDBOperations) impl).uniqueName();
				break;
			case AGERANGE:
				((EmloyeeDBOperations) impl).sortByAgeRange();
				break;
			case EXIT:
				System.out.println("Good bye");
				return;
			default:
				System.out.println("invalid entry");
				break;

			}
		}
	}
}