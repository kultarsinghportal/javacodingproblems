package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPower {

	private static List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

	public static void main(String... args) {

		// Before Java 7
		List<Dish> lowCaloriesDishes = new ArrayList<>();
		List<String> lowCaloriesDishName = null;
		
		long startTime = System.currentTimeMillis();
		for (Dish d : menu) {
			if (d.getCalories() < 400) {
				lowCaloriesDishes.add(d);
			}

			Collections.sort(lowCaloriesDishes, new Comparator<Dish>() {

				@Override
				public int compare(Dish o1, Dish o2) {
					return Integer.compare(o1.getCalories(), o2.getCalories());
				}
			});

			lowCaloriesDishName = new ArrayList<>();
			for (Dish d1 : lowCaloriesDishes) {
				lowCaloriesDishName.add(d1.getName());
			}
		}

		System.out.println(lowCaloriesDishName);
		long timeTaken = System.currentTimeMillis()-startTime;
		System.out.println("Time took before Java 7 : " + timeTaken);

		// After Java 8
		long startTime1 = System.currentTimeMillis();
		lowCaloriesDishName = menu.parallelStream().filter(d -> d.getCalories() < 400)
				.sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName).collect(Collectors.toList());
		System.out.println(lowCaloriesDishName);
		long timeTaken1 = System.currentTimeMillis() - startTime1;
		System.out.println("Time took After Java 8 : " + timeTaken1);
	}
}
