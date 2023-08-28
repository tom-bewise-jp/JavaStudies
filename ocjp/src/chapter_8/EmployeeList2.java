package chapter_8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeList2 implements java.lang.Iterable<Employee> {
	private List<Employee> employeeList = new ArrayList<>();
	
	private static class EmployeeIterator implements Iterator<Employee>{
		private EmployeeList2 employeeList;
		private int index = 0;

		public EmployeeIterator(EmployeeList2 employeeList) {
			this.employeeList = employeeList;
		}
		
		@Override
		public boolean hasNext() {
			return index < employeeList.employeeList.size();
		}

		@Override
		public Employee next() {
			return employeeList.employeeList.get(index++);
		}
	}
	
	public Iterator<Employee> iterator() {
		return new EmployeeIterator(this);
	}
	
	public void add(Employee employee) {
		employeeList.add(employee);
	}
	
	public static void main(String[] args) {
		EmployeeList2 employeeList = new EmployeeList2();
		employeeList.add(new Employee("あんどう"));
		employeeList.add(new Employee("さとう"));
		employeeList.add(new Employee("たなか"));
		
		for (Employee o: employeeList) {
			System.out.println(o.getName());
		}
	}
}
