package thread.lifecycle.states;

/**
 * When a thread is trying to execute I/O tasks or synchronized blocks, it may
 * enter into the BLOCKED state. For example, if a thread, t1, tries to enter
 * into a synchronized block of code that is already being accessed by another
 * thread, t2, then t1 is kept in the BLOCKED state until it can acquire the
 * lock.
 * 
 * @author Kultar
 *
 */
public class BlockedState {

	public void blockedThread() throws InterruptedException {

		Thread t1 = new Thread(new SyncCode());
		Thread t2 = new Thread(new SyncCode());

		t1.start();
		Thread.sleep(2000);
		t2.start();
		Thread.sleep(2000);

		System.out.println("BlockedState t1: " + t1.getState() + "(" + t1.getName() + ")");
		System.out.println("BlockedState t2: " + t2.getState() + "(" + t2.getName() + ")");

		System.exit(0);
	}

	private static class SyncCode implements Runnable {

		@Override
		public void run() {
			System.out.println("Thread " + Thread.currentThread().getName() + " is in run() method.");
			syncMethod();
		}

		public static synchronized void syncMethod() {

			System.out.println("Thread " + Thread.currentThread().getName() + " is in syncMethod() method");

			while (true) {

			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		new BlockedState().blockedThread();
	}
}
