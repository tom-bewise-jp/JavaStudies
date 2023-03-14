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
	}
}
