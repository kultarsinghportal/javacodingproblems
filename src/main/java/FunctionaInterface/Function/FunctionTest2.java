package FunctionaInterface.Function;

import java.util.function.BinaryOperator;

public class FunctionTest2 {

	public static void main(String [] args) {
		
		BinaryOperator<Integer> addition = (a, b) -> a+b;
		int sum = addition.apply(5, 10);
		System.out.println(sum);
		
	}
}
