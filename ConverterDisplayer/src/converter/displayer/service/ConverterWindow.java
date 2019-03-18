package converter.displayer.service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * @author PraveenKumar
 *
 */
public class ConverterWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	public static JComboBox convertersListBox, convertersList_1, convertersList_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterWindow frame = new ConverterWindow();
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
	public ConverterWindow() {
		setTitle("Unit Converter");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		textField_1.setBounds(32, 83, 170, 91);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(238, 83, 170, 91);
		contentPane.add(textField_2);

		convertersListBox = new JComboBox();
		convertersListBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		convertersListBox.setForeground(Color.BLACK);
		convertersListBox.setBounds(32, 23, 376, 36);
		contentPane.add(convertersListBox);

		JLabel label = new JLabel("=");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(212, 116, 28, 13);
		contentPane.add(label);

		convertersList_1 = new JComboBox();
		convertersList_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		convertersList_1.setBounds(32, 192, 170, 30);
		contentPane.add(convertersList_1);

		convertersList_2 = new JComboBox();
		convertersList_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		convertersList_2.setBounds(238, 192, 170, 30);
		contentPane.add(convertersList_2);
	}
}
