package length.converter.service;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import length.converter.service.ConverterLengthWindow;
import length.converter.service.LengthConverterService;
import length.converter.service.LengthConverterServiceImpl;

public class ConverterLengthWindow extends JDialog {

	private JPanel contentPane;
	private JButton btnConvert;
	private JTextField textField_1, textField_2;
	public String lengthUnitType1, lengthUnitType2;
	public double boxOneValue, boxTwoValue;
	public JComboBox convertersList_1, convertersList_2;
	LengthConverterService massConverter;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterLengthWindow frame = new ConverterLengthWindow();
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
	public ConverterLengthWindow() {
		massConverter = new LengthConverterServiceImpl();
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

		convertersList_1.addItem(" Meter");
		convertersList_2.addItem(" Meter");

		convertersList_1.addItem(" Kilometer");
		convertersList_2.addItem(" Kilometer");

		convertersList_1.addItem(" Centimeter");
		convertersList_2.addItem(" Centimeter");

		convertersList_1.addItem(" Millimeter");
		convertersList_2.addItem(" Millimeter");

		convertersList_1.addItem(" Inch");
		convertersList_2.addItem(" Inch");

		btnConvert = new JButton("Convert");
		btnConvert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConvert.setBounds(177, 245, 85, 30);
		btnConvert.setFocusable(false);
		contentPane.add(btnConvert);

		JLabel lblLengthConverter = new JLabel("Length Converter");
		lblLengthConverter.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblLengthConverter.setBounds(138, 27, 185, 30);
		contentPane.add(lblLengthConverter);

		btnConvert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lengthUnitType1 = String.valueOf(convertersList_1.getSelectedItem());
				lengthUnitType2 = String.valueOf(convertersList_2.getSelectedItem());
				String fieldValue1 = textField_1.getText();

				String PATTERN = "^[+]?([0-9]*[.])?[0-9]+$";
				Pattern pat = Pattern.compile(PATTERN);
				Matcher match = pat.matcher(fieldValue1);

				boolean result = !match.matches();

				if (fieldValue1.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert",
							JOptionPane.OK_OPTION);

				} else if (result) {
					JOptionPane.showMessageDialog(null, "Input Valid Numbers Only ", "Alert", JOptionPane.OK_OPTION);

				} else if (fieldValue1.length() > 10) {
					JOptionPane.showMessageDialog(null, "Input Value is Too High");
					textField_2.setText(" ");

				} else {

					boxOneValue = Double.parseDouble(textField_1.getText());

					if (boxOneValue == 0.0) {
						JOptionPane.showMessageDialog(null, "Input Value is Too Small");
						textField_2.setText(" ");
					}

					// Meter
					else if (lengthUnitType1.equalsIgnoreCase(" Meter")) {

						if (lengthUnitType2.equalsIgnoreCase(" Meter")) {
							boxTwoValue = massConverter.MeterToMeter(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" KiloMeter")) {
							boxTwoValue = massConverter.MeterToKilometer(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Centimeter")) {
							boxTwoValue = massConverter.MeterToCentimeter(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Millimeter")) {
							boxTwoValue = massConverter.MeterToMillimeter(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Inch")) {
							boxTwoValue = massConverter.MeterToInch(boxOneValue);

						}

					}

					// Kilometer

					else if (lengthUnitType1.equalsIgnoreCase(" KiloMeter")) {

						if (lengthUnitType2.equalsIgnoreCase(" KiloMeter")) {
							boxTwoValue = massConverter.KilometerToKilometer(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Meter")) {
							boxTwoValue = massConverter.KilometerToMeter(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Centimeter")) {
							boxTwoValue = massConverter.KilometerToCentimeter(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Millimeter")) {
							boxTwoValue = massConverter.KilometerToMillimeter(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Inch")) {
							boxTwoValue = massConverter.KilometerToInch(boxOneValue);

						}

					}

					// Centimeter

					else if (lengthUnitType1.equalsIgnoreCase(" Centimeter")) {

						if (lengthUnitType2.equalsIgnoreCase(" Centimeter")) {
							boxTwoValue = massConverter.CentimeterToCentimeter(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Meter")) {
							boxTwoValue = massConverter.CentimeterToMeter(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Kilometer")) {
							boxTwoValue = massConverter.CentimeterToKilometer(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Millimeter")) {
							boxTwoValue = massConverter.CentimeterToMillimeter(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Inch")) {
							boxTwoValue = massConverter.CentimeterToInch(boxOneValue);

						}

					}

					// Millimeter

					else if (lengthUnitType1.equalsIgnoreCase(" Millimeter")) {

						if (lengthUnitType2.equalsIgnoreCase(" Millimeter")) {
							boxTwoValue = massConverter.MillimeterToMillimeter(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Meter")) {
							boxTwoValue = massConverter.MillimeterToMeter(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Kilometer")) {
							boxTwoValue = massConverter.MillimeterToKilometer(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Centimeter")) {
							boxTwoValue = massConverter.MillimeterToCentimeter(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Inch")) {
							boxTwoValue = massConverter.MillimeterToInch(boxOneValue);

						}

					}

					// Inch

					else if (lengthUnitType1.equalsIgnoreCase(" Inch")) {

						if (lengthUnitType2.equalsIgnoreCase(" Inch")) {
							boxTwoValue = massConverter.InchToInch(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Meter")) {
							boxTwoValue = massConverter.InchToMeter(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Kilometer")) {
							boxTwoValue = massConverter.InchToKilometer(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Centimeter")) {
							boxTwoValue = massConverter.InchToCentimeter(boxOneValue);
						}

						else if (lengthUnitType2.equalsIgnoreCase(" Millimeter")) {
							boxTwoValue = massConverter.InchToMillimeter(boxOneValue);

						}

					}

				}

				if (!fieldValue1.isEmpty()) {

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
