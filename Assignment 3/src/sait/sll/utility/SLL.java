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
		 head=tail=null;
			size=0;
		
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
		if(index <0 || index >size) {
			throw new IndexOutOfBoundsException();
		}
		// Set current node to head
				SLLNode currentNode = head;
				int currentIndex = 0;

				while (currentNode != null && currentIndex < index) {
					currentIndex++;
					currentNode = currentNode.getNext();
				}

				currentNode.setData(data);
			}

	}

	@Override
	public int size() {
		// Get the number of items in the linked list.
		return size;
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException {
		// Remove an item at an index in the linked list.
		
		
	}

	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		// Get an item at an index in the linked list.
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
			SLLNode currentNode = head;

			// Loop until we reach to the node at index or node that is null.
			for (int currentIndex = 0; currentIndex < index && currentNode != null; currentIndex++) {
				currentNode = currentNode.getNext();
			}

			return currentNode.getData();
		}
	}

	@Override
	public int indexOf(Object data) {
		// GSLLNode current = head;
		int index = 0;
		SLLNode currentNode = head;

		while (currentNode != null) {
			// If current node value contains matching object -> return the index.
			if (currentNode.getData().equals(data))
				return index;

			index++;
			currentNode = currentNode.getNext();
		}

		// If we looped through all the nodes, nothing was found, so return -1.
		return -1;
	}

	@Override
	public boolean contains(Object data) {
		// Check if linked list has an item.
		int index = indexOf(data);
		return index >= 0 ? true : false;

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
