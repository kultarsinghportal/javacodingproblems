package javacodigproblems.String;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StringCountDuplicateCharacters {

	public static void main(String... args) {
		String str = "This is a current and duplicate current string";

		long startTime = System.currentTimeMillis();
		java.util.concurrent.ConcurrentHashMap<Character, Integer> dupStr = new ConcurrentHashMap<>();

		for (char ch : str.toCharArray()) {
			dupStr.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
			//BiFunction -> (k, v) -> (v == null) ? 1 : ++v
		}
		System.out.println(dupStr);

		long endTime = System.currentTimeMillis();
		System.out.println("First Approach : " + (endTime - startTime));

		long startTime1 = System.currentTimeMillis();
		System.out.println(countDuplicateCharacters(str));
		long endTime1 = System.currentTimeMillis();
		System.out.println("Second Approach : " + (endTime1 - startTime1));
	}

	public static Map<Character, Long> countDuplicateCharacters(String str) {

		Map<Character, Long> result = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		return result;
	}

}
