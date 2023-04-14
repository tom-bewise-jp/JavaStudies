package chapter_7.a;

public class SubA extends A {
	@Override protected void overridedProtectedMethod() {
		System.out.println("Protected Method of a.SubA");
	}
	
	@Override void overridedPackagePublicMethod() {
		System.out.println("Package Public Method of a.SubA");
	}
	
	@Override public void overridedPublicMethod() {
		System.out.println("Public Method of a.SubA");
	}
	
	public void show() {
		System.out.println("スタティックフィードへのアクセス ----");
		System.out.println(staticProtectedField);
		System.out.println(staticPackagePublicField);
		System.out.println(staticPublicField);
		
		System.out.println("スタティックメソッドへのアクセス ----");
		protectedStaticMethod();
		packagePublicStaticMethod();
		publicStaticMethod();
		
		System.out.println("継承したフィールドへのアクセス ----");
		System.out.println(protectedField);
		System.out.println(packagePublicField);
		System.out.println(publicField);
		
		System.out.println("継承したメソッドへのアクセス ----");
		inheritedProtectedMethod();
		inheritedPackagePublicMethod();
		inheritedPublicMethod();
		
		System.out.println("オーバーライドしたメソッドへのアクセス ----");
		overridedProtectedMethod();
		overridedPackagePublicMethod();
		overridedPublicMethod();
		
		System.out.println("スーパークラスオブジェクトへのアクセス ----");
		A a = new A();
		System.out.println("-- スーパークラスオブジェクトのフィールドへのアクセス ----");
		System.out.println(a.protectedField);
		System.out.println(a.packagePublicField);
		System.out.println(a.publicField);
		System.out.println("-- スーパークラスオブジェクトのメソッドへのアクセス ----");
		a.inheritedProtectedMethod();
		a.inheritedPackagePublicMethod();
		a.inheritedPublicMethod();
		a.overridedProtectedMethod();
		a.overridedPackagePublicMethod();
		a.overridedPublicMethod();
		
		System.out.println("自クラスオブジェクトへのアクセス ----");
		SubA subA = new SubA();
		System.out.println("-- スーパークラスオブジェクトのフィールドへのアクセス ----");
		System.out.println(subA.protectedField);
		System.out.println(subA.packagePublicField);
		System.out.println(subA.publicField);
		System.out.println("-- スーパークラスオブジェクトのメソッドへのアクセス ----");
		subA.inheritedProtectedMethod();
		subA.inheritedPackagePublicMethod();
		subA.inheritedPublicMethod();
		subA.overridedProtectedMethod();
		subA.overridedPackagePublicMethod();
		subA.overridedPublicMethod();
		
	}

}
