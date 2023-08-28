package chapter_8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeList5 implements java.lang.Iterable<Employee> {
	private List<Employee> employeeList = new ArrayList<>();
	
	public Iterator<Employee> iterator() {
		return new Iterator<Employee>() {
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < employeeList.size();
			}

			@Override
			public Employee next() {
				return employeeList.get(index++);
			}
		};
	}
	
	public void add(Employee employee) {
		employeeList.add(employee);
	}
	
	public static void main(String[] args) {
		EmployeeList5 employeeList = new EmployeeList5();
		employeeList.add(new Employee("あんどう"));
		employeeList.add(new Employee("さとう"));
		employeeList.add(new Employee("たなか"));
		
		for (Employee o: employeeList) {
			System.out.println(o.getName());
		}
	}
}
