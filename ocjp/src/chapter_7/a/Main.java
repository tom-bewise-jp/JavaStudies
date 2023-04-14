package chapter_7.a;

public class Main {

	public static void main(String[] args) {
		System.out.println("---- トップクラス A ----");
		A a = new A();
		a.show();
		System.out.println();
		System.out.println("---- サブクラス a.SubA ----");
		chapter_7.a.SubA aSubA = new SubA();
		aSubA.show();
		System.out.println();
		System.out.println("---- サブクラス b.SubA ----");
		chapter_7.b.SubA bSubA = new chapter_7.b.SubA();
		bSubA.show();
		System.out.println();
		System.out.println("---- テストクラス a.B ----");
		B aB = new B();
		aB.show();
		System.out.println();
		System.out.println("---- テストクラス b.B ----");
		chapter_7.b.B bB = new chapter_7.b.B();
		bB.show();
		System.out.println();
		
	}

}
