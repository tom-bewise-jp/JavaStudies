package chapter_7.b;

import chapter_7.a.SubA;

public class B {
	public void show() {
		System.out.println("同一パッケージ内のオブジェクトへのアクセス ----");
		System.out.println("スタティックフィードへのアクセス ----");
		System.out.println(SubA.staticPublicField);
		System.out.println("スタティックメソッドへのアクセス ----");
		SubA.publicStaticMethod();
		SubA subA = new SubA();
		System.out.println("-- フィールドへのアクセス ----");
		System.out.println(subA.publicField);
		System.out.println("-- メソッドへのアクセス ----");
		subA.inheritedPublicMethod();
		subA.overridedPublicMethod();
		
		System.out.println("別パッケージのオブジェクトへのアクセス ----");
		System.out.println("スタティックフィードへのアクセス ----");
		System.out.println(chapter_7.a.SubA.staticPublicField);
		System.out.println("スタティックメソッドへのアクセス ----");
		chapter_7.a.SubA.publicStaticMethod();
		chapter_7.a.SubA aSubA = new chapter_7.a.SubA();
		System.out.println("-- フィールドへのアクセス ----");
		System.out.println(aSubA.publicField);
		System.out.println("-- メソッドへのアクセス ----");
		aSubA.inheritedPublicMethod();
		aSubA.overridedPublicMethod();
		
	}
}
