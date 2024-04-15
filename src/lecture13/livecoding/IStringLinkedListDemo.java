package lecture13.livecoding;

import java.util.Iterator;

public class IStringLinkedListDemo {

	public static void main(String[] args) {
		
		IStringLinkedList ll = new StringLinkedList();
		ll.addFirst("Ohai");
		ll.addLast("Didn't");
		ll.addLast("see");
		ll.addLast("you");
		ll.addLast("there");
//		System.out.println(ll);

		ll.insertAt("I", 1);
//		System.out.println(ll);
		
		
		Iterator<String> it = ll.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
