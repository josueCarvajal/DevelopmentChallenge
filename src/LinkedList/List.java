package LinkedList;

import javax.swing.JOptionPane;

public class List {

	private Node start;
	private Node end;
	private static int j = 0;
	private static int listLenght = 0;

	public List() {
		this.start = null;
		this.end = null;
	}

	public boolean isEmpty() {
		if (this.start == null) {
			return true;
		} else {
			return false;
		}
	}

	public void addData(int data) {
		Node newNode = new Node(data, null);
		if (isEmpty()) {
			start = newNode;
			end = newNode;
		} else {
			end.setNext(newNode);// updating reference of the end node
			end = newNode;
		}
	}

	/*
	 * Shows the items in the list
	 */
	public void showList() {
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no items in the list");
			return;
		} else {
			moveList();
		}
	}

	/*
	 * Iterate throught all elements
	 */
	private void moveList() {
		Node temp = start;
		while (temp != null) {
			JOptionPane.showMessageDialog(null, temp.getData());
			temp = temp.getNext();
		}
	}

	/*
	 * Returns an element based on index. Starts at 0
	 */
	public void findValueAtIndexValue(int index) {
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no items in the list");
			return;
		} else {
			findIndex(index);
		}
	}

	/*
	 * Iterate throught all elements
	 */
	private void findIndex(int index) {
		Node temp = start;
		int counter = 0;
		while (temp != null) {
			if (counter == index) {
				JOptionPane.showMessageDialog(null, "The value at index:  " + counter + "  is:  " + temp.getData());
			}
			temp = temp.getNext();
			counter++;
		}
	}

	/*
	 * allows ONLY integers
	 */
	public boolean validateInputs(String inputData) {

		if (inputData != null & inputData != "") {
			if (inputData.matches("[0-9]+")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	private void dropList() {
		start = null;
		end = null;
	}

	public void sortElementsBubbleSort() {

		Node[] actualNodeArray = convertToArray(getListSize());
		Node aux;
		boolean cambio = false;
		while (true) {
			cambio = false;
			for (int i = 1; i < actualNodeArray.length; i++) {
				if (actualNodeArray[i].getData() < actualNodeArray[i - 1].getData()) {
					aux = actualNodeArray[i];
					actualNodeArray[i] = actualNodeArray[i - 1];
					actualNodeArray[i - 1] = aux;
					cambio = true;
				}
			}
			if (cambio == false)
				break;
		}
		dropList();
		for (int i = 0; i < actualNodeArray.length; i++) {
			addData(actualNodeArray[i].getData());
			System.out.println(actualNodeArray[i].getData());
		}
	}

	private Node[] convertToArray(int listSize) {// convert list to array to sort it
		Node[] array = new Node[listSize];
		Node actual = start;
		j = 0;
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay elementos");
			return null;
		} else {
			while (actual != null) {
				for (j = j; j < listSize; j++) {
					array[j] = actual;
					break;
				}
				actual = actual.getNext();
				j++;
			}
			return array;
		}
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

	public void deleteAnElement(int valueToDelete) {

		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no items in the list");
		} else {
			findElementToDelete(valueToDelete);
		}

	}

	private void findElementToDelete(int valueToDelete) {
		Node local = start;
		Node previous = null;

		while (local != null) {
			if (local.getData() == valueToDelete) {
				// as first element
				if (local == start) {

					if (local.getNext() != null) {// not the only element at the list

						start = start.getNext();
						JOptionPane.showMessageDialog(null, "Element deleted");
						return;

					} else {
						start = null;
						JOptionPane.showMessageDialog(null, "Element deleted");
						return;
					}

				}
				// at the middle
				if (local != start && local.getNext() != null) {
					previous.setNext(local.getNext());
					JOptionPane.showMessageDialog(null, "Element deleted");
					return;
				}
				// at the end
				if (local != start && local.getNext() == null) {
					previous.setNext(null);
					JOptionPane.showMessageDialog(null, "Element deleted");
					return;
				}
			} // end if
			previous = local;
			local = local.getNext();
		} // end while

		JOptionPane.showMessageDialog(null, "Element not finded");

	}

}
