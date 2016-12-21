import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the doubly linked list test class
 */
public class DoublyLinkedListTest {
    DoublyLinkedList<Integer> dll;
    Node<Integer> n1;
    Node<Integer> n2;

    @Before
    public void setUp(){
        dll =  new DoublyLinkedList<>();
        n1 = new Node<>(1);
        n2 = new Node<>(2);
    }

    @Test
    public void testAddBeginning() {
        Node<Integer> check = dll.addToBeginning(n1);
        assertNull(check.getPrevious().getValue());
        assertNull(check.getNext().getValue());
        check = dll.addToBeginning(n2);
        assertNull(check.getPrevious().getValue());
        assertEquals(1, (int) check.getNext().getValue());
        assertEquals("{2 1}", dll.toString());
    }

    @Test
    public void testAddEnd(){
        Node<Integer> check = dll.addToEnd(n1);
        assertNull(check.getPrevious().getValue());
        assertNull(check.getNext().getValue());
        check = dll.addToEnd(n2);
        assertEquals(1, (int) check.getPrevious().getValue());
        assertNull(check.getNext().getValue());
        assertEquals("{1 2}", dll.toString());
    }

    @Test
    public void testRemove(){
        dll.addToBeginning(n1);
        dll.addToBeginning(n2);
        assertEquals(1, (int) dll.remove(1).getValue());
        assertEquals(2, (int) dll.remove(2).getValue());
    }
    @Test
    public void testToArray(){
        dll.addToEnd(n1);
        dll.addToEnd(n2);
        assertEquals("{1 2}", dll.toString());
        Node<Integer>[] array = dll.toArray();
        assertEquals(2, array.length);
        assertEquals(1, (int) array[0].getValue());
    }
}
