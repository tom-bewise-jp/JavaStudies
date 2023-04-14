package chapter_7;

public class SuperClass {
	public static String static0 = "static0 (SuperClassで定義、初期化)";
	public static String static1 = "static1 (SuperClassで定義、初期化)";
	
	public String field0 = "field0 (SuperClassで定義、初期化)";
	public String field1 = "field1 (SuperClassで定義、初期化)";
	
	public static void doStatic0() {
		System.out.println("static0: SuperClassで定義");
		System.out.println("  " + static0);
		System.out.println("  " + static1);
	}
	
	public static void doStatic1() {
		System.out.println("static1: SuperClassで定義");
		System.out.println("  " + static0);
		System.out.println("  " + static1);
	}
	
	public void doMethod0() {
		System.out.println("method0: SuperClassで定義");
		System.out.println("  " + static0);
		System.out.println("  " + static1);
		System.out.println("  field0: " + field0);
		System.out.println("  field1: " + field1);
	}
	
	public void doMethod1() {
		System.out.println("method1: SuperClassで定義");
		System.out.println("  " + static0);
		System.out.println("  " + static1);
		System.out.println("  field0: " + field0);
		System.out.println("  field1: " + field1);
	}
}
