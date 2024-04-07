package lecture12;

public class IterableTester {

	public static void main(String[] args) {
		IntIterable it = new IntIterable(new Integer[]{1, 2, 3});
		while( it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
