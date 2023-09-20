package chapter_8;

import java.util.ArrayList;
import java.util.List;

public class Employee6 {
	private String name;
//	public TextGetter NAME_GETTER = new TextGetter() {
//		@Override
//		public String getText() {
//			return name;
//		}
//	};
	public TextGetter NAME_GETTER = () -> name;

	@FunctionalInterface
	public interface TextGetter {
		public String getText();
	}

	public Employee6(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TextGetter getNameGetter() {
		String text = "名前:" + name;
//		String text = "名前:";
//		text += name;
//		String text;
//		text = "名前:" + name;
//		return new TextGetter() {
//			public String getText() {
//				return text;
//			}
//		};
		return () -> text;
	}

	public static void main(String[] args) {
		List<Employee6> employeeList = new ArrayList<>();
		employeeList.add(new Employee6("さとう"));
		employeeList.add(new Employee6("あんどう"));
		employeeList.add(new Employee6("たなか"));

		Employee6.TextGetter nameGetter = null;
		for (Employee6 o : employeeList) {
			nameGetter = o.NAME_GETTER;
//			nameGetter = o.getNameGetter();
			System.out.println(nameGetter.getText());
			o.setName("誰か");
			System.out.println(nameGetter.getText());
			o.setName("あああ");
		}
		System.out.println();

		employeeList.clear();
		System.out.println(nameGetter.getText());
	}
}
