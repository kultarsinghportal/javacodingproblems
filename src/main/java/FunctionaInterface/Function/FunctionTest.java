package FunctionaInterface.Function;

import java.util.function.Function;

public class FunctionTest {

	public static void main(String ... args) {
		
		Function<Character, Integer> ascii = a -> (int)a;
		System.out.println("ASCII :" + ascii.apply('a'));
		
		Function<Character, Integer> testAndThen = a -> (int) a;
		testAndThen = testAndThen.andThen(a -> a +1);
		System.out.println("Test andThen :" + testAndThen.apply('a'));
		
		 // Function which takes in a number and 
        // returns half of it 
        Function<Integer, Double> half = a -> a / 2.0; 
  
        // Now treble the output of half function 
        half = half.andThen(a -> 3 + a); 
  
        // apply the function to get the result 
        System.out.println(half.apply(15));
        
     // Function which takes in a number and 
        // returns half of it 
        Function<Integer, Double> half1 = a -> a / 2.0; 
  
        // However treble the value given to half function 
        half1 = half1.compose(a -> 3 + a); 
  
        // apply the function to get the result 
        System.out.println(half1.apply(15)); 
	}
}
