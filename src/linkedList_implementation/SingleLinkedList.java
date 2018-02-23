package linkedList_implementation;
import maze.Node;

/**
 * SingleLinkedList class .
 */
public class SingleLinkedList {
	/**
	 * RuntimeException .
	 */
	private RuntimeException ex = new RuntimeException("Error At Run Time!");
	/**
	 * Initialize the head node.
	 */
	private Node head = null;

	/**
	 * print method.
	 */

	public int[][] addition(int[][] A, int[][] B) {
//		int x = A[0][1];
//		int y = B[0][1];
		int i = 0;
		int j = 0;
		int p = 0;
		int count = 0;
		int counter = 0;
		int R[][] = new int[100][2];
		while (i < A.length && j < B.length) {
			if (A[i][1] > B[j][1]) {
				R[p][1] = A[i][1];
				R[p][0] = A[i][0];
				i++;
				p++;
				count++;
			} else if (A[i][1] < B[j][1]) {
				R[p][1] = B[j][1];
				R[p][0] = B[j][0];
				j++;
				p++;
				count++;
			} else if (A[i][1] == B[j][1]) {
				R[p][1] = A[i][1];
				R[p][0] = A[i][0] + B[j][0]; //// add
				i++;
				j++;
				p++;
				count++;
			} else {
				break;
			}
			counter++;
		}
		if (i < A.length) {
			for (int m = i; m < A.length; m++) {
				R[p][1] = A[m][1];
				R[p][0] = A[m][0];
				count++;

			}
		}
		if (j < B.length) {
			for (int m = j; m < B.length; m++) {
				R[p][1] = B[m][1];
				R[p][0] = B[m][0];
				count++;
			}
		}
		int[][] result = new int[count][2];
		for (int m = 0; m < count; m++) {
			result[m][0] = R[m][0];
			result[m][1] = R[m][1];
			if (result[m][0] == 0) {
				result[m][1] = 0;
			}

		}
		return result;
	}

	public float eva (float value) {
		double R = 0;
		double v = value;
		Node i = head;
		if (size() == 0) {
			throw ex ;
		}
		for(int m = 0; m < size() ; m++){
			double exp = i.exponent;
			R = R + (i.coeff)*Math.pow(v,exp) ;
			i = i.next;
		}
		return (float)R;
	}

	public int[][] subtraction(int[][] A, int[][] B) {

		int R[][] = new int[100][2];
//		int x = A[0][1];
//		int y = B[0][1];
		int i = 0;
		int j = 0;
		int p = 0;
		int count = 0;
		int counter = 0;
		for (int k = 0; k < B.length; k++) {
			int negative = B[k][0];
			negative = negative * -1;
			B[k][0] = negative;
		}

		while (i < A.length && j < B.length) {
			if (A[i][1] > B[j][1]) {
				R[p][1] = A[i][1];
				R[p][0] = A[i][0];
				i++;
				p++;
				count++;
			} else if (A[i][1] < B[j][1]) {
				R[p][1] = B[j][1];
				R[p][0] = B[j][0];
				j++;
				p++;
				count++;
			} else if (A[i][1] == B[j][1]) {
				R[p][1] = A[i][1];
				R[p][0] = A[i][0] + B[j][0]; //// add
				i++;
				j++;
				p++;
				count++;
			} else {
				break;
			}
			counter++;
		}
		if (i < A.length) {
			for (int m = i; m < A.length; m++) {
				R[p][1] = A[m][1];
				R[p][0] = A[m][0];
				count++;
			}
		}
		if (j < B.length) {
			for (int m = j; m < B.length; m++) {
				R[p][1] = B[m][1];
				R[p][0] = B[m][0];
				count++;
			}
		}
		int[][] result = new int[count][2];
		for (int m = 0; m < count; m++) {

			result[m][0] = R[m][0];
			result[m][1] = R[m][1];
			if (result[m][0] == 0) {
				result[m][1] = 0;
			}
		}

		return result;

	}

