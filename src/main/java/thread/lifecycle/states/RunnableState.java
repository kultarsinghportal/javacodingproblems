package thread.lifecycle.states;

/**
 * The RUNNABLE state The transition from NEW to RUNNABLE is obtained by calling
 * the start() method. In this state, a thread can be running or ready to run.
 * When it is ready to run, a thread is waiting for the JVM thread-scheduler to
 * allocate the needed resources and time to run to it. As soon as the processor
 * is available, the thread-scheduler will run the thread.
 * 
 * @author Kultar
 *
 */
public class RunnableState {

	void newThread() {
		Thread t1 = new Thread(() -> {
		});
		t1.start();
		System.out.println(t1.getState());
	}

	public static void main(String[] args) {

		new RunnableState().newThread();
	}
}
