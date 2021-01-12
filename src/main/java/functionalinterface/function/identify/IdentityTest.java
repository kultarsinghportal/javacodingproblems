package functionalinterface.function.identify;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class IdentityTest {
	public static void main(String[] args) {

		Function<Integer, Integer> identityFunction = Function.identity();
		Function<Integer, Integer> intFunction = e -> e; // using lambda expression

		System.out.println(identityFunction.apply(10)); // 10
		System.out.println(intFunction.apply(10)); // 10

		List<String> names = Arrays.asList("Peter", "Martin", "John", "Vijay", "Arthur");

		// Just for example
		System.out.println("----- Function.identity() -----");
		names.stream().map(Function.identity()).forEach(System.out::println);

		System.out.println("----- Function(e-> e) -----");
		names.stream().map(e -> e).forEach(System.out::println);
	}
}
