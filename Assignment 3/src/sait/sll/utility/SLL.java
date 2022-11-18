package sait.sll.utility;

public class SLL implements LinkedListADT  {

	private SLLNode head;
	private SLLNode tail;
	private int size;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		// Checks if the list is empty.
		return false;
	}

	@Override
	public void clear() {
		// Clear all items in the linked list.
		
	}

	@Override
	public void append(Object data) {
		// Append an item to the end of the linked list.
		SLLNode newNode = new SLLNode(data);
		if(head == null) {
			tail = head = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		} size++;
		
	}

	@Override
	public void prepend(Object data) {
		// Prepend an item to the beginning of the linked list.
		if(head == null) {
			append(data);
		} else {
			SLLNode newNode = new SLLNode(data);
			newNode.next = head;
			head = newNode;
			size++;
		}
	}

	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		// Insert an item at a specific index in the linked list.
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			prepend(data);
		} else if (index >= size) {
			append(data);
		} else {
			SLLNode current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			SLLNode temp = current.next;
			current.next = new SLLNode(data);
			(current.next) .next = temp;
			size++;
		}
	}

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		// Replace an item in the linked list.
		
	}

	@Override
	public int size() {
		// Get the number of items in the linked list.
		return 0;
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException {
		// Remove an item at an index in the linked list.
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
	}

	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		// Get an item at an index in the linked list.
		return null;
	}

	@Override
	public int indexOf(Object data) {
		// Get the index of an item in the linked list.
		return 0;
	}

	@Override
	public boolean contains(Object data) {
		// Check if linked list has an item.
		return false;
	}
	
	class SLLNode {
		Object data;
		SLLNode next;
		
		public SLLNode(Object data, SLLNode next) {
			this.data = data;
			this.next = next;
		}
		
		public SLLNode(Object data) {
			this.data = data;
		}
	}

}
