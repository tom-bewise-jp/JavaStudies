package chapter_8;

import java.util.List;

public class EmployeeList implements Iterable<Employee> {
	private List<Employee> employeeList;
	private int iterationIndex = 0;
	
	public void resetIteration() {
		iterationIndex = 0;
	}
	public Employee getNextIteration() {
		if (iterationIndex < employeeList.size()) {
			return employeeList.get(iterationIndex);
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
}
