package chapter_7;

public class AClass implements ExtendedInterface {

	/**
	 * AnInterfaceで定義したメソッドを実装します
	 */
	@Override
	public void doSomething(int param) {
		// TODO Auto-generated method stub

	}

	/**
	 * AnotherInterfaceで定義したメソッドを実装します。
	 */
	@Override
	public int doSomething(double param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doSomethingWithDefaultMethod(int param) {
		// TODO Auto-generated method stub
		return 0;
	}

}
