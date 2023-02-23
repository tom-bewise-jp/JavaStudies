
public class Expressions {
	public static void main(String[] args) {
		// 残念ながらこのプログラム例はエラーになります。
		// while ((int x = foo()) > 0) {
		// 	System.out.println(x);
		// }
		assignmentExpressions();
	}
	
	public static int foo() {
		return 0;
	}
	
	public static void assignmentExpressions() {
		System.out.println("int x = 2;");
		int x = 2;
		System.out.println("x + (x += 3): " + (x + (x += 3)));
		x = 2;
		System.out.println("(x += 3) + x: " + ((x += 3) + x));
		System.out.println("x = x + (x += 3) + x;");
		x = 2;
		x = x + (x += 3) + x;
		System.out.println("x = " + x);
	}
	
	public static void conditionalExpression() {
		int[] array = bar();
		if (array != null && array.length >= 5) {
			// 配列のサイズが5以上の場合の処理
		}
	}
	
	private static int[] bar() {
		return null;
	}
	
}
