package Supermarket;

public class Product {
	private String productName;
	private double price;
	private int productCuantity;
	private double total;
	public Product(String productName, double price, int productCuantity) {
		this.productName = productName;
		this.price = price;
		this.productCuantity = productCuantity;
		this.total = productCuantity*price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getProductCuantity() {
		return productCuantity;
	}

	public void setProductCuantity(int productCuantity) {
		this.productCuantity = productCuantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}
