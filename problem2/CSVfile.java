package problem2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class CSVfile {

	public List<Employee> readEmployees(File inFile) throws Exception {

		List<Employee> list = new ArrayList<Employee>();
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(inFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		@SuppressWarnings("resource")
		Scanner s = new Scanner(fileReader);

		while (s.hasNextLine()) {
			String i = s.nextLine();
			String arr[] = i.split(",");
			Employee emp = new Employee();
			if (arr[0].equals("")) {
				break;
			} else {
				emp.setId(Integer.parseInt(arr[0]));
				emp.setNumber(Integer.parseInt(arr[1]));
				emp.setName(arr[2]);
				emp.setSalary(Float.parseFloat(arr[3]));
				emp.setDoj(EmployeeUtil.getDate(2017));
				emp.setAge(Integer.parseInt(arr[5]));
				list.add(emp);
			}

		}
		return list;
	}

	public void writeEmployee(List<Employee> emp) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("C:/file.csv"));
		Calendar calendar1 = Calendar.getInstance();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < emp.size(); i++) {
			calendar1.setTime(emp.get(i).getDoj());
			int year = calendar1.get(Calendar.YEAR);
			sb.append(emp.get(i).getId());
			sb.append(",");
			sb.append(emp.get(i).getNumber());
			sb.append(",");
			sb.append(emp.get(i).getName());
			sb.append(",");
			sb.append(emp.get(i).getSalary());
			sb.append(",");
			sb.append(year);
			sb.append(",");
			sb.append(emp.get(i).getAge());
			sb.append("\n");

		}
		pw.write(sb.toString());
		pw.close();
	}

	public void numberOfWords(String[] lines, StringBuilder str) throws FileNotFoundException {
		@SuppressWarnings("unused")
		int totalWords = 0;
		String[] words = null;
		int wordCount = 0;
		for (int i = 0; i < lines.length; i++) {
			words = lines[i].split(",");
			wordCount = wordCount + words.length;
		}
		System.out.println("* Total Words: " + wordCount);

	}

	public void numberOfLine(File inFile) throws FileNotFoundException {
		@SuppressWarnings("unused")
		int totalLine = 0;
		String Line;
		StringBuilder str = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(inFile))) {
			while ((Line = br.readLine()) != null) {
				totalLine++;
				str.append(Line);
				str.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] lines = str.toString().split("\n");
		System.out.println("* Toal Lines: " + lines.length);
		numberOfWords(lines, str);
	}

	public void findNumbers(File inFile) {
		@SuppressWarnings("unused")
		int totalLine = 0;
		String Line;
		String str = new String();
		try (BufferedReader br = new BufferedReader(new FileReader(inFile))) {
			while ((Line = br.readLine()) != null) {
				totalLine++;
				str = str + Line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		str = str.toString().replaceAll("[^-?0-9]+", " ");
		System.out.println("* Total numbers : " + (str.trim().split(" ").length - 1));
	}
}
