/**
 * Node class
 * 
 * @author Galina Belolipetski
 *
 * @param <E>
 *            some type parameter
 */
public class Node<E> implements Comparable<E> {
	private E value;
	private Node<E> next;
    private Node<E> previous;

    public Node(){};

	public Node(E val) {
		value = val;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E v) {
		value = v;
	}

	public void setNext(Node<E> n) {
		next = n;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setPrevious(Node<E> p){ previous = p; }

    public Node<E> getPrevious() { return previous; }

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if (this.getClass() != o.getClass())
			return 0;
		else {
			@SuppressWarnings("unchecked")
			Node<E> object = (Node<E>) o;
			if (object.getValue() == this.getValue()) {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this.getClass() != o.getClass()) {
			return false;
		}
		@SuppressWarnings("unchecked")
		Node<E> object = (Node<E>) o;
		if (object.getValue() == this.getValue()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString()	{
		StringBuilder str = new StringBuilder();
		str.append(this.getValue());
		return str.toString();
	}
}