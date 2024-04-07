package lecture12;

public class FibonacciSeries implements Series {
	int kPrev=0;
	int kCur=0;

	@Override
	public int next() {
		int kNext;
		if (kPrev==0 && kCur==0) {
			kNext=1;
		} else {
			kNext=kPrev+kCur;
		}
		kPrev = kCur;
		kCur =kNext;
		return kNext;
	}
	
	public static void main(String[] args) {
		FibonacciSeries iss = new FibonacciSeries();
		for(int i=0; i<10; i++) {
			System.out.println(iss.next());
		}
	}

}
