package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import sait.sll.utility.*;


/**
 * @author Nick Hamnett
 * @author Maryam Moussavi
 * @version 2020-03-24
 *
 */
class LinkedListTests {
	/**
	 * Contains the linked list that is manipulated in each test.
	 */
	private LinkedListADT linkedList;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// Create your concrete linked list class and assign to to linkedList.
		this.linkedList = new SLL();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		this.linkedList.clear();
	}

	/**
	 * Test the linked list is empty.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(this.linkedList.isEmpty());
		assertEquals(0, this.linkedList.size());
		assertNotEquals(1, this.linkedList.size());
		
		linkedList.append("A");
		assertFalse(this.linkedList.isEmpty());
	}
	
	/**
	 * Test a non-empty linked list is empty.
	 */
	@Test
	void testIsEmptyNotEmpty() {
		linkedList.append("A");
		linkedList.append("B");
		linkedList.append("C");
		assertFalse(this.linkedList.isEmpty());
//		assertEquals(0, this.linkedList.size()); PK - to be deleted
		// PK - need to add a test for when the link is not empty
	}
	
	/**
	 * Tests appending elements to the linked list.
	 */
	@Test
	void testAppendNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the third node value is c
		assertEquals("c", this.linkedList.retrieve(2));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(3));
	}

	/**
	 * Tests prepending nodes to linked list.
	 */
	@Test
	void testPrependNodes() {
		this.linkedList.prepend("a");
		this.linkedList.prepend("b");
		this.linkedList.prepend("c");
		this.linkedList.prepend("d");
		
		/**
		 * Linked list should now be:
		 * 
		 * d -> c -> b -> a
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("d", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("c", this.linkedList.retrieve(1));
		
		// Test the third node value is c
		assertEquals("b", this.linkedList.retrieve(2));
		
		// Test the fourth node value is d
		assertEquals("a", this.linkedList.retrieve(3));
	}
	
	/**
	 * Tests inserting node at valid index.
	 */
	@Test
	void testInsertNodeOutofBound() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.insert("e", 2);
		//If the index < 0 || index > size, throws IndexOutOfoundsException
				assertThrows(IndexOutOfBoundsException.class, () -> this.linkedList.insert("e", -1));
				assertThrows(IndexOutOfBoundsException.class, () -> this.linkedList.insert("e", 5));
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> e -> c -> d
		 */
	
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		assertNotEquals(6, this.linkedList.size());
		
		// Test the size is 4
		assertEquals(5, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the third node value is e
		assertEquals("e", this.linkedList.retrieve(2));
		
		// Test the third node value is c
		assertEquals("c", this.linkedList.retrieve(3));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(4));
		
		assertNotEquals("z", this.linkedList.retrieve(4));
	}
	
	/**
	 * Tests replacing existing nodes data.
	 */
	@Test
	void testReplaceNodeOutOfBound() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.replace("e", 2);
		
		//If the index < 0 || index > size, throws IndexOutOfoundsException
				assertThrows(IndexOutOfBoundsException.class, () -> this.linkedList.replace("e", -1));
				assertThrows(IndexOutOfBoundsException.class, () -> this.linkedList.replace("e", 5));
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> e -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the third node value is e
		assertEquals("e", this.linkedList.retrieve(2));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(3));
		
		assertFalse(this.linkedList.contains("c"));
		assertTrue(this.linkedList.contains("e"));
		assertNotEquals("c", this.linkedList.retrieve(2));
	}
	
	/**
	 * Tests deleting node from linked list.
	 */
	@Test
	void testDeleteNodeOutOfBound() {//**
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.delete(2);
		
		//If the index < 0 || index > size, throws IndexOutOfoundsException
				assertThrows(IndexOutOfBoundsException.class, () -> this.linkedList.delete( -1));
				assertThrows(IndexOutOfBoundsException.class, () -> this.linkedList.delete( 5));
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(3, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(2));
		
		assertFalse(this.linkedList.contains("c"));
	}
	
	/**
	 * Tests finding and retrieving node in linked list.
	 */
	@Test
	void testFindNodeOutOfBound() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */
		
		boolean contains = this.linkedList.contains("b");
		assertTrue(contains);
		
		int index = this.linkedList.indexOf("b");
		assertEquals(1, index);
		
		String value = (String) this.linkedList.retrieve(1);
		assertEquals("b", value);
		
		assertFalse(this.linkedList.contains("z"));
	}
	
	@Test
	void testSize() {
		assertEquals(0, this.linkedList.size());
		assertTrue(this.linkedList.isEmpty());
		
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());
	}
	
	@Test
	void testClear() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.clear();
		
		assertEquals(0, this.linkedList.size());
		assertFalse(this.linkedList.contains("a"));
		assertTrue(this.linkedList.isEmpty());
	}
	
	@Test
	void testIndexOf() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		assertEquals(1, this.linkedList.indexOf("b"));
		assertEquals(3, this.linkedList.indexOf("d"));
		assertNotEquals(3, this.linkedList.indexOf("z"));
	}
	
	@Test
	void testContains() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		boolean contains = this.linkedList.contains("b");
		assertTrue(contains);
		assertFalse(this.linkedList.contains("z"));
		
		this.linkedList.append(null);
		
		assertNull(this.linkedList.retrieve(4));
		assertNotNull(this.linkedList.retrieve(1));
	}
}
