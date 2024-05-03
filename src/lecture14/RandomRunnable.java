package lecture14;

import java.util.Random;

public class RandomRunnable implements Runnable {

	private static final int MAX_RUNNABLE_ID = 1000;

	@Override
	public void run() {
		greet();

	}

	public static void greet() {
		System.out.println("I'm runner "+new Random().nextInt(MAX_RUNNABLE_ID));
	}

}
