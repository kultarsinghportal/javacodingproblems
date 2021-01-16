package Lambda;

import java.util.Arrays;
import java.util.List;

public class DebuggingLambda {

	private static final List<String> names = Arrays.asList("kultar", "deepak", "sakshi", "pathik", "payal", "shweta");

	public static void main(String... args) {

		names.stream().map(s -> s.replace(s.charAt(0), String.valueOf(s.charAt(0)).toUpperCase().charAt(0))).sorted()
				.forEach(System.out::println);
		names.stream().filter(s -> s.startsWith("p")).map(String::toUpperCase).sorted().forEach(System.out::println);
	}
}
