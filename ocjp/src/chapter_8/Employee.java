package chapter_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Employee implements Comparable<Employee> {
	private final String name;
	
	@Override
	public int compareTo(Employee o) {
		return name.compareTo(o.name);
	}

	public Employee(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("たなか"));
		employeeList.add(new Employee("あんどう"));
		employeeList.add(new Employee("さとう"));
		
		for (Employee e: employeeList) {
			System.out.println(e.name);
		}
		System.out.println();
		
		Collections.sort(employeeList);
		for (Employee e: employeeList) {
			System.out.println(e.name);
		}
		System.out.println();

		Employee[] employeeArray = new Employee[3];
		employeeArray[0] = new Employee("たなか");
		employeeArray[1] = new Employee("あんどう");
		employeeArray[2] = new Employee("さとう");

		for (Employee e: employeeArray) {
			System.out.println(e.name);
		}
		System.out.println();
		
		Arrays.sort(employeeArray);
		for (Employee e: employeeArray) {
			System.out.println(e.name);
		}
		System.out.println();

	}
}
