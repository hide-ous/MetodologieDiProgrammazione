package lecture13;

public class ListTester {

	public static void main(String[] args) {
		List l = new IntLinkedList();
		System.out.println(l);
		System.out.println("expected: {}");
		l.add(1);
		System.out.println(l);
		System.out.println("expected: 1");
		l.add(2);
		l.add(3);
		l.add(4);
		System.out.println(l);
		System.out.println("expected: 1 2 3 4");
		l.set(0, 4);
		System.out.println(l);
		System.out.println("expected: 4 2 3 4");
		l.remove();
		System.out.println(l);
		System.out.println("expected: 4 2 3");
		l.add(5);
		System.out.println(l);
		System.out.println("expected: 4 2 3 5");
		l.remove(1);
		System.out.println(l);
		System.out.println("expected: 4 3 5");
		l.remove(0);
		System.out.println(l);
		System.out.println("expected: 3 5");
		l.set(0, 1);
		System.out.println(l);
		System.out.println("expected: 1 5");
		l.remove(0);
		System.out.println(l);
		System.out.println("expected: 5");
		l.add(0);
		System.out.println(l);
		System.out.println("expected: 5 0");
		l.remove();
		System.out.println(l);
		System.out.println("expected: 5");
		l.add(0);
		System.out.println(l);
		System.out.println("expected: 5 0");
		l.remove(1);
		System.out.println(l);
		System.out.println("expected: 5");
		l.add(0);
		System.out.println(l);
		System.out.println("expected: 5 0");
		l.remove(0);
		System.out.println(l);
		System.out.println("expected: 0");
		l.remove();
		System.out.println(l);
		System.out.println("expected: {}");
		l.add(1);
		System.out.println(l);
		System.out.println("expected: 1");
		
		l.clear();
		System.out.println(l);
		try {
			l.remove(0);
			System.out.println("shouldn't get here");
		} catch (Exception e) {
			System.out.println("correctly throws exception");
		}
			

	}

}
