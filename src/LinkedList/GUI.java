package LinkedList;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private JTextField txtNewElement;
	private JButton btnAddElement;
	private JButton btnListElements;
	private List linkedList;
	private JLabel lblFindI;
	private JTextField txtFindValue;
	private JButton btnFindAtIndex;
	private JLabel lblDeleteData;
	private JTextField txtDeleteElement;
	private JButton btnDeleteAnElement;
	private JButton btnSortElements;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		linkedList = new List();
		buttonActions();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 349, 277);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblLinkedList = new JLabel("LINKED LIST");
		lblLinkedList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLinkedList.setBounds(101, 11, 90, 14);
		frame.getContentPane().add(lblLinkedList);

		JLabel lblAddNew = new JLabel("Data:");
		lblAddNew.setBounds(10, 43, 100, 14);
		frame.getContentPane().add(lblAddNew);

		txtNewElement = new JTextField();
		txtNewElement.setToolTipText("Enter the data that you need to save");
		txtNewElement.setBounds(53, 40, 144, 20);
		frame.getContentPane().add(txtNewElement);
		txtNewElement.setColumns(10);

		btnAddElement = new JButton("Add element");

		btnAddElement.setBounds(206, 39, 121, 23);
		frame.getContentPane().add(btnAddElement);

		btnListElements = new JButton("List elements");

		btnListElements.setBounds(206, 123, 121, 23);
		frame.getContentPane().add(btnListElements);

		lblFindI = new JLabel("Find i:");
		lblFindI.setBounds(10, 71, 46, 14);
		frame.getContentPane().add(lblFindI);

		txtFindValue = new JTextField();
		txtFindValue.setToolTipText("0 initial index");
		txtFindValue.setBounds(53, 68, 144, 20);
		frame.getContentPane().add(txtFindValue);
		txtFindValue.setColumns(10);

		btnFindAtIndex = new JButton("Find at Index");

		btnFindAtIndex.setBounds(206, 66, 121, 23);
		frame.getContentPane().add(btnFindAtIndex);

		lblDeleteData = new JLabel("Delete element");
		lblDeleteData.setBounds(10, 100, 100, 14);
		frame.getContentPane().add(lblDeleteData);

		txtDeleteElement = new JTextField();
		txtDeleteElement.setBounds(107, 97, 90, 20);
		frame.getContentPane().add(txtDeleteElement);
		txtDeleteElement.setColumns(10);

		btnDeleteAnElement = new JButton("Delete element");
		btnDeleteAnElement.setBounds(206, 96, 121, 23);
		frame.getContentPane().add(btnDeleteAnElement);

		btnSortElements = new JButton("Sort Elements");
		btnSortElements.setBounds(206, 152, 121, 23);
		frame.getContentPane().add(btnSortElements);
	}

	private void buttonActions() {
		btnAddElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data = txtNewElement.getText();
				if (linkedList.validateInputs(data)) {
					linkedList.addData(Integer.parseInt(data));
					txtNewElement.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "The field does not allow blank data or non integer values");
				}
			}
		});

		btnListElements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				linkedList.showList();
			}
		});

		btnFindAtIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String index = txtFindValue.getText();
				if (linkedList.validateInputs(index)) {
					linkedList.findValueAtIndexValue(Integer.parseInt(index));
					txtNewElement.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "The field does not allow blank data or non integer values");
				}

			}
		});

		btnDeleteAnElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valueToDelete = txtDeleteElement.getText();
				linkedList.deleteAnElement(Integer.parseInt(valueToDelete));
			}
		});

		btnSortElements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				linkedList.sortElementsBubbleSort();
				
			}
		});
	}
}
