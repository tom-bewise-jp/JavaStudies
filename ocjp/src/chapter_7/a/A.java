package chapter_7.a;

public class A {
	protected static String staticProtectedField = "Static Protected Field";
	static String staticPackagePublicField = "Static Package Public Field";
	public static String staticPublicField = "Static Public Field";
	
	protected static void protectedStaticMethod() {
		System.out.println("Static Protected Method of a.A");
	}
	
	static void packagePublicStaticMethod() {
		System.out.println("Static Package Public Method of a.A");
	}
	
	public static void publicStaticMethod() {
		System.out.println("Statuc Public Method of a.A");
	}
	
	private String privateField = "Private Field";
	protected String protectedField = "Protected Field";
	String packagePublicField = "Package Public Field";
	public String publicField = "Public Field";

	protected void inheritedProtectedMethod() {
		System.out.println("Protected Method of a.A");
	}
	
	protected void overridedProtectedMethod() {
		System.out.println("Protected Method of a.A");
	}
	
	void inheritedPackagePublicMethod() {
		System.out.println("Package Public Method of a.A");
	}
	
	void overridedPackagePublicMethod() {
		System.out.println("Package Public Method of a.A");
	}
	
	public void inheritedPublicMethod() {
		System.out.println("Public Method of a.A");
	}
	
	public void overridedPublicMethod() {
		System.out.println("Public Method of a.A");
	}
	
	public void show() {
		System.out.println("同一パッケージ内のオブジェクトへのアクセス ----");
		SubA subA = new SubA();
		System.out.println("-- フィールドへのアクセス ----");
		System.out.println(subA.protectedField);
		System.out.println(subA.packagePublicField);
		System.out.println(subA.publicField);
		System.out.println("-- メソッドへのアクセス ----");
		subA.inheritedProtectedMethod();
		subA.inheritedPackagePublicMethod();
		subA.inheritedPublicMethod();
		subA.overridedProtectedMethod();
		subA.overridedPackagePublicMethod();
		subA.overridedPublicMethod();
		
		System.out.println("別パッケージのオブジェクトへのアクセス ----");
		chapter_7.b.SubA bSubA = new chapter_7.b.SubA();
		System.out.println("-- フィールドへのアクセス ----");
		System.out.println(bSubA.protectedField);
		System.out.println(bSubA.publicField);
		System.out.println("-- メソッドへのアクセス ----");
		bSubA.inheritedProtectedMethod();
		bSubA.inheritedPublicMethod();
		bSubA.overridedPublicMethod();
		
	}
}
