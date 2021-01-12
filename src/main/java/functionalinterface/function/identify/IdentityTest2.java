package functionalinterface.function.identify;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IdentityTest2 {
	// Convert list to set, and if list has duplicates -> show duplicate count
	public static void main(String[] args) {

		List<String> names = Arrays.asList("Peter", "Martin", "John",
				 "Peter",
				"Vijay",
				 "Martin",
				 "Peter",
				"Arthur");

		Set<String> namesSet = new HashSet<>(names);
		// names.size() != namesSet.size();// => true if duplicates

		names.stream().map(getFunction(names, names.size() != namesSet.size())).collect(Collectors.toSet())
				.forEach(System.out::println);

	}

	static Function<String, String> getFunction(List<String> names, boolean hasDuplicates) {
		// Collections.frequency(names, name) => to get duplicate count

		return hasDuplicates ? name -> name + " (" + Collections.frequency(names, name) + ")" : Function.identity();
	}
}
