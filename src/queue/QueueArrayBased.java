package queue;

/**
 *
 * @author SheifShahin
 */
public class QueueArrayBased {
	/**
		 *
		 */
	private final int numOfMaxElements;
	/**
		 *
		 */
	private final Object[] arr;

	/**
	 *
	 * @param numOfElementsConstructor
	 *            .
	 */
	public QueueArrayBased(final int numOfElementsConstructor) {
		this.numOfMaxElements = numOfElementsConstructor;
		arr = new Object[numOfMaxElements];
	}

	/**
		 *
		 */
	private int headFlage = 0;
	/**
		 *
		 */
	private int tailFlage = -1; // Moving
	/**
		 *
		 */
	private int size = 0;
	/**
		 *
		 */
	private final RuntimeException ex = new RuntimeException("Error At Run Time!");

	// public void print() {
	// for (int i = 0; i <= tailFlage; i++) {
	// System.out.println(arr[i]);
	// }
	// }
	/**
		 *
		 */
	public final void enqueue(final Object element) {
		if (size == numOfMaxElements) {
			throw ex;
		}
		size++;
		if (tailFlage == numOfMaxElements - 1) {
			tailFlage = 0;
			arr[tailFlage] = element;
			return;
		}
		tailFlage++;
		arr[tailFlage] = element;
	}

	public final Object dequeue() {
		if (size == 0) {
			throw ex;
		}
		size--;
		final Object v = arr[headFlage];
		arr[headFlage] = null;
		headFlage = (headFlage + 1) % numOfMaxElements;
		return v;
	}

	public final boolean isEmpty() {
		return size == 0;
	}

	public final int size() {
		return size;
	}

}
