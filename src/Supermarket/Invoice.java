package Supermarket;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Invoice extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable invoiceTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice frame = new Invoice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Invoice() {
		List productList = new List();
		productList.generateProducts();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 239);
		contentPane.add(scrollPane);


		invoiceTable = new JTable();
		invoiceTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "PRODUCT NAME", "CUANTITY", "PRICE", "TOTAL" }));
		DefaultTableModel model = (DefaultTableModel) invoiceTable.getModel();
		productList.checkout(model);
		scrollPane.setViewportView(invoiceTable);

	}
}
