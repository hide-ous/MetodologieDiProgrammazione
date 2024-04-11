package lecture13;

import java.util.Iterator;

public interface List extends Iterable<Integer>{

	int size();

	boolean isEmpty();

	boolean contains(Integer o);

	Iterator<Integer> iterator();

	boolean add(Integer e);

	void clear();

	Integer set(int index, Integer element);

	Integer remove(int index);

	Object[] toArray();

	boolean remove();

}