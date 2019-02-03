package Supermarket;

import java.text.DecimalFormat;

import javax.swing.table.DefaultTableModel;

public class List {
	private Node start;
	private Node end;
	private static int listLenght = 0;

	public List() {
		this.start = null;
		this.end = null;
	}

	public void generateProducts() {
		int productListItems = randomNumbers(1, 8);
		int productCuantity = 0;
		double productPrice = 0;
		for (int i = 1; i <= productListItems; i++) {
			productCuantity = randomNumbers(1, 8);
			productPrice = randomPrice(1.000, 10.000);
			addData(new Product("product" + i, productPrice, productCuantity));
		}
	}

	/*
	 * Iterate throught all elements
	 */
	public void checkout(DefaultTableModel model) {
		DecimalFormat df = new DecimalFormat("####0.00");
		String productName;
		String total;
		String productPrice;
		int cuantity;
		double totalCheckout = 0;
		Node temp = start;
		while (temp != null) {
			Product product = temp.getProductData();
			productName = product.getProductName();
			productPrice = df.format(product.getPrice());
			cuantity = product.getProductCuantity();
			total = df.format(cuantity*Double.parseDouble(productPrice));
			totalCheckout=totalCheckout+(product.getProductCuantity()* product.getPrice());
			model.addRow(new Object[] {productName,cuantity, "$"+productPrice, "$"+ total});
			temp = temp.getNext();
			
		}
		model.addRow(new Object[] {"Total Checkout","","", "$"+df.format(totalCheckout)});
	}

	private int getListSize() {
		Node actual = start;
		listLenght = 0;
		if (isEmpty()) {
			return 0;
		} else {
			while (actual != null) {
				listLenght++;
				actual = actual.getNext();
			}
			return listLenght;
		}

	}

	private void addData(Product product) {
		Node newNode = new Node(product, null);
		if (isEmpty()) {
			start = newNode;
			end = newNode;
		} else {
			end.setNext(newNode);// updating reference of the end node
			end = newNode;
		}
	}

	private int randomNumbers(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

	private double randomPrice(double min, double max) {
		double range = (max - min) + 1;
		return (double) (Math.random() * range) + min;
	}

	private boolean isEmpty() {
		if (this.start == null) {
			return true;
		} else {
			return false;
		}
	}

}
