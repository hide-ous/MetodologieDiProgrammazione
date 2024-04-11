package lecture13;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntLinkedList implements lecture13.List{
	private class Node{
		Integer element;
		Node next;
		Node(){
			this(null, null);
		}
		Node(Integer element){
			this(element, null);
		}
		Node(Integer element, Node next){
			this.element=element;
			this.next=next;
		}
		
		public class NodeIterator  implements Iterator<Integer>{
			private Node currentNode=Node.this;
			
			@Override
			public boolean hasNext() {
				return currentNode.next !=null;
			}
			@Override
			public Integer next() {
				if(!hasNext()) {
					throw new NoSuchElementException("No next node!");
				}
				currentNode=currentNode.next;	
				return currentNode.element;
				
			}
			
		}
	}
	
	
	private int size;
	private final Node HEAD;
	private Node lastNode;
	public IntLinkedList() {
		this.HEAD = new Node();
		this.lastNode=HEAD;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return size!=0;
	}



	@Override
	public Iterator<Integer> iterator() {
		return HEAD.new NodeIterator();
	}

	@Override
	public Object[] toArray() {
		Integer[] array = new Integer[size];
		Iterator<Integer> iterator = iterator();
		for(int i =0; i<size; i++) {
			array[i] = iterator.next();
		}
		return array;
	}



	@Override
	public boolean remove() {
		Node oneButLast = getTo(size-2);
		oneButLast.next=null;
		lastNode=oneButLast;
		size--;
		return true;
	}


	@Override
	public void clear() {
		this.lastNode=HEAD;
		this.lastNode.next=null;
		size=0;
		
	}
	
	private Node getTo(int index) {
		lecture13.IntLinkedList.Node.NodeIterator it = HEAD.new NodeIterator();
		if(index>-1) {
			it.next(); //account for HEAD			
		}
		for(int i = 0; i<index; i++) {
			it.next();
		}
		return it.currentNode;
				
	}


	@Override
	public Integer remove(int index) {
		Node prev = getTo(index-1);
		Node toRemove = prev.next;
		prev.next = toRemove.next;
		if(index==size-1) {
			lastNode=prev;
		}
		size--;
		return toRemove.element;
	}



	@Override
	public boolean contains(Integer o) {
		Iterator<Integer> intIterator = iterator();
		while(intIterator.hasNext()) {
			if(intIterator.next()==o) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean add(Integer e) {
		Node newNode = new Node(e);
		lastNode.next=newNode;
		lastNode = newNode;
		size++;
		return true;
	}

	@Override
	public Integer set(int index, Integer element) {
		Node prev = getTo(index);
		Integer toReturn = prev.element;
		prev.element=element;
		return toReturn;
	}
	
	@Override
	public String toString() {
		String toReturn = "size: "+size+"; elements:";
		Iterator<Integer> it = iterator();
		while(it.hasNext()) {
			toReturn+=" "+it.next();
		}
				
		return toReturn;
	}

}
