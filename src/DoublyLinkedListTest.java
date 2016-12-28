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
        Node<Integer> check1 = dll.addToBeginning(n1);
        assertNull(check1.getPrevious().getValue());
        assertNull(check1.getNext().getValue());

        Node<Integer> check2 = dll.addToBeginning(n2);
        assertNull(check2.getPrevious().getValue());
        assertEquals(check2, check1.getPrevious());
        assertEquals(check1, check2.getNext());
        assertEquals(1, (int) check2.getNext().getValue());
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
        Node<Integer> n3 = new Node<Integer>(3);
        check = dll.addToEnd(n3);
        assertEquals(null, check.getNext().getValue());
        assertEquals("{1 2 3}", dll.toString());
    }

    @Test
    public void testRemove(){
        dll.addToBeginning(n1);
        dll.addToBeginning(n2);
        assertEquals(1, (int) dll.remove(1).getValue());
        assertEquals(2, (int) dll.remove(2).getValue());
        assertNull(dll.remove(2));
    }
    @Test
    public void testToArrayAppend(){
        dll.append(n1);
        dll.append(n2);
        assertEquals("{1 2}", dll.toString());
        Node<Integer>[] array = dll.toArray();
        assertEquals(2, array.length);
        assertEquals(1, (int) array[0].getValue());
    }

    @Test
    public void testClear(){
        assertFalse(dll.clear());
        dll.addToBeginning(n1);
        dll.addToBeginning(n2);
        assertTrue(dll.clear());
    }

    @Test
    public void testGetFirst(){
        assertNull(dll.getFirst());
        dll.append(n1);
        dll.append(n2);
        assertEquals(1, (int) dll.getFirst().getValue());
    }

    @Test
    public void testGetRemoveNode(){
        assertNull(dll.get(3));
        dll.append(n1);
        dll.append(n2);
        assertNull(dll.get(3));
        assertNotNull(dll.get(2));

        Node<Integer> toRemove = dll.get(2);
        assertTrue(dll.removeNode(toRemove));
        assertFalse(dll.removeNode(toRemove));
    }
    @Test
    public void testRemoveIndex()   {
        assertNull(dll.removeAtIndex(1));
        assertNull(dll.removeAtIndex(0));
        dll.append(n1);
        dll.append(n2);
        assertEquals("{1 2}", dll.toString());
        assertEquals(1, (int) dll.removeAtIndex(0).getValue());
        assertEquals("{2}", dll.toString());
    }

    @Test
    public void testToString(){
        dll.append(n1);
        assertEquals("{1}", dll.toString());
        dll.append(n2);
        assertEquals("{1 2}", dll.toString());
        Node<Integer> n3 = new Node<Integer>(3);
        dll.append(n3);
        assertEquals("{1 2 3}", dll.toString());
    }
}
