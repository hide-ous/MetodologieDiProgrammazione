package lecture12;

public class CircularSeries implements Series {
	int k;
	int[] pattern = new int[] {4, 8, 15, 16, 23, 42}; 
	
	@Override
	public int next() {
		int returnValue= pattern[k];
		k++;
		k =  k % pattern.length;
		return returnValue;
	}

	public static void main(String[] args) {
		CircularSeries iss = new CircularSeries();
		for(int i=0; i<20; i++) {
			System.out.println(iss.next());
		}

	}

}
