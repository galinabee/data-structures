/**
 * Singly linked list class
 * 
 * @author Galina Belolipetski
 * @version 12.19.16
 */
public class SinglyLinkedList<E> {
	private int size;
	private Node<E> head = new Node<E>();
	private Node<E> tail;

    /**
     * Constructor for the SLL
     */
	public SinglyLinkedList() {
		size = 0;
		head.setNext(tail);
	}

	/**
	 * Location starts at 0
	 *
	 * @param node the node to add
	 * @return the node that was added
	 */
	public Node<E> add(Node<E> node) {
		Node<E> next = head;
		Node<E> previous = null;
        Node<E> nextPointer;
		while (next != tail) {
            nextPointer = next.getNext();
            if (nextPointer == tail){
                previous = next;
            }
			next = nextPointer;
		}
		previous.setNext(node);
		node.setNext(tail);
        size++;
		return node;
	}
	/**
	 * Removes a node
	 * @param node the node to remove
	 * @return true if removed, false if not
	 */
	public boolean remove(Node<E> node) {
        if (node == null){
            return false;
        }
        Node<E> current = head.getNext();
        Node<E> previous = head;
        while (current != tail) {
            if (current.getValue() == node.getValue()) {
                previous.setNext(current.getNext());
                current.setNext(null);
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
		return false;
	}
	/**
	 * Gets the size
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

    /**
     * Retrieves the node with the specific value
     * @param e the value to look for
     * @return the node, or null if doesn't exist
     */
	public Node<E> get(E e){
        Node<E> current = head.getNext();
        while (current != tail) {
            if (current.getValue().equals(e)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append('{');
		Node<E> start = head;
		while (start.getNext() != tail) {
			start = start.getNext();
            str.append(start.getValue());
            if (start.getNext() != tail){
                str.append(' ');
            }
		}
		str.append('}');
		return str.toString();
	}
}