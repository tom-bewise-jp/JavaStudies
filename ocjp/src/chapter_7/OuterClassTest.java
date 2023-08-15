package chapter_7;

public class OuterClassTest {
	public static String staticString1 = "OuterClassで定義されたstaticString1";
	public static String staticString2 = "OuterClassで定義されたstaticString2";
	public String instanceString1 = "OuterClassで定義されたinstanceString1";
	public String instanceString2 = "OuterClassで定義されたinstanceString2";
	
	public static String staticMethod1() {
		return "OuterClassで定義されたstaticMethod1: " + staticString1;
	}
	
	public static String staticMethod2() {
		return "OuterClassで定義されたstaticMethod2: " + staticString2;
	}
	
	public String instanceMethod1() {
		return "OuterClassで定義されたinstanceMethod1: " + instanceString1;
	}
	
	public String instanceMethod2() {
		return "OuterClassで定義されたinstanceMethod2: " + instanceString2;
	}
	
	public static class StaticInnerClass {
		public static String staticString2 = "StaticInnerClassで定義されたstaticString2";
		public String instanceString2 = "StaticInnerClassで定義されたinstanceString2";
		
		public static String staticMethod2() {
			return "StaticInnerClassで定義されたstaticMethod2: " + staticString2;
		}
		
		public static String staticMethod3() {
			return "StaticInnerClassで定義されたstaticMethod2: " + staticString1;
		}
		
		public String instanceMethod2() {
			return "StaticInnerClassで定義されたinstanceMethod2: " + instanceString2;
		}

//		public String instanceMethod3() {
//			return "StaticInnerClassで定義されたinstanceMethod2: " + instanceString1;
//		}
	}
	
	public class InstanceInnerClass {
		public static String staticString2 = "StaticInnerClassで定義されたstaticString2";
		public String instanceString2 = "StaticInnerClassで定義されたinstanceString2";
		
		public static String staticMethod2() {
			return "StaticInnerClassで定義されたstaticMethod2: " + staticString2;
		}
		
		public static String staticMethod3() {
			return "StaticInnerClassで定義されたstaticMethod2: " + staticString1;
		}
		
		public String instanceMethod2() {
			return "StaticInnerClassで定義されたinstanceMethod2: " + instanceString2;
		}

		public String instanceMethod3() {
			return "StaticInnerClassで定義されたinstanceMethod2: " + instanceString1;
		}
	}
}
