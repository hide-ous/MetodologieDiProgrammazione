package lecture12;


public class IntIterable implements Iterable<Integer> {
	Integer[] internalArray;
	int k;
	public IntIterable(Integer[] internalArray) {
		this.internalArray=internalArray.clone();
	}

	@Override
	public Integer next() {
		return internalArray[k++];
	}

	@Override
	public boolean hasNext() {
		return k<internalArray.length;
	}

}
