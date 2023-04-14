package chapter_7;

public class Main {
	public static void main(String[] args) {
		AnInterface anInterface = new AClass();
		ExtendedInterface extendedInterface = new AClass();
		AClass aClass = new AClass();
		System.out.println("AnIterface.A_STATIC_FIELD" + AnInterface.A_STATIC_FIELD);
		System.out.println("anInterface.A_STATIC_FIELD" + anInterface.A_STATIC_FIELD);
		System.out.println("AnInterface.AN_INSTANCE_FIELD" + AnInterface.AN_INSTANCE_FIELD);
		System.out.println("anInterface.AN_INSTANCE_FIELD" + anInterface.AN_INSTANCE_FIELD);

		System.out.println("AnInterface.A_STATIC_FIELD: " + AnInterface.A_STATIC_FIELD);
		System.out.println("ExtendedInterface.A_STATIC_FIELD: " + ExtendedInterface.A_STATIC_FIELD);
		System.out.println("AClass.A_STATIC_FIELD: " + AClass.A_STATIC_FIELD);
		anInterface.doSomething(0);
		extendedInterface.doSomething(0.0);
		anInterface.doAnotherThing(0);			// AnInterface.doAnotherThingは呼べません
		extendedInterface.doAnotherThing(0);
		
		System.out.println("--------");
		SuperClass a = new SuperClass();
		SubClass b = new SubClass();
		SuperClass c = new SubClass();
		System.out.println("-- SuperClass --");
		System.out.println(SuperClass.static0);
		System.out.println(SuperClass.static1);
		System.out.println("field0: " + a.field0);
		System.out.println("field1: " + a.field1);
		SuperClass.doStatic0();
		SuperClass.doStatic1();
		a.doMethod0();
		a.doMethod1();
		System.out.println("-- SubClass --");
		System.out.println(SubClass.static0);
		System.out.println(SubClass.static1);
		System.out.println("field0: " + b.field0);
		System.out.println("field1: " + b.field1);
		SubClass.doStatic0();
		SubClass.doStatic1();
		b.doMethod0();
		b.doMethod1();
		b.doMethod2();
		System.out.println("-- SubClass as SuperClass --");
		System.out.println(c.static0);
		System.out.println(c.static1);
		System.out.println("field0: " + c.field0);
		System.out.println("field1: " + c.field1);
		c.doStatic0();
		c.doStatic1();
		c.doMethod0();
		c.doMethod1();
		
	}
}
