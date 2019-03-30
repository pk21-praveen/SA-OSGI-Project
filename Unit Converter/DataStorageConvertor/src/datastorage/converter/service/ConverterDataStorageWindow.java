package datastorage.converter.service;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import datastorage.converter.service.DataStorageConverterService;

/*import pressure.Convertor.Service.ConvertorPressureWindow;
import pressure.Convertor.Service.PressureConvertorService;
import pressure.Convertor.Service.PressureConvertorServiceImpl;
*/
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;

public class ConverterDataStorageWindow extends JDialog {

	private JPanel contentPane;
	private JButton btnConvert;
	private JTextField textField_1, textField_2;
	private String dataStorageUnitType1, dataStorageUnitType2;
	private double boxOneValue, boxTwoValue;
	private JComboBox<String> convertersList_1, convertersList_2;
	private DataStorageConverterService dataStorageConvertor;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterDataStorageWindow frame = new ConverterDataStorageWindow();
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public ConverterDataStorageWindow() {

		dataStorageConvertor = new DataStorageConverterServiceImpl();

		String bit = " Bit";
		String bytes = " Byte";
		String kilobyte = " Kilobyte";
		String megabyte = " Megabyte";
		String gigabyte = " Gigabyte";
		String terabyte = " TeraByte";
		String petabyte = " Petabyte";

		setResizable(false);
		setTitle("Unit Converter");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		setLocationRelativeTo(null);
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
		textField_2.setEditable(false);
		textField_2.setBackground(Color.WHITE);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(238, 83, 170, 91);
		contentPane.add(textField_2);

		JLabel label = new JLabel("=");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(212, 116, 28, 13);
		contentPane.add(label);

		convertersList_1 = new JComboBox();
		convertersList_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		convertersList_1.setBounds(32, 192, 170, 30);
		contentPane.add(convertersList_1);

		convertersList_2 = new JComboBox();
		convertersList_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		convertersList_2.setBounds(238, 192, 170, 30);
		contentPane.add(convertersList_2);

		convertersList_1.addItem(bit);
		convertersList_2.addItem(bit);

		convertersList_1.addItem(bytes);
		convertersList_2.addItem(bytes);

		convertersList_1.addItem(kilobyte);
		convertersList_2.addItem(kilobyte);

		convertersList_1.addItem(megabyte);
		convertersList_2.addItem(megabyte);

		convertersList_1.addItem(gigabyte);
		convertersList_2.addItem(gigabyte);

		convertersList_1.addItem(terabyte);
		convertersList_2.addItem(terabyte);

		convertersList_1.addItem(petabyte);
		convertersList_2.addItem(petabyte);

		btnConvert = new JButton("Convert");
		btnConvert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConvert.setBounds(177, 245, 85, 30);
		btnConvert.setFocusable(false);
		contentPane.add(btnConvert);

		JLabel lblSpeedConverter = new JLabel("DataStorage Converter");
		lblSpeedConverter.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblSpeedConverter.setBounds(106, 27, 238, 30);
		contentPane.add(lblSpeedConverter);

		btnConvert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dataStorageUnitType1 = String.valueOf(convertersList_1.getSelectedItem());
				dataStorageUnitType2 = String.valueOf(convertersList_2.getSelectedItem());
				String fieldValue1 = textField_1.getText();

				String PATTERN = "^[+]?([0-9]*[.])?[0-9]+$";
				Pattern pat = Pattern.compile(PATTERN);
				Matcher match = pat.matcher(fieldValue1);

				boolean result = !match.matches();

				if (fieldValue1.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert", JOptionPane.OK_OPTION);

				} else if (result) {
					JOptionPane.showMessageDialog(null, "Input Valid Numbers Only ", "Alert", JOptionPane.OK_OPTION);

				} else if (fieldValue1.length() > 10) {
					JOptionPane.showMessageDialog(null, "Input Value is Too High", "Alert", JOptionPane.OK_OPTION);
					textField_2.setText(" ");

				} else {
					
					boxOneValue = Double.parseDouble(textField_1.getText());

					if (boxOneValue == 0.0) {
						JOptionPane.showMessageDialog(null, "Input Value is Too Small", "Alert", JOptionPane.OK_OPTION);
						textField_2.setText(" ");
					}

					// methods from bit to ...................
					else if (dataStorageUnitType1.equalsIgnoreCase(bit)) {

						if (dataStorageUnitType2.equalsIgnoreCase(bit)) {
							boxTwoValue = dataStorageConvertor.bit_bit(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(bytes)) {
							boxTwoValue = dataStorageConvertor.bit_byte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(kilobyte)) {
							boxTwoValue = dataStorageConvertor.bit_kilobyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(megabyte)) {
							boxTwoValue = dataStorageConvertor.bit_megabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(gigabyte)) {
							boxTwoValue = dataStorageConvertor.bit_gigabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(terabyte)) {
							boxTwoValue = dataStorageConvertor.bit_terabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(petabyte)) {
							boxTwoValue = dataStorageConvertor.bit_petabyte(boxOneValue);
						}
					}
					// methods from byte to..........................
					else if (dataStorageUnitType1.equalsIgnoreCase(bytes)) {

						if (dataStorageUnitType2.equalsIgnoreCase(bit)) {
							boxTwoValue = dataStorageConvertor.byte_bit(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(bytes)) {
							boxTwoValue = dataStorageConvertor.byte_byte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(kilobyte)) {
							boxTwoValue = dataStorageConvertor.byte_kilobyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(megabyte)) {
							boxTwoValue = dataStorageConvertor.byte_megabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(gigabyte)) {
							boxTwoValue = dataStorageConvertor.byte_gigabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(terabyte)) {
							boxTwoValue = dataStorageConvertor.byte_terabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(petabyte)) {
							boxTwoValue = dataStorageConvertor.byte_petabyte(boxOneValue);
						}
					}
					// methods from kilobytes to ......................
					else if (dataStorageUnitType1.equalsIgnoreCase(kilobyte)) {

						if (dataStorageUnitType2.equalsIgnoreCase(bit)) {
							boxTwoValue = dataStorageConvertor.kilobyte_bit(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(bytes)) {
							boxTwoValue = dataStorageConvertor.kilobyte_byte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(kilobyte)) {
							boxTwoValue = dataStorageConvertor.kilobyte_kilobyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(megabyte)) {
							boxTwoValue = dataStorageConvertor.kilobyte_megabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(gigabyte)) {
							boxTwoValue = dataStorageConvertor.kilobyte_gigabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(terabyte)) {
							boxTwoValue = dataStorageConvertor.kilobyte_terabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(petabyte)) {
							boxTwoValue = dataStorageConvertor.kilobyte_petabyte(boxOneValue);
						}
					}
					// methods from megabytes to .................
					else if (dataStorageUnitType1.equalsIgnoreCase(megabyte)) {

						if (dataStorageUnitType2.equalsIgnoreCase(bit)) {
							boxTwoValue = dataStorageConvertor.megabyte_bit(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(bytes)) {
							boxTwoValue = dataStorageConvertor.megabyte_byte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(kilobyte)) {
							boxTwoValue = dataStorageConvertor.megabyte_kilobyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(megabyte)) {
							boxTwoValue = dataStorageConvertor.megabyte_megabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(gigabyte)) {
							boxTwoValue = dataStorageConvertor.megabyte_gigabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(terabyte)) {
							boxTwoValue = dataStorageConvertor.megabyte_terabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(petabyte)) {
							boxTwoValue = dataStorageConvertor.megabyte_petabyte(boxOneValue);
						}
					}
					// methods from gigabytes to ..................
					else if (dataStorageUnitType1.equalsIgnoreCase(gigabyte)) {

						if (dataStorageUnitType2.equalsIgnoreCase(bit)) {
							boxTwoValue = dataStorageConvertor.gigabyte_bit(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(bytes)) {
							boxTwoValue = dataStorageConvertor.gigabyte_byte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(kilobyte)) {
							boxTwoValue = dataStorageConvertor.gigabyte_kilobyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(megabyte)) {
							boxTwoValue = dataStorageConvertor.gigabyte_megabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(gigabyte)) {
							boxTwoValue = dataStorageConvertor.gigabyte_gigabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(terabyte)) {
							boxTwoValue = dataStorageConvertor.gigabyte_terabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(petabyte)) {
							boxTwoValue = dataStorageConvertor.gigabyte_petabyte(boxOneValue);
						}
					}
					// methods from terabyte to ..................
					else if (dataStorageUnitType1.equalsIgnoreCase(terabyte)) {

						if (dataStorageUnitType2.equalsIgnoreCase(bit)) {
							boxTwoValue = dataStorageConvertor.terabyte_bit(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(bytes)) {
							boxTwoValue = dataStorageConvertor.terabyte_byte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(kilobyte)) {
							boxTwoValue = dataStorageConvertor.terabyte_kilobyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(megabyte)) {
							boxTwoValue = dataStorageConvertor.terabyte_megabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(gigabyte)) {
							boxTwoValue = dataStorageConvertor.terabyte_gigabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(terabyte)) {
							boxTwoValue = dataStorageConvertor.terabyte_terabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(petabyte)) {
							boxTwoValue = dataStorageConvertor.terabyte_petabyte(boxOneValue);
						}
					}
					// methods from petabytes to ........................
					else if (dataStorageUnitType1.equalsIgnoreCase(petabyte)) {

						if (dataStorageUnitType2.equalsIgnoreCase(bit)) {
							boxTwoValue = dataStorageConvertor.petabyte_bit(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(bytes)) {
							boxTwoValue = dataStorageConvertor.petabyte_byte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(kilobyte)) {
							boxTwoValue = dataStorageConvertor.petabyte_kilobyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(megabyte)) {
							boxTwoValue = dataStorageConvertor.petabyte_megabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(gigabyte)) {
							boxTwoValue = dataStorageConvertor.petabyte_gigabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(terabyte)) {
							boxTwoValue = dataStorageConvertor.petabyte_terabyte(boxOneValue);

						} else if (dataStorageUnitType2.equalsIgnoreCase(petabyte)) {
							boxTwoValue = dataStorageConvertor.petabyte_petabyte(boxOneValue);
						}
					}
				}
				
				if (!fieldValue1.isEmpty() && fieldValue1.length() <= 10 ) {

					boxTwoValue = Math.round(boxTwoValue * 100) / 100.0;
					String fieldValue2 = String.valueOf(boxTwoValue);

					if (fieldValue2.length() <= 10) {
						DecimalFormat df = new DecimalFormat("#.##");
						textField_2.setText(df.format(boxTwoValue));

					} else if (fieldValue2.length() > 10) {
						DecimalFormat df = new DecimalFormat("#.##E0");
						df.setMaximumFractionDigits(2);
						textField_2.setText(df.format(boxTwoValue));
					}
				}
			}
		});
	}
}
