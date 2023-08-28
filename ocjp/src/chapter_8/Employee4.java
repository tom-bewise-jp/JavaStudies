package chapter_8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee4 {
	private String name;
	private LocalDate joined;

	public static final Comparator<Employee4> NAME_COMPARATOR = new Comparator<>() {
		@Override
		public int compare(Employee4 o1, Employee4 o2) {
			return o1.name.compareTo(o2.name);
		}
	};

	public static final Comparator<Employee4> JOINED_COMPARATOR = new Comparator<>() {
		@Override
		public int compare(Employee4 o1, Employee4 o2) {
			return o1.joined.compareTo(o2.joined);
		}
	};

	public Employee4(String name, LocalDate joined) {
		this.name = name;
		this.joined = joined;
	}

	public static void main(String[] args) {
		List<Employee4> employeeList = new ArrayList<>();
		employeeList.add(new Employee4("さとう", LocalDate.of(2003, 3, 3)));
		employeeList.add(new Employee4("あんどう", LocalDate.of(2002, 2, 2)));
		employeeList.add(new Employee4("たなか", LocalDate.of(2001, 1, 1)));

		for (Employee4 o : employeeList) {
			System.out.println(o.name + " " + o.joined);
		}
		System.out.println();

		employeeList.sort(Employee4.NAME_COMPARATOR);
		for (Employee4 o : employeeList) {
			System.out.println(o.name + " " + o.joined);
		}
		System.out.println();

		employeeList.sort(Employee4.JOINED_COMPARATOR);
		for (Employee4 o : employeeList) {
			System.out.println(o.name + " " + o.joined);
		}
		System.out.println();

	}
}
