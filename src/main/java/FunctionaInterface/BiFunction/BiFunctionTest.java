package FunctionaInterface.BiFunction;

import java.util.function.BiFunction;

public class BiFunctionTest {

	private BiFunction<Integer, Integer, Integer> add = null;
	private BiFunction<Integer, Integer, Integer> composite = null;
	private BiFunction<Integer, Integer, Integer> compositeNull = null;

	public static void main(String... args) {

		new BiFunctionTest().bifunctionTest();

	}

	private void bifunctionTest() {
		add = (a, b) -> a + b;
		System.out.println("Addition : " + add.apply(10, 5));

		composite = (a, b) -> a * b;
		composite = composite.andThen(a -> 2 * a);// Must pass Function as an argument not BiFunction
		System.out.println("Composite BiFunction : " + composite.apply(7, 20));
		
		compositeNull = (a, b) -> a -b;
		compositeNull = compositeNull.andThen(null);// intentionally passing null;
		try {
			System.out.println("Composite Null BiFunction : " + compositeNull.apply(10, 3));
		} catch (Exception e) {
			System.out.println("Exception :" + e);
		}
	}
}
