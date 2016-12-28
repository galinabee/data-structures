/**
 * This is the doubly linked list class
 * @author Galina Belolipetski
 * @version 12.20.16
 */
public class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Constructor
     */
    public DoublyLinkedList(){
        head = new Node<E>();
        tail = new Node<E>();
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }

    /**
     * Appending a node at the end
     * @param node the node to place at end
     * @return the node
     */
    public Node<E> append(Node<E> node){
        this.addToEnd(node);
        return node;
    }

    /**
     * Gets the size of the DLL
     *
     * @return the size
     */
    public int getSize(){
        return size;
    }

    /**
     * Adding a node to end
     * Similar to stack
     *
     * @param node the node to add
     * @return the node added
     */
    public Node<E> addToEnd(Node<E> node){
        Node<E> previous = tail.getPrevious();

        previous.setNext(node);
        node.setPrevious(previous);
        tail.setPrevious(node);
        node.setNext(tail);
        size++;

        return node;
    }

    /**
     * Adding a node to beginning
     * Similar to queue
     *
     * @param node the node to add
     * @return the node added
     */
    public Node<E> addToBeginning(Node<E> node){
        node.setNext(head.getNext());
        head.getNext().setPrevious(node);
        node.setPrevious(head);
        head.setNext(node);
        size++;
        return node;
    }

    /**
     * Removing a particular value
     * @param e the value to remove
     * @return the node that was removed or null
     */
    public Node<E> remove(E e)    {
        Node<E> current = head.getNext();
        while (current != tail) {
            if (current.getValue() == e) {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                current.setNext(null);
                current.setPrevious(null);
                size--;
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * Removing from a certain index
     * @param index the index from which to remove
     * @return the node that was removed
     */
    public Node<E> removeAtIndex(int index){
        if (index >= size){ return null; }
        Node<E> current;
        // 5 - 1 > 2 go from beginning
        if (size - index > size/2)  {
            current = head;
            for (int i = 0; i <= index; i++){
                current = current.getNext();
            }
        }   else    {
            current = tail;
            for (int i = size; i >= index; i--){
                current = current.getPrevious();
            }
        }
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        current.setNext(null);
        current.setPrevious(null);
        size--;
        return current;
    }

    /**
     * Creates an array of nodes
     *
     * @return the array of nodes
     */
    public Node<E>[] toArray(){
        Node<E>[] array = new Node[size];
        Node<E> current = head.getNext();
        for (int i = 0; i < size; i++){
            array[i] = current;
            current = current.getNext();
        }
        return array;
    }

    /**
     * Returns the first node that has the value
     * @param e the value to look for
     * @return the node or null
     */
    public Node<E> get(E e){
        Node<E> current = head.getNext();
        while (current != tail) {
            if (current.getValue() == e) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * Removes a particular found node
     * @param node the node address you want removed
     * @return true if found and removed, false if not
     */
    public boolean removeNode(Node<E> node){
        Node<E> current = head.getNext();
        while (current != tail) {
            if (current.equals(node)) {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                current.setNext(null);
                current.setPrevious(null);
                size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Gets the first node
     *
     * @return the first node or null if it is tail node
     */
    public Node<E> getFirst(){
        Node<E> toReturn = head.getNext();
        return toReturn == tail ? null: toReturn;
    }
    /**
     * Clears the DLL
     * @return true if cleared, false if it does not need to be cleared
     */
    public boolean clear(){
        if (head.getNext() == tail && tail.getPrevious() == head) return false;

        head.setNext(tail);
        tail.setPrevious(head);
        head.setPrevious(null);
        tail.setNext(null);
        size = 0;
        return head.getNext() == tail && tail.getPrevious() == head;
    }

    @Override
    public String toString(){
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