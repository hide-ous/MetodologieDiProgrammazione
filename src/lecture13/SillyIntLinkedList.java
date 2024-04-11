package lecture13;

import java.util.Iterator;

public class SillyIntLinkedList implements List {
	private Node lastNode;
	private int size;
	private Node head;
	
	
	private Node getTo(int position) {
		if(position<0||position>=size) {
			throw new IllegalArgumentException("cannot go to position "+position);
		}
		Node currentNode = head;
		for(int i=0; i<position; i++) {
			currentNode=currentNode.getNext();
		}
		return currentNode;
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		
		return size!=0;
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
	public Iterator<Integer> iterator() {
		return new NodeIterator(head);
	}

	@Override
	public boolean add(Integer e) {
		Node newNode = new Node(e);
		if( head==null) {
			head=newNode;
		} else {
			lastNode.setNext(newNode);			
		}
		lastNode = newNode;
		size++;
		return true;
	}

	@Override
	public void clear() {
		head=null;
		size=0;
		lastNode=null;
	}

	@Override
	public Integer set(int index, Integer element) {
		Node prev = getTo(index);
		Integer toReturn = prev.getElement();
		prev.setElement(element);
		return toReturn;
	}

	@Override
	public Integer remove(int index) {
		Node toRemove ;
		if(index==0) {
			toRemove=head;
			head=toRemove.getNext();
			if(index==size-1) {
				lastNode=head;
			}
		} else {
			Node prev = getTo(index-1);
			toRemove = prev.getNext();
			prev.setNext(toRemove.getNext());			
			if(index==size-1) {
				lastNode=prev;
			}
		}
		size--;
		return toRemove.getElement();
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
		if(size==1) {
			head=null;
			lastNode=null;
		} else {
			Node oneButLast = getTo(size-2);
			oneButLast.setNext(null);
			lastNode=oneButLast;
		}
		size--;
		return true;			
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
