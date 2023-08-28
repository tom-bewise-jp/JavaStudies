package chapter_8;

public class AnonymousClass {
	public static void main(String[] args) {
		Object o = new Object() {
			@Override
			public String toString()  {
				return "Anonymous";
			}
		};
		var v = new Object() {
			public void sayHello() {
				System.out.println("Hello!");
			}
		};
		System.out.println(o);
		v.sayHello();
	}
}
