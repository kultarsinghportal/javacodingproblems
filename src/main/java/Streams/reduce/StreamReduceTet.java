package Streams.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceTet {

	public static void main(String... args) {

		long startTime = System.currentTimeMillis();
		List<Integer> numbers = Arrays.asList(1, 4, 5, 6, 3, 4, 7, 8, 2, 5, 77, 88, 33);
		List<Integer> numbers1 = Arrays.asList();
		int iterate = 1000;
		while (iterate > 0) {
			int sum = 0;

			/*
			 * for (int i : numbers) { sum += i; }
			 */

			/* sum = numbers.stream().reduce(0, (a, b) -> a + b); */
			sum = numbers.stream().reduce(0, Integer::sum);
			System.out.println(sum);
			long timeTaken = System.currentTimeMillis() - startTime;
			System.out.println("Time Taken" + timeTaken);
			iterate--;
		}
		Optional<Integer> sum1 = numbers1.stream().reduce(Integer::sum);
		System.out.println(sum1);
	}
}
