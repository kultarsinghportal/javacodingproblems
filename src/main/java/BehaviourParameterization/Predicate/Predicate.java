package BehaviourParameterization.Predicate;

@FunctionalInterface
public interface Predicate<T> {
	boolean test(T t);
}
