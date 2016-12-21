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
     * Adding a node to end
     * Similar to stack
     *
     * @param node the node to add
     * @return the node added
     */
    public Node<E> addToEnd(Node<E> node){
        node.setNext(tail);
        node.setPrevious(tail.getPrevious());
        tail.getPrevious().setNext(node);
        tail.setPrevious(node);
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
     * @param e
     * @return
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

    public Node<E>[] toArray(){
        Node<E>[] array = new Node[size];
        Node<E> current = head.getNext();
        for (int i = 0; i < size; i++){
            array[i] = current;
            current = current.getNext();
        }
        return array;
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