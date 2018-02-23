package maze;

/**
 * 
 * Node class.
 *
 */
public class Node {
	public Object element;
	/**
	 * Represents the next node.
	 */
    public Node next;
    /**
     * the value of the node.
     */
	public Object value;
	/**
	 * constructor.
	 */
	
	public int coeff;
	public int exponent;
	public char poly;
	public Object parent;
	public int xCoor, yCoor;
	
	/**
	 * @return the poly
	 */
	public char getPoly() {
		return poly;
	}

	/**
	 * @param poly the poly to set
	 */
	public void setPoly(char poly) {
		this.poly = poly;
	}

	/**
	 * @return the coeff
	 */
	public int getCoeff() {
		return coeff;
	}

	/**
	 * @param coeff the coeff to set
	 */
	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}

	/**
	 * @return the exponent
	 */
	public int getExponent() {
		return exponent;
	}

	/**
	 * @param exponent the exponent to set
	 */
	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

	public Node() {

	}
	
	/**
	 * Node constructor.
	 * @param n reference of the node
	 * @param v value of the node
	 */
	
	public Node(final Node n, final Object v) {
		this.next = n;
		this.value = v;
	}

	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	
	
}
