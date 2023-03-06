
public class StaticAndInstance {
	static final int a = 1;
	final int b;
	
	static void sayHello(String s) {
		System.out.println("Hello, " + s);
	};
	
	void sayHello(int n) {
		for (int i = 0; i < n; ++i) {
			System.out.println("Hello, World!");
		}
	}

	StaticAndInstance(int i) {
		b = i;
	}
}
