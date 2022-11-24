package sait.sll.utility;

import java.io.*;

public class SLL implements LinkedListADT, Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 775642735338034468L;
	private Node head;
	private Node tail;
	private int size;
	
	public static void main(String[] args) {
	}

	@Override
	public boolean isEmpty() {
		// Checks if the list is empty.
		if (tail == null && head == null) {
			return true;
		} else {
			return false;
		}
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
		Node newNode = new Node(data);
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
			Node newNode = new Node(data);
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
			Node current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			Node temp = current.next;
			current.next = new Node(data);
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
		Node currentNode = head;
		int currentIndex = 0;

		while (currentNode != null && currentIndex < index) {
			currentIndex++;
			currentNode = currentNode.getNext();
		}

		currentNode.setData(data);
	}

	@Override
	public int size() {
		// Get the number of items in the linked list.
		return size;
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException {
		// Remove an item at an index in the linked list.
		// Throw IndexOutOfBoundsException if index is negative or index is greater than
				// the size - 1.
				if (index < 0 || index > size() - 1)
					throw new IndexOutOfBoundsException();

				Node prevNode = head;
				int currentIndex = 0;
				Node nodeToDelete;

				// If index to delete from is 0
				if (index == 0) {
					// Get the existing node at head.
					nodeToDelete = head;

					// Set head to node after head
					this.head = head.getNext();

					// Set node next of head to null.
					nodeToDelete.setNext(null);
				} else {
					// Otherwise, loop until we reach to node at index - 1.
					while (prevNode != null && currentIndex < index - 1) {
						prevNode = prevNode.getNext();
						currentIndex++;
					}
					// prevNode is before the one to delete.
					// nodeToDelete is the node being deleted.
					nodeToDelete = prevNode.getNext();

					// Set next of prevNode to node after the next one (at index + 1)
					prevNode.setNext(nodeToDelete.getNext());

					// Set next of nodeToDelete to null.
					nodeToDelete.setNext(null);
				}

				// Decrement the size
				size--;
			}

		
	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		// Get an item at an index in the linked list.
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		Node currentNode = head;
		// Loop until we reach to the node at index or node that is null.
		for (int currentIndex = 0; currentIndex < index && currentNode != null; currentIndex++) {
			currentNode = currentNode.getNext();
		}

		return currentNode.getData();
	}

	@Override
	public int indexOf(Object data) {
		// GSLLNode current = head;
		int index = 0;
		Node currentNode = head;

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
}
