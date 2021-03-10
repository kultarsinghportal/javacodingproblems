package thread.lifecycle.states;

/**
 * A Java thread is in the NEW state if it is created but not started (the
 * thread constructor creates threads in the NEW state). This is its state until
 * the start() method is invoked.
 * 
 * @author Kultar
 *
 */
public class NewState {

	public void newThread() {
		Thread t1 = new Thread(() -> {
		});
		System.out.println(t1.getState());
	}

	public static void main(String[] args) {

		new NewState().newThread();
	}
}
