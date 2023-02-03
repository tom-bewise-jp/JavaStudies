
public class Strings {
	public static void main(String[] args) {
		StringEquality1();
		StringEquality2();
		StringConversion();
		StringImmutability();
		StringBuilderSample();
	}
	
	public static void StringEquality1() {
		String s0 = "ABCD";
		String s1 = String.valueOf(new char[] {'A', 'B', 'C', 'D'});
		System.out.println("-----------------");
		System.out.println("String equality: ");
		System.out.println("-----------------");
		System.out.println("s0 (literal): \"" + s0 + "\"");
		System.out.println("s1 (created object): \"" + s1 + "\"");
		System.out.println("s0 == s1: " + (s0 == s1));
		System.out.println("s0.equals(s1): " + s0.equals(s1));
		System.out.println("s0.intern() == s1.intern(): " + (s0.intern() == s1.intern()));
		System.out.println();
		
	}
	
	public static void StringEquality2() {
		String s0 = "ABCD";
		String s1 = "ABCD";
		String s2 = "AB" + "CD";
		
		System.out.println("-------------------------");
		System.out.println("String literal equality: ");
		System.out.println("-------------------------");
		System.out.println("s0 (literal) == s1 (literal): " + (s0 == s1));
		System.out.println("s0 (literal) == s2 (string constant expression): " + (s0 == s2));
		System.out.println("s0 (literal) == hello.Strings2.S0 (literal of other class) : " + (s0 == hello.Strings2.S0));
		System.out.println();
		
	}
	
	public static void StringConversion() {
		char c = 65;

		System.out.println("-------------------");
		System.out.println("String conversion: ");
		System.out.println("-------------------");
		System.out.println("1 + 1: " + 1 + 1);
		System.out.println("(1 + 1): " + (1 + 1));
		System.out.println("char 65 + \"B\": " + c + "B");
		System.out.println();
		
	}
	
	public static void StringImmutability() {
		char[] chars = new char[] {'A', 'B', 'C', 'D', 'E'};
		String s = "";
		for (char c: chars) {
			s += c;
		}
		System.out.println("---------------------------");
		System.out.println("String immutability sample.");
		System.out.println("---------------------------");
		System.out.println(s);
		System.out.println();
		
	}
	
	public static void StringBuilderSample() {
		char[] chars = new char[] {'A', 'B', 'C', 'D', 'E'};
		System.out.println("----------------------");
		System.out.println("StringBuilder samples.");
		System.out.println("----------------------");
		System.out.println("append:");
		StringBuilder sb = new StringBuilder();
		for (char c: chars) {
			sb.append(c);
		}
		System.out.println(sb);
		System.out.println();
		
		
		System.out.println("insert top:");
		sb = new StringBuilder();
		for (char c: chars) {
			sb.insert(0, c);
		}
		System.out.println(sb);
		System.out.println();
		
		System.out.println("insert bottom:");
		sb = new StringBuilder();
		for (char c: chars) {
			sb.insert(sb.length(), c);
		}
		System.out.println(sb);
		System.out.println();
		
		
		System.out.println("delete:");
		sb = new StringBuilder("ABCDE");
		sb.deleteCharAt(2);
		System.out.println(sb);
		sb.delete(0, 2);
		System.out.println(sb);
		sb.delete(0, sb.length());
		System.out.println(sb.length());
		System.out.println();
		
		
		System.out.println("toString():");
		sb = new StringBuilder();
		sb.append(new char[] {'A', 'B', 'C', 'D', 'E'});
		System.out.println("sb.toString(): " + sb.toString());
		System.out.println("sb: " + sb);
		System.out.println();
		
	}
}
