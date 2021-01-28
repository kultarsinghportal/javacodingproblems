package FunctionaInterface.Function;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionTest1 {

	private static final Function<String, String> firstAndLastChar = s -> String.valueOf(s.charAt(0))
			+ String.valueOf(s.charAt(s.length() - 1));

	private static Function<String, String> reduceStrings(Function<String, String>... functions) {
		Function<String, String> function = Stream.of(functions).reduce(Function.identity(), Function::andThen);
		return function;
	}

	private static List<String> rndStringFromStrings(List<String> strs) {

		return strs.stream().map(str -> {
			Random rnd = new Random();
			int nr = rnd.nextInt(str.length());
			String ch = String.valueOf(str.charAt(nr));

			return ch;
		}).collect(Collectors.toList());
	}

	public static void main(String... args) {

		Function<String, String> f1 = s -> s.toUpperCase();
		Function<String, String> f2 = s -> s.concat(" DONE.");
		Function<String, String> f3 = s -> s.concat(" Tested");

		Function<String, String> reduceStrings = FunctionTest1.reduceStrings(f1, f2, f3);
		System.out.println(reduceStrings.apply("kultar"));

		String text = "Lambda";
		String result = firstAndLastChar.apply(text);
		System.out.println("Result : " + result);
		System.out.println("La".equals(result));

		System.out.println(FunctionTest1.rndStringFromStrings(Arrays.asList("Kultar", "Deepak", "Suresh", "Mahesh")));

		System.out.println(FunctionTest1.rndStringFromStrings(Arrays.asList("Kultar", "Deepak", "Suresh", "Mahesh"))
				.stream().map(s -> s.concat("1")).collect(Collectors.toList()));

	}
}
