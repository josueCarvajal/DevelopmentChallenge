package LinkedList;

public class Node {
	private Node next;
	private Node previous;
	private int data;
	
	public Node(int data, Node next) {
		this.next = next;
		this.data = data;
	}
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	@Override
	public String toString() {
		return "Data saved: " + getData();
	}
}
