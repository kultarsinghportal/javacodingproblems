package executor;

import java.util.concurrent.Executor;

public class ExecutorTest implements Executor {

	@Override
	public void execute(Runnable command) {

		// In the simplest case, an executor can run the submitted task immediately in
		// the caller's thread
		command.run();

		// More typically, tasks are executed in some thread other than the caller's
		// thread. The executor below spawns a new thread for each task.
		new Thread(command).start();
	}

	public static void main(String[] args) {

		ExecutorTest obj = new ExecutorTest();
		obj.execute(() -> {
			System.out.println("Task 1 Executed via Executor. Thread - " + Thread.currentThread().getName());
		});

		obj.execute(() -> {
			System.out.println("Task 2 Executed via Executor. Thread - " + Thread.currentThread().getName());
		});
	}

}
