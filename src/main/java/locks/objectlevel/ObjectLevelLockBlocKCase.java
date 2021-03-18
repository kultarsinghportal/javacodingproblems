package locks.objectlevel;

public class ObjectLevelLockBlocKCase {

	public void doSomething() throws InterruptedException {
		synchronized (this) {
			System.out.println("Working inside synchronized function. Thread -> " + Thread.currentThread().getName());
			Thread.sleep(5000);
		}
		System.out.println("Outside synchronized block");
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
