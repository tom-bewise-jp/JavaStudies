package chapter_7;

public class SubClass extends SuperClass {
	public static String static1 = "static1 (SubClassで再定義、初期化)";
	public String field1 = "field1 (SubClassで定義、初期化)";
	public String field2 = "field2 (SubClassで定義、初期化)";
	
	// @Override
	public static void doStatic1() {
		System.out.println("static1: SubClassで再定義");
		System.out.println("  " + static0);
		System.out.println("  " + static1);
	}
	
	@Override
	public void doMethod1() {
		System.out.println("method1: SubClassでオーバーライド");
		System.out.println("  " + static0);
		System.out.println("  " + static1);
		System.out.println("  field0: " + field0);
		System.out.println("  field1: " + field1);
	}
	
	public void doMethod2() {
		System.out.println("method2: SubClassで定義");
		System.out.println("  " + static0);
		System.out.println("  " + static1);
		System.out.println("  field0: " + field0);
		System.out.println("  field1: " + field1);
		System.out.println("  field2: " + field2);
	}
}
