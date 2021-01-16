package BehaviourParameterization.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import BehaviourParameterization.Melon;

public class PredicateTest {

	private static <T> Iterable<T> filter(Iterable<T> itr, Predicate<T> predicate) {

		List<T> result = new ArrayList<>();
		for (T t : itr) {
			if (null != t && predicate.test(t)) {

				result.add(t);
			}
		}
		return result;
	}

	public static void main(String... args) {

		List<Melon> melons = Arrays.asList(new Melon("Yellow", 18, "Switzerland"), new Melon("Black", 16, "London"),
				new Melon("Red", 10, "India"), new Melon("Blue", 16, "Newzealand"), new Melon("Red", 12, "Indonesia"),
				new Melon("Blue", 12, "Australia"), new Melon("Green", 14, "China"));

		filter(melons, m -> "Red".equalsIgnoreCase(m.getType())).forEach(System.out::println);
		filter(melons, m -> m.getWeight() > 14).forEach(System.out::println);
		filter(melons, m -> "India".equals(m.getOrigin())).forEach(System.out::println);

		Predicate<Melon> predicate = (Melon m) -> "Blue".equalsIgnoreCase(m.getType());
		filter(melons, predicate).forEach(System.out::println);
	}
}