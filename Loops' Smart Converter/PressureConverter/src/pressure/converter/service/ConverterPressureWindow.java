package pressure.converter.service;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

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

public class ConverterPressureWindow extends JDialog {

	private JPanel contentPane;
	private JButton btnConvert;
	private JTextField textField_1, textField_2;
	private String pressureUnitType1, pressureUnitType2;
	private JComboBox convertersList_1, convertersList_2;
	private PressureConverterService pressureConvertor;
	private double boxOneValue, boxTwoValue;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterPressureWindow frame = new ConverterPressureWindow();
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public ConverterPressureWindow() {

		pressureConvertor = new PressureConverterServiceImpl();

		String pascal = " Pascal";
		String kilopascal = " Kilopascal";
		String bar = " Bar";
		String megapascal = " Megapascal";
		String centipascal = " Centipascal";
		String millipascal = " Millipascal";
		String atm = " ATM";

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

		convertersList_1.addItem(pascal);
		convertersList_2.addItem(pascal);

		convertersList_1.addItem(kilopascal);
		convertersList_2.addItem(kilopascal);

		convertersList_1.addItem(bar);
		convertersList_2.addItem(bar);

		convertersList_1.addItem(atm);
		convertersList_2.addItem(atm);

		convertersList_1.addItem(megapascal);
		convertersList_2.addItem(megapascal);

		convertersList_1.addItem(centipascal);
		convertersList_2.addItem(centipascal);

		convertersList_1.addItem(millipascal);
		convertersList_2.addItem(millipascal);

		btnConvert = new JButton("Convert");
		btnConvert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConvert.setBounds(177, 245, 85, 30);
		btnConvert.setFocusable(false);
		contentPane.add(btnConvert);

		JLabel lblPressureConverter = new JLabel("Pressure Converter");
		lblPressureConverter.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblPressureConverter.setBounds(127, 27, 230, 30);
		contentPane.add(lblPressureConverter);

		btnConvert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pressureUnitType1 = String.valueOf(convertersList_1.getSelectedItem());
				pressureUnitType2 = String.valueOf(convertersList_2.getSelectedItem());
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
					// methods from pascal to ...................
					else if (pressureUnitType1.equalsIgnoreCase(pascal)) {

						if (pressureUnitType2.equalsIgnoreCase(pascal)) {
							boxTwoValue = pressureConvertor.pascal_pascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(kilopascal)) {
							boxTwoValue = pressureConvertor.pascal_kiloPascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(bar)) {
							boxTwoValue = pressureConvertor.pascal_bar(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(atm)) {
							boxTwoValue = pressureConvertor.pascal_ATM(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(megapascal)) {
							boxTwoValue = pressureConvertor.pascal_megapascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(centipascal)) {
							boxTwoValue = pressureConvertor.pascal_centipascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(millipascal)) {
							boxTwoValue = pressureConvertor.pascal_millipascal(boxOneValue);
						}

					}
					// methods from kilopascal to ............
					else if (pressureUnitType1.equalsIgnoreCase(kilopascal)) {

						if (pressureUnitType2.equalsIgnoreCase(pascal)) {
							boxTwoValue = pressureConvertor.kilopascal_pascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(kilopascal)) {
							boxTwoValue = pressureConvertor.kilopascal_kiloPascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(bar)) {
							boxTwoValue = pressureConvertor.kilopascal_bar(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(atm)) {
							boxTwoValue = pressureConvertor.kilopascal_ATM(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(megapascal)) {
							boxTwoValue = pressureConvertor.kilopascal_megapascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(centipascal)) {
							boxTwoValue = pressureConvertor.kilopascal_centipascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(millipascal)) {
							boxTwoValue = pressureConvertor.kilopascal_millipascal(boxOneValue);
						}
					}
					// methods from bar to .....................
					else if (pressureUnitType1.equalsIgnoreCase(bar)) {

						if (pressureUnitType2.equalsIgnoreCase(pascal)) {
							boxTwoValue = pressureConvertor.bar_pascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(kilopascal)) {
							boxTwoValue = pressureConvertor.bar_kiloPascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(bar)) {
							boxTwoValue = pressureConvertor.bar_bar(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(atm)) {
							boxTwoValue = pressureConvertor.bar_ATM(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(megapascal)) {
							boxTwoValue = pressureConvertor.bar_megapascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(centipascal)) {
							boxTwoValue = pressureConvertor.bar_centipascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(millipascal)) {
							boxTwoValue = pressureConvertor.bar_millipascal(boxOneValue);
						}
					}
					// methods from bar to ..................
					else if (pressureUnitType1.equalsIgnoreCase(atm)) {

						if (pressureUnitType2.equalsIgnoreCase(pascal)) {
							boxTwoValue = pressureConvertor.ATM_pascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(kilopascal)) {
							boxTwoValue = pressureConvertor.ATM_kiloPascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(bar)) {
							boxTwoValue = pressureConvertor.ATM_bar(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(atm)) {
							boxTwoValue = pressureConvertor.ATM_ATM(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(megapascal)) {
							boxTwoValue = pressureConvertor.ATM_megapascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(centipascal)) {
							boxTwoValue = pressureConvertor.ATM_centipascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(millipascal)) {
							boxTwoValue = pressureConvertor.ATM_millipascal(boxOneValue);
						}
					}
					// methods from megapascal to .............
					else if (pressureUnitType1.equalsIgnoreCase(megapascal)) {

						if (pressureUnitType2.equalsIgnoreCase(pascal)) {
							boxTwoValue = pressureConvertor.megapascal_pascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(kilopascal)) {
							boxTwoValue = pressureConvertor.megapascal_kiloPascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(bar)) {
							boxTwoValue = pressureConvertor.megapascal_bar(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(atm)) {
							boxTwoValue = pressureConvertor.megapascal_ATM(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(megapascal)) {
							boxTwoValue = pressureConvertor.megapascal_megapascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(centipascal)) {
							boxTwoValue = pressureConvertor.megapascal_centipascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(millipascal)) {
							boxTwoValue = pressureConvertor.megapascal_millipascal(boxOneValue);
						}
					}
					// methods from centipascal to ................
					else if (pressureUnitType1.equalsIgnoreCase(centipascal)) {

						if (pressureUnitType2.equalsIgnoreCase(pascal)) {
							boxTwoValue = pressureConvertor.centipascal_pascal(boxOneValue);
							
						} else if (pressureUnitType2.equalsIgnoreCase(kilopascal)) {
							boxTwoValue = pressureConvertor.centipascal_kiloPascal(boxOneValue);
							
						} else if (pressureUnitType2.equalsIgnoreCase(bar)) {
							boxTwoValue = pressureConvertor.centipascal_bar(boxOneValue);
							
						} else if (pressureUnitType2.equalsIgnoreCase(atm)) {
							boxTwoValue = pressureConvertor.centipascal_ATM(boxOneValue);
							
						} else if (pressureUnitType2.equalsIgnoreCase(megapascal)) {
							boxTwoValue = pressureConvertor.centipascal_megapascal(boxOneValue);
							
						} else if (pressureUnitType2.equalsIgnoreCase(centipascal)) {
							boxTwoValue = pressureConvertor.centipascal_centipascal(boxOneValue);
							
						} else if (pressureUnitType2.equalsIgnoreCase(millipascal)) {
							boxTwoValue = pressureConvertor.centipascal_millipascal(boxOneValue);
						}
					}
					// methods from centipascal to .............
					else if (pressureUnitType1.equalsIgnoreCase(millipascal)) {

						if (pressureUnitType2.equalsIgnoreCase(pascal)) {
							boxTwoValue = pressureConvertor.millipascal_pascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(kilopascal)) {
							boxTwoValue = pressureConvertor.millipascal_kiloPascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(bar)) {
							boxTwoValue = pressureConvertor.millipascal_bar(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(atm)) {
							boxTwoValue = pressureConvertor.millipascal_ATM(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(megapascal)) {
							boxTwoValue = pressureConvertor.millipascal_megapascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(centipascal)) {
							boxTwoValue = pressureConvertor.millipascal_centipascal(boxOneValue);

						} else if (pressureUnitType2.equalsIgnoreCase(millipascal)) {
							boxTwoValue = pressureConvertor.millipascal_millipascal(boxOneValue);
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
