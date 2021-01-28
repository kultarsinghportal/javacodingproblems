package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		numbers.stream().map(i -> i * i).collect(Collectors.toList()).forEach(System.out::println);

		List<String> words = Arrays.asList("Hello", "World");

		words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList())
				.forEach(System.out::println);

		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);

		numbers1.stream().flatMap(i -> numbers2.stream().map(j -> Arrays.asList(i, j)))
				.collect(Collectors.toList()).forEach(System.out::println);;
		 

	}
}
