package linkedList_implementation;

import java.util.LinkedList;
import java.util.List;

public class DoubleLinkedList {
	
	List<Object> list = new LinkedList<Object>();
	RuntimeException IndexOutOfBound = new RuntimeException("_ME_Your Index is Out Of Bound");
	
	public List check (){
		return list;
	}
	
	/**
	* Inserts a specified element at the specified sposition in the list.
	*/
	public void add (int index, Object element) {
		list.add(index , element);
	}
	
	/** Inserts the specified element at the end of the list. */
	public void add(Object element) {
		list.add(element);
		
	}
	
	/** Returns the element at the specified position in this list. */
	public Object get(int index) {
		if (index >= list.size())
			throw IndexOutOfBound ;
		return list.get(index);
	}
	
	/**
	* Replaces the element at the specified position in this list with
	* the specified element.
	*/
	public void set(int index, Object element) {
		list.remove(index);
		list.add(index , element);	
	}

	/** Removes all of the elements from this list. */
	public void clear() {
		
	}

	/** Returns true if this list contains no elements. */
	public boolean isEmpty() {
		return false;
	}

	/** Removes the element at the specified position in this list. */
	public void remove(int index) {
		
	}

	/** Returns the number of elements in this list. */
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Returns true if this list contains an element with the same value
	 * as the specified element.
	 */
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
