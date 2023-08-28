package chapter_8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee3 {
    private String name;
    private LocalDate joined;

    private static class NameComparator implements Comparator<Employee3> {
        @Override
        public int compare(Employee3 o1, Employee3 o2) {
            return o1.name.  compareTo(o2.name);
        }  
    }

    private static class JoinedComparator implements Comparator<Employee3> {
        @Override
        public int compare(Employee3 o1, Employee3 o2) {
            return o1.joined.compareTo(o2.joined);
        }
    }

    public static final Comparator<Employee3> NAME_COMPARATOR = new NameComparator();
    public static final Comparator<Employee3> JOINED_COMPARATOR = new JoinedComparator();

     public Employee3(String name, LocalDate joined) {
    	this.name = name;
    	this.joined = joined;
    }
    
    public static void main(String[] args) {
    	List<Employee3> employeeList = new ArrayList<>();
		employeeList.add(new Employee3("さとう", LocalDate.of(2003, 3, 3)));
		employeeList.add(new Employee3("あんどう", LocalDate.of(2002, 2, 2)));
		employeeList.add(new Employee3("たなか", LocalDate.of(2001, 1, 1)));

		for (Employee3 o: employeeList) {
			System.out.println(o.name + " " + o.joined);
		}
		System.out.println();
		
		employeeList.sort(Employee3.NAME_COMPARATOR);
		for (Employee3 o: employeeList) {
			System.out.println(o.name + " " + o.joined);
		}
		System.out.println();
		
		employeeList.sort(Employee3.JOINED_COMPARATOR);
		for (Employee3 o: employeeList) {
			System.out.println(o.name + " " + o.joined);
		}
		System.out.println();

    }
}
