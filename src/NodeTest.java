import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class NodeTest {
	private Node<Integer> node;
	
	@Before
	public void setUp() {
		node = new Node<Integer>(new Integer(3));
	}

	@Test
	public void testMethods() {
		node.setValue(4);
		node.setNext(new Node<Integer>(new Integer(2)));
		assertEquals(4, (int) node.getValue());
		assertEquals(2, (int) node.getNext().getValue());
		assertEquals("4", node.toString());
        assertTrue(node.equals(node));
        assertEquals(0, node.compareTo(node.getNext()));
        assertEquals(1, node.compareTo(node));
	}
}
