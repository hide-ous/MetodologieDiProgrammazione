package lecture13.livecoding;

public interface IStringLinkedList extends Iterable<String>{
	
	void addFirst(String element);
	void addLast(String element);
	String removeFirst();
	void insertAt(String element, int index);


}
