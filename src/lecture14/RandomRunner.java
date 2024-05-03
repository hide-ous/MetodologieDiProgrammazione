package lecture14;

public class RandomRunner {

	private static final int N_RUNNABLES = 10;

	public static void main(String[] args) {

//		Runnable runner;
////		runner = new RandomRunnable();
////		runner = new Runnable() {
////			
////			@Override
////			public void run() {
////				RandomRunnable.greet();
////			}
////		};
//		runner = ()-> RandomRunnable.greet();
//		runner.run();
		
		Runnable[] runnerPack = new Runnable[N_RUNNABLES];
		for (int i = 0; i<N_RUNNABLES;i++) runnerPack[i] = ()-> RandomRunnable.greet();
//		System.out.println(runnerPack.length);
		
		for(Runnable runner: runnerPack) runner.run();
		
	}

}
