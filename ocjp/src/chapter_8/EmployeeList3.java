package chapter_8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeList3 implements java.lang.Iterable<Employee> {
	private List<Employee> employeeList = new ArrayList<>();
	
	public Iterator<Employee> iterator() {
		return new Iterator<Employee>() {
			private EmployeeList3 list = EmployeeList3.this;
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < list.employeeList.size();
			}

			@Override
			public Employee next() {
				if (index < 0 || list.employeeList.size() <= index) {
					throw new NoSuchElementException();
				}
				return list.employeeList.get(index++);
			}
		};
	}
	
	public void add(Employee employee) {
		employeeList.add(employee);
	}
	
	public static void main(String[] args) {
		EmployeeList3 employeeList = new EmployeeList3();
		employeeList.add(new Employee("あんどう"));
		employeeList.add(new Employee("さとう"));
		employeeList.add(new Employee("たなか"));
		
		for (Employee o: employeeList) {
			System.out.println(o.getName());
		}
	}
}
