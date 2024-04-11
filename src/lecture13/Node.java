package lecture13;

public class Node {
	private Integer element;
	private Node next;
	public Node(Integer element, Node next) {
		this.setElement(element);
		this.setNext(next);
	}
	public Node(Integer element) {
		this(element, null);
	}
	public Node() {
		this(null, null);
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Integer getElement() {
		return element;
	}
	public void setElement(Integer element) {
		this.element = element;
	}
	

}
