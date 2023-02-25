import java.io.IOException;

public class ControlStructures {
	public class Signal {
		public static final String RED = "Red";
		public static final String YELLOW = "Yellow";
		public static final String GREEN = "Green";
	}
	public static void main(String[] args) {
		checkSignal("Blue");
		whileLoopExample();
		forLoopExample();
		getPrimes();
	}
	
	public static void checkSignal(String signal) {
		switch (signal) {
		case Signal.RED:
			// 停止する
			break;
		case Signal.YELLOW:
			// 安全に停止できるか判断する
			break;
		case Signal.GREEN:
			// 安全を確認の上進む
			break;
		default:
			// 何らかの障害が発生しているので停止する
		}
	}
	
	public static void whileLoopExample() {
		int i = 1;
		int sum = 0;
		while (i <= 10) {
			sum += i;
			++i;
		}
		System.out.println("sum: " + sum);
		
		i = 1;
		sum = 0;
		while (i <= 10)
			sum += i++;
		System.out.println("sum: " + sum);
	}
	
	public static void forLoopExample() {
		int sum = 0;
		for (int i = 1; i <= 10; ++i) {
			sum += i;
		}
		System.out.println("sum: " + sum);

		sum = 0;
		for (int i = 1, j = 1; i <= 10; ++i, ++j) {
			sum += i + j;
		}
		System.out.println("sum: " + sum);
		
		sum = 0;
		for (int i = 1; i <= 10; sum += i, ++i) ;
		System.out.println("sum: " + sum);
		
		sum = 0;
		for (int i = 1; i <= 10 && (sum += i) > 0; ++i) ;
		System.out.println("sum: " + sum);
	}
	
	public static void getPrimes() {
		boolean[] table = new boolean[101];
		for (int i = 2; i < 100; ++i) {
			table[i] = true;
		}
		for (int i = 2; i < 100; ++i) {
			if (!table[i])
				continue;
			for (int j = i + i; j < 100; j += i) {
				table[j] = false;
			}
		}
		System.out.println("primes:");
		System.out.print("2");
		for (int i = 3; i < 100; ++i) {
			if (table[i])
				System.out.print(", " + i);
		}
		System.out.println();
	}
}
