package locks.classlevel;

public class ClassLevelLock {

	public static synchronized void doSomething() throws InterruptedException {

		System.out.println("Doing something. Thread -> " + Thread.currentThread().getName() + " -> "
				+ Thread.currentThread().getState());
		Thread.sleep(3000);
	}

	public void doAnotherThing() throws InterruptedException {

		synchronized (ClassLevelLock.class) {

			System.out.println("Doing Another Thing. Thread -> " + Thread.currentThread().getName() + " -> "
					+ Thread.currentThread().getState());
			Thread.sleep(3000);
		}
	}

	public static void main(String[] args) throws InterruptedException {

		int i = 5;
		ClassLevelLock obj = new ClassLevelLock();
		do {
			Thread t = new Thread(() -> {

				try {
					ClassLevelLock.doSomething();
					System.out.println("Something executed. Thread -> " + Thread.currentThread().getName() + " -> "
							+ Thread.currentThread().getState());

					obj.doAnotherThing();
					System.out.println("Another Thing executed. Thread -> " + Thread.currentThread().getName() + " -> "
							+ Thread.currentThread().getState());

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
