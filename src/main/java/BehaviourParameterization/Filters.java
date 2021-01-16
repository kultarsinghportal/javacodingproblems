package BehaviourParameterization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filters {

	public static List<Melon> filterByType(List<Melon> melons, String type) {

		List<Melon> result = new ArrayList<>();

		for (Melon melon : melons) {
			if (melon != null && type.equalsIgnoreCase(melon.getType())) {
				result.add(melon);
			}
		}

		return result;
	}

	// Boilerplate code
	public static List<Melon> filterByWeight(List<Melon> melons, int weight) {

		List<Melon> result = new ArrayList<>();

		for (Melon melon : melons) {
			if (melon != null && melon.getWeight() == weight) {
				result.add(melon);
			}
		}

		return result;
	}

	// Boilerplate code
	public static List<Melon> filterByTypeAndWeight(List<Melon> melons, String type, int weight) {
		List<Melon> result = new ArrayList<>();

		for (Melon melon : melons) {
			if (melon != null && type.equalsIgnoreCase(melon.getType()) && melon.getWeight() == weight) {
				result.add(melon);
			}
		}

		return result;
	}

	public static void main(String... args) {
		List<Melon> melons = Arrays.asList(new Melon("Yellow", 18, "Switzerland"), new Melon("Black", 16, "London"),
				new Melon("Red", 10, "India"), new Melon("Red", 12, "Indonesia"), new Melon("Blue", 12, "Australia"),
				new Melon("Green", 14, "China"));

		filterByType(melons, "Red").forEach(System.out::println);
		filterByWeight(melons, 12).forEach(System.out::println);
		filterByTypeAndWeight(melons, "Red", 12).forEach(System.out::println);
	}

}
