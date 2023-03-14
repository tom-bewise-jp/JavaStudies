package chapter_7;

/**
 * 拡張したインタフェースの例
 * インタフェースを拡張することで元のインタフェースにメソッドなどを追加することができます。
 */
public interface ExtendedInterface extends AnInterface {
	/**
	 * 定数を定義します。
	 * 同じ名前の場合、拡張元のクラス変数を上書きします
	 * このインタフェースを実装したクラスからはスーパーインタフェースではなくこちらの定数が見えます
	 */
	static double A_STATIC_FIELD = 15.2;
	
	/**
	 * クラスメソッドを定義します。
	 * 同じ名前の場合、拡張元の暮らすメソッドを上書きします。
	 * @param param
	 * @return
	 */
	static double getStaticValue(int param) {
		return A_STATIC_FIELD * param;
	}
	
	/**
	 * メソッドを定義します。
	 * オーバーロードはもちろんできます。
	 * @param param 引数の例
	 */
	int doSomething(double param);

	/**
	 * オーバーライドする場合は拡張元と戻り値型が同じでなければいけません。
	 * デフォルトメソッドは自分で定義したインスタンス変数、クラス変数を優先して参照します。
	 */
	default int doAnotherThing(int param) {
		System.out.println("ExtendedInterface.doAnotherThing()");
		return (int)(param + A_STATIC_FIELD + ANOTHER_STATIC_FIELD);
	}
	
	default int doSomethingWithoutDefaultMethod(int param) {
		System.out.println("doSomethingWithDefaultMethod");
		return 0;
	}

	int doSomethingWithDefaultMethod(int param);

}
