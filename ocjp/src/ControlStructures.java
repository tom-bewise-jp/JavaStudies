
public class ControlStructures {
	public class Signal {
		public static final String RED = "Red";
		public static final String YELLOW = "Yellow";
		public static final String GREEN = "Green";
	}
	public static void main(String[] args) {
		checkSignal("Blue");
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
}
