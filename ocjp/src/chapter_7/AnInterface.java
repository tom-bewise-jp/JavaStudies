package chapter_7;

/**
 * インタフェースの例
 */
public interface AnInterface {
	/**
	 * 定数定義の例
	 * インタフェースで定義するスタティックフィールドは定数扱いなので、初期化が必須です
	 * また、定数フィールドのフィールド名には大文字と下線を使用します
	 */
	static int A_STATIC_FIELD = 10;
	static int ANOTHER_STATIC_FIELD = 15;
	/**
	 * staticを明示的に指定しなくてもスタティックフィールド定数となり、メンバ変数を定義することはできません。
	 */
	int AN_INSTANCE_FIELD = 20;
	
	/**
	 * クラスメソッドの例
	 * クラスメソッドはオーバーライドできないので、メソッド本体を必ず記述する必要があります。
	 * @param param 引数の例
	 * @return 戻り値はあってもなくても構いません
	 */
	static int getStaticValue(int param) {
		return A_STATIC_FIELD + param;
	}
	
	/**
	 * メソッドの例
	 * インタフェースで定義するメソッドは基本的にはメソッド本体を記述しません。
	 * この例では戻り値を定義していませんが、戻り値があってももちろん構いません
	 * @param param 引数の例
	 */
	void doSomething(int param);

	/**
	 * デフォルトメソッドの例
	 * インタフェースでメソッド本体付きのメソッドを定義する場合には先頭に"default"と書きます。
	 * デフォルトメソッドで扱えるのは定数となるクラス変数、メンバ変数とメソッドだけなので、できることはかなり限られます。
	 * @param param 引数の例
	 * @return 戻り値を使うこともできます
	 */
	default int doAnotherThing(int param) {
		System.out.println("AnInterface.doAnotherThing()");
		return param + AN_INSTANCE_FIELD;
	}
	
	int doSomethingWithoutDefaultMethod(int param);

	default int doSomethingWithDefaultMethod(int param) {
		System.out.println("doSomethingWithDefaultMethod");
		return 0;
	}
}
