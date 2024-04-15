package lecture13.livecoding;

import java.util.Iterator;

public class StringLinkedList implements IStringLinkedList {

	
	private class StringNode{
		private String element;
		private StringNode next;
	}
	
	private StringNode first;

	@Override
	public Iterator<String> iterator() {
		return new StringIterator();
	}
	private class StringIterator implements Iterator<String>{
		NodeIterator it;
		private StringIterator() {
			it = new NodeIterator();
		}

		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public String next() {
			return it.next().element;
		}
		
	}

	@Override
	public void addFirst(String element) {
		StringNode oldFirst = first;
		StringNode newFirst = new StringNode();
		newFirst.element=element;
		newFirst.next=oldFirst;
		first = newFirst;
	}

	@Override
	public void addLast(String element) {
		StringNode last = null;
		NodeIterator it = new NodeIterator();
		while (it.hasNext()){
			last=it.next();
		}
		
		StringNode newNode = new StringNode();
		newNode.element = element;
		newNode.next=null;
		
		last.next=newNode;
		

		
		
//		if(first==null) {
//			addFirst(element);
//		} else {
//			
//			StringNode newNode = new StringNode();
//			newNode.element = element;
//			newNode.next=null;
//			
//			StringNode currentNode = first;
//			while(currentNode.next !=null) {
//				currentNode=currentNode.next;
//			}
//			currentNode.next=newNode;
//			
//		}
	}

	@Override
	public String removeFirst() {
		if(first==null) {
			throw new IllegalStateException();
		}
		String toReturn = first.element;
		first = first.next;
		return toReturn;
	}

	private class NodeIterator implements Iterator<StringNode>{
		StringNode currentNode;
		public NodeIterator() {
			currentNode = first;
		}
		
		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public StringNode next() {
			StringNode toReturn = currentNode;
			currentNode = currentNode.next;
			return toReturn;
		}
		
	}
	@Override
	public void insertAt(String element, int index) {
		if(index==0) {
			addFirst(element);
		} else {
			StringNode currentNode = null;
			NodeIterator it = new NodeIterator();
			for (int i = 0; i<index; i++ ) {
				currentNode = it.next();
			}
			
			StringNode newNode = new StringNode();
			newNode.element=element;
			
			StringNode nextNode = currentNode.next;
			currentNode.next=newNode;
			newNode.next=nextNode;

			
		}
		
	}

	
	@Override
	public String toString() {
		String toReturn = "";
			
//		StringNode currentNode = first;
//		if (currentNode!=null) {
//			while(currentNode.next !=null) {
//				toReturn+= "node: "+currentNode.element+"\n";
//				currentNode=currentNode.next;
//			}
//			toReturn+= "node: "+currentNode.element+"\n";
//		}
		
		NodeIterator it = new NodeIterator();
		while (it.hasNext()){
			toReturn+= "node: "+it.next().element+"\n";
		}
		return toReturn;
	}
}
