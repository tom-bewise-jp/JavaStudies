package chapter_8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee5 {
	private String name;
	private LocalDate joined;

	public static final Comparator<Employee5> NAME_COMPARATOR
		= (o1, o2) -> (o1.name.compareTo(o2.name));

	public static final Comparator<Employee5> JOINED_COMPARATOR
		= (o1, o2) -> {
			LocalDate l1 = o1.joined; 
			LocalDate l2 = o2.joined; 
			return l1.compareTo(l2);	
		};

	public Employee5(String name, LocalDate joined) {
		this.name = name;
		this.joined = joined;
	}

	public static void main(String[] args) {
		List<Employee5> employeeList = new ArrayList<>();
		employeeList.add(new Employee5("さとう", LocalDate.of(2003, 3, 3)));
		employeeList.add(new Employee5("あんどう", LocalDate.of(2002, 2, 2)));
		employeeList.add(new Employee5("たなか", LocalDate.of(2001, 1, 1)));

		for (Employee5 o : employeeList) {
			System.out.println(o.name + " " + o.joined);
		}
		System.out.println();

		employeeList.sort(Employee5.NAME_COMPARATOR);
		for (Employee5 o : employeeList) {
			System.out.println(o.name + " " + o.joined);
		}
		System.out.println();

		employeeList.sort(Employee5.JOINED_COMPARATOR);
		for (Employee5 o : employeeList) {
			System.out.println(o.name + " " + o.joined);
		}
		System.out.println();

	}
}
