package queue;

import maze.Node;

/**
 *
 * @author SheifShahin
 *
 */

public class QueueLinkedListBased {
	/**
		 *
		 */
	private final RuntimeException ex = new RuntimeException("Error At Run Time (Queue)");
	/**
		 *
		 */
	private final Node tail = new Node();
	/**
		 *
		 */
	private final Node head = new Node();

	/**
		 *
		 */
	public QueueLinkedListBased() {
		head.element = "DummyHead";
		tail.element = "DummyTail";
	}

	/**
		 *
		 */
	private int size = 0;

	public final void enqueue(final Node element) {
		final Node newNode = new Node();
		newNode.element = element;
		if (size == 0) {
			head.next = newNode;
			tail.next = newNode;
			size++;
			return;
		}
		tail.next.next = newNode;
		tail.next = newNode;
		size++;
	}

	public final Object dequeue() {
		if (size == 0) {
			throw ex;
		}
		final Object v = head.next.element;
		head.next = head.next.next;
		size--;
		if (size == 0) {
			tail.next.next = null;
		}
		return v;
	}

	public final boolean isEmpty() {
		return size == 0;
	}

	public final int size() {
		return size;
	}

}
