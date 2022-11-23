package sait.sll.utility;

public class Node {
 Object data;
 Node next;
 
 public Node(Object data, Node next) {
	 this.data =data;
	 this.next = next;
 }
 public Node(Object data) {
	 this.data = data;
 }
 public Object getData() {
	 return data;
 }
 
 public void setData(Object data) {
	 this.data = data;
 }
 public Node getNext() {
	return next;
 }
 public void setNext(Node next) {
	 this.next =next;
 }
}
