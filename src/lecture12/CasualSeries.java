package lecture12;

public class CasualSeries implements Series {

	private static final int MAX=1000;
	private static final int MIN=-1000;
	@Override
	public int next() {
		return (int) (Math.random()*(MAX-MIN)+MIN);
	}
	public static void main(String[] args) {
		CasualSeries iss = new CasualSeries();
		for(int i=0; i<100; i++) {
			System.out.println(iss.next());
		}
	}

}
