package chapter_7.a;

public class B {
	public void show() {
		System.out.println("同一パッケージ内のオブジェクトへのアクセス ----");
		System.out.println("スタティックフィードへのアクセス ----");
		System.out.println(SubA.staticProtectedField);
		System.out.println(SubA.staticPackagePublicField);
		System.out.println(SubA.staticPublicField);
		System.out.println("スタティックメソッドへのアクセス ----");
		SubA.protectedStaticMethod();
		SubA.packagePublicStaticMethod();
		SubA.publicStaticMethod();
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
		System.out.println("スタティックフィードへのアクセス ----");
		System.out.println(chapter_7.b.SubA.staticProtectedField);
		System.out.println(chapter_7.b.SubA.staticPublicField);
		System.out.println("スタティックメソッドへのアクセス ----");
		chapter_7.b.SubA.protectedStaticMethod();
		chapter_7.b.SubA.publicStaticMethod();
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
