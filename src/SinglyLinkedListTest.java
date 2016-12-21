import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the singly linked list test class
 * 
 * @author Galina Belolipetski
 * @version 12.19.2016
 *
 */
public class SinglyLinkedListTest {
	private SinglyLinkedList<Integer> sll;
    private Node<Integer> n1;
    private Node<Integer> n2;

	@Before
	public void setUp() {
        sll = new SinglyLinkedList<Integer>();
        n1 = new Node<Integer>(1);
        n2 = new Node<Integer>(2);
	}

	@Test
	public void testAddRemoveGet(){
        assertEquals("{}", sll.toString());
        sll.add(n1);
        assertEquals("{1}", sll.toString());
        sll.add(n2);
        assertEquals("{1 2}", sll.toString());
        assertEquals(2, (int)sll.get(2).getValue());
        assertNull(sll.get(3));
        assertEquals(2, sll.getSize());
        assertTrue(sll.remove(new Node<Integer>(2)));
        assertEquals(1, sll.getSize());
        assertFalse(sll.remove(new Node<Integer>(3)));
        assertEquals(1, sll.getSize());
        assertTrue(sll.remove(new Node<Integer>(1)));
        assertEquals(0, sll.getSize());
        assertFalse(sll.remove(new Node<Integer>(3)));
        assertEquals(0, sll.getSize());
	}
}