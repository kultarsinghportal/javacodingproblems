package functionalinterface.function.identify;

import java.util.function.Function;

public class IdentityTest1 {
	public static void main(String[] args) {
	    
	    Function<Integer, Integer> identityFunction1 = Function.identity();
	    Function<Integer, Integer> identityFunction2 = Function.identity();
	    Function<Integer, Integer> identityFunction3 = Function.identity();
	    
	    Function<Integer, Integer> intFunction1 = e -> e;
	    Function<Integer, Integer> intFunction2 = e -> e;
	    Function<Integer, Integer> intFunction3 = e -> e;
	    
	    System.out.println(identityFunction1); 
	    System.out.println(identityFunction2);
	    System.out.println(identityFunction3);
	    
	    System.out.println(intFunction1);
	    System.out.println(intFunction2);
	    System.out.println(intFunction3);
	    
	  } 
}
