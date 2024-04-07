package lecture12;

public class ISquaredSeries implements Series {
	
	int k;
	public static void main(String[] args) {
		ISquaredSeries iss = new ISquaredSeries();
		for(int i=0; i<10; i++) {
			System.out.println(iss.next());
		}
	}

	@Override
	public int next() {
		return (int) Math.pow(k++, 2);
	}

}
