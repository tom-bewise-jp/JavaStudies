package chapter_7.b;

import chapter_7.a.A;

public class SubA extends A {
	@Override protected void overridedProtectedMethod() {
		System.out.println("Protected Method of b.SubA");
	}
	
	@Override public void overridedPublicMethod() {
		System.out.println("Public Method of b.SubA");
	}
	
	public void show() {
		System.out.println("スタティックフィードへのアクセス ----");
		System.out.println(staticProtectedField);
		System.out.println(staticPublicField);
		
		System.out.println("スタティックメソッドへのアクセス ----");
		protectedStaticMethod();
		publicStaticMethod();
		
		System.out.println("継承したフィールドへのアクセス ----");
		System.out.println(protectedField);
		System.out.println(publicField);
		
		System.out.println("継承したメソッドへのアクセス ----");
		inheritedProtectedMethod();
		inheritedPublicMethod();
		
		System.out.println("オーバーライドしたメソッドへのアクセス ----");
		overridedProtectedMethod();
		overridedPublicMethod();
		
		System.out.println("スーパークラスオブジェクトへのアクセス ----");
		A a = new A();
		System.out.println("-- スーパークラスオブジェクトのフィールドへのアクセス ----");
		System.out.println(a.publicField);
		System.out.println("-- スーパークラスオブジェクトのメソッドへのアクセス ----");
		a.inheritedPublicMethod();
		a.overridedPublicMethod();
		
		System.out.println("自クラスオブジェクトへのアクセス ----");
		SubA subA = new SubA();
		System.out.println("-- スーパークラスオブジェクトのフィールドへのアクセス ----");
		System.out.println(subA.protectedField);
		System.out.println(subA.publicField);
		System.out.println("-- スーパークラスオブジェクトのメソッドへのアクセス ----");
		subA.inheritedProtectedMethod();
		subA.inheritedPublicMethod();
		subA.overridedProtectedMethod();
		subA.overridedPublicMethod();
		
	}

}
