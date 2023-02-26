
public class Arrays {
	public static void main(String[] args) {
		showMethodsOfArray();
		showMultiDimentionalArray();
	}
	
	public static void showMethodsOfArray() {
		int[] a = {1, 2, 3};
		
		System.out.println("array: " + a);
		
		String[] as0 = {"Hello"};
		String[] as1 = as0.clone();
		System.out.println("as0: \"" + as0[0] + "\"");
		System.out.println("as1: \"" + as1[0] + "\"");
		System.out.println("as0[0].equals(as1[0]): " + as0[0].equals(as1[0]));
		System.out.println("as0.equals(as1): " + (as0.equals(as1)));
	}
	
	public static void showMultiDimentionalArray() {
		int[][] a0;
		a0 = new int[3][];
		a0[0] = new int[3];
		a0[1] = new int[3];
		a0[2] = new int[3];
		
		int[][] a1 = new int[3][3];
		a1[0][0] = 0;
		a1[0][1] = 1;
		a1[0][2] = 2;
		a1[1][0] = 10;
		a1[1][1] = 11;
		a1[1][2] = 12;
		a1[2][0] = 20;
		a1[2][1] = 21;
		a1[2][2] = 22;
		
		int[][] a2 = {{0, 1, 2}, {10, 11, 12}, {20, 21, 22}};
		for (int i = 0; i < a2.length; ++i) {
			System.out.println("a2[" + i + "]: " + a2[i]);
			for (int j = 0; j < a2[i].length; ++j) {
				System.out.print(a2[i][j] + " ");
			}
			System.out.println();
		}
	}
}
