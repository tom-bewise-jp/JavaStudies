package chapter_8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee2 {
	private String name;
	private LocalDate joined;
	
	public Employee2(String name, LocalDate joined) {
		this.name = name;
		this.joined = joined;
	}
	
	public String getName() {
		return name;
	}
	
	public LocalDate getJoined() {
		return joined;
	}
	
	public static void main(String[] args) {
		List<Employee2> employeeList = new ArrayList<>();
		employeeList.add(new Employee2("さとう", LocalDate.of(2003, 3, 3)));
		employeeList.add(new Employee2("あんどう", LocalDate.of(2002, 2, 2)));
		employeeList.add(new Employee2("たなか", LocalDate.of(2001, 1, 1)));
		
		for (Employee2 o: employeeList) {
			System.out.println(o.getName() + " " + o.getJoined());
		}
		System.out.println();
		
		employeeList.sort(new Employee2NameComparator());
		for (Employee2 o: employeeList) {
			System.out.println(o.getName() + " " + o.getJoined());
		}
		System.out.println();
		
		employeeList.sort(new Employee2JoinedComparator());
		for (Employee2 o: employeeList) {
			System.out.println(o.getName() + " " + o.getJoined());
		}
		System.out.println();
	}
}