	public int[][] multy(int[][] A, int[][] B) {
		if (A == null || B == null) {
			return null;
		}
		
		
		int max = A[0][1] + B[0][1];
		int arr[] = new int[max + 1];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				arr[A[i][1] + B[j][1]] += A[i][0] * B[j][0];
			}
		}
		int R[][] = new int[max + 1][2];
		int flage = 0;
		int y = max;
		for (int i = 0; i < max + 1; i++) {
			R[i][0] = arr[y];
			R[i][1] = y;
			y--;
			if (R[i][0] == 0) {
				flage++;
			}
		}
		int l = 0;
		int[][] R1 = new int[R.length - flage][2];
		for (int i = 0; i < R.length; i++) {
			if (R[i][0] == 0) {
				continue;
			}
			else {
				R1[l][0] = R[i][0];
				R1[l][1] = R[i][1];
				l++;
			}
		}
		int[][] R2 = new int[1][2];

		if (R1.length == 0) {
			return R2;
		}
		return R1;
	}

	public final void printMe() {
		Node i = head;
		System.out.print("poly = " + i.poly);
		System.out.println("  size = " + size());
		for (int k = 0; k < size(); k++) {
			System.out.print("coeff = " + i.coeff);
			System.out.println("  Exponent = " + i.exponent);
			i = i.next;
		}
	}

	public final int[][] array() {
		Node newNode = new Node();
		Node i = head;
		int count = 0;
		int[][] arr = new int[size()][2];
		while (i != null) {
			arr[count][0] = i.coeff;
			arr[count][1] = i.exponent;
			count++;
			i = i.next;
		}
		return arr;
	}

	public final void add1(final int index, final int Coeff, final int Exponent,char p) {
		Node newNode = new Node();
		Node i = head;
		newNode.poly = p;
		newNode.setCoeff(Coeff);
		newNode.setExponent(Exponent);
		if (index < 0 || index > size()) {
			throw ex;
		}

		if (index == 0) {
			newNode.next = head;
			head = newNode;
			return;
		}

		for (int count = 0; count <= index - 2; count++) {
			i = i.next;
		}

		newNode.next = i.next;
		i.next = newNode;
	}

	public int getMax() {
		Node i = head;
		return i.exponent;
	}

	public final String printPoly() {
		// head = null;
		Node i = head;
		String polynomial = "";
		boolean first = true;
		Node i1 = head;
		for (int k = 0; k < size() && i1.next != null; k++) {
			Node l = i1.next;

			if (i1.getExponent() <= l.getExponent()) {
				throw ex;
			}
			i1 = i1.next;

		}

		for (int k = 0; k < size(); k++) {
			if (i.getCoeff() != 0) {
				if (i.getCoeff() > 1 && first) {
					polynomial = polynomial
							.concat(String.valueOf(i.getCoeff()));
					first = !first;
				} else if (i.getCoeff() == 1 && first) {
					first = !first;
				} else if (i.getCoeff() > 1 && !first) {
					polynomial = polynomial.concat("+");
					polynomial = polynomial
							.concat(String.valueOf(i.getCoeff()));

				} else if (i.getCoeff() == -1 && first) {
					polynomial = polynomial.concat("-");
					first = !first;
				} else if (i.getCoeff() < -1) {
					polynomial = polynomial.concat("-");
					polynomial = polynomial
							.concat(String.valueOf(i.getCoeff()));
				} else if (i.getCoeff() == 1 && !first) {
					polynomial = polynomial.concat("+");

				}
				else if (i.getCoeff() == -1 && !first) {
					polynomial = polynomial.concat("-");
				}
				if (i.getExponent() != 0) {
					if (i.getExponent() == 1) {

						polynomial = polynomial.concat("x");
					} else {
						polynomial = polynomial.concat("x^");
						polynomial = polynomial
								.concat(String.valueOf(i.getExponent()));

					}

				} else if (i.getExponent() == 0 && i.getCoeff() == 1) {
					polynomial = polynomial.concat("1");

				} else if (i.getExponent() != 0 && i.getCoeff() == 1) {
					polynomial = polynomial.concat("");

				} else if (i.getExponent() == 0 && i.getCoeff() == -1) {
					polynomial = polynomial.concat("1");

				}

			}
			i = i.next;
		}
		polynomial = polynomial.replace("--", "-");
		polynomial = polynomial.replace("++", "+");
		if (polynomial == "") {
			return "0";
		}
		return polynomial;
	}

	public final char getPoly() {
		Node i = head;
		return i.getPoly();
	}

	/**
	 * Inserts a specified element at the specified position in the list.
	 * 
	 * @param index
	 *            the req index
	 * @param element
	 *            value of the node
	 */
	public final void add(final int index, final Object element) {
		Node newNode = new Node();
		Node i = head;
		// newNode.value = element;
		newNode.setValue(element);
		if (index < 0 || index > size()) {
			throw ex;
		}

		if (index == 0) {
			newNode.next = head;
			head = newNode;
			return;
		}

		for (int count = 0; count <= index - 2; count++) {
			i = i.next;
		}

		newNode.next = i.next;
		i.next = newNode;
	}

	/**
	 * Inserts the specified element at the end of the list.
	 * 
	 * @param element
	 *            value of the node
	 */
	public final void add(final Object element) {
		Node newNode = new Node();
		Node i = head;
		newNode.value = element;

		if (i == null) {
			head = newNode;
			return;
		}

		while (i.next != null) {
			i = i.next;

		}
		newNode.next = i.next;
		i.next = newNode;

	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 *            the position of the element in the list
	 * @return the object at this index
	 */
	public final Object get(final int index) {
		if (index < 0 || index >= size()) {
			throw ex;
		}

		Node i = head;
		for (int count = 0; count < index; count++) {
			i = i.next;
		}
		return i.value;
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 * 
	 * @param index
	 *            the req index
	 * @param element
	 *            the value of the node
	 */
	public final void set(final int index, final Object element) {
		Node newNode = new Node();
		newNode.value = element;
		if (index < 0 || index >= size()) {
			throw ex;
		}

		Node i = head;

		if (index == 0) {
			newNode.next = head;
			head = newNode;
			remove(index + 1);
			return;
		}
		for (int count = 0; count <= index - 2; count++) {
			i = i.next;
		}
		Node j = i.next;
		newNode.next = j.next;
		i.next = newNode;

	}

	/** Removes all of the elements from this list. */

	public final void clear() {
//		if (head == null) {
//			return;
//		}
		head = null;
	}

	/**
	 * Returns true if this list contains no elements.
	 * 
	 * @return true if this list contains no elements.
	 */
	public final boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;

	}

	/**
	 * Removes the element at the specified position in this list.
	 * 
	 * @param index
	 *            the req index
	 */
	public final void remove(final int index) {
		int s = size();
		if (index >= s || index < 0) {
			throw ex;
		}

		Node i = head;

		if (size() == 0) {
			return;
		}

		if (index == 0) {
			head = i.next;
			return;
		}

		for (int count = 0; count <= index - 2; count++) {
			i = i.next;
		}
		Node j = i.next;
		i.next = j.next;
	}

	/** @return the number of elements in this list. */
	public final int size() {
		Node i = head;
		if (i == null) {
			return 0;
		}

		int size = 0;
		while (i != null) {
			i = i.next;
			size++;
		}
		return size;
	}

	
	/**
	 * @return true if this list contains an element with the same value as the
	 *         specified element.
	 * @param o
	 *            the value of the node
	 */
	public final boolean contains(final Object o) {
		Node finger = head;
		while (finger != null && !finger.value.equals(o)) {
			finger = finger.next;
		}
		return (finger != null);
	}

}
