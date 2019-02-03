package Supermarket;

public class Node {
	private Node next;
	private Node previous;
	private Product productData;
	
	public Node(Product productData, Node next) {
		this.next = next;
		this.productData = productData;
	}
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	public Product getProductData() {
		return productData;
	}
	public void setProductData(Product productData) {
		this.productData = productData;
	}

}
