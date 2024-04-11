package lecture13;

import java.util.Iterator;

public class NodeIterator implements Iterator<Integer> {

	private Node currentNode;
	public NodeIterator(Node startNode) {
		this.currentNode=startNode;
	}
	@Override
	public boolean hasNext() {
		return currentNode!=null;
	}

	@Override
	public Integer next() {
		Integer toReturn = currentNode.getElement();
		this.currentNode=currentNode.getNext();
		return toReturn;
	}

}
