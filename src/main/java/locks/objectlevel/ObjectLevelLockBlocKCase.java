package locks.objectlevel;

/**
 * Locking at object level can be achieved by marking a non-static block of code
 * or non-static method (the lock object for that method's object) with
 * synchronized. In the following example, only one thread at a time will be
 * allowed to execute the synchronized method/block on the given instance of the
 * class.
 * 
 * @author Kultar
 *
 */
public class ObjectLevelLockBlocKCase {

	private final Object ollLock = new Object(); // can be used as lock object

	public void doSomething() throws InterruptedException {
		synchronized (this /* ollLock */) {
			System.out.println("Working inside synchronized function. Thread -> " + Thread.currentThread().getName());
			Thread.sleep(5000);
		}
		System.out.println("Outside synchronized block. Thread -> " + Thread.currentThread().getName());
	}

	public static void main(String[] args) throws InterruptedException {

		ObjectLevelLockMethodCase obj = new ObjectLevelLockMethodCase();
		int i = 5;
		do {
			Thread t = new Thread(() -> {

				System.out.println("Thread started -> ");
				try {
					obj.doSomething();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			});
			t.start();
			Thread.sleep(1000);
			System.out.println("Thread -> " + t.getName() + " state -> " + t.getState());
			i--;
		} while (i >= 0);
	}
}

/**
 * Question. Why statements after the synchronized block are not getting executed? 
*/