package mass.converter.service;

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

import mass.converter.service.ConverterMassWindow;
import mass.converter.service.MassConverterService;
import mass.converter.service.MassConverterServiceImpl;

public class ConverterMassWindow extends JDialog {

	private JPanel contentPane;
	private JButton btnConvert;
	private JTextField textField_1, textField_2;
	public String massUnitType1, massUnitType2;
	public double boxOneValue, boxTwoValue;
	public JComboBox convertersList_1, convertersList_2;
	MassConverterService massConverter;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterMassWindow frame = new ConverterMassWindow();
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
	public ConverterMassWindow() {
		massConverter = new MassConverterServiceImpl();
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

		convertersList_1.addItem(" Gram");
		convertersList_2.addItem(" Gram");

		convertersList_1.addItem(" Kilogram");
		convertersList_2.addItem(" Kilogram");

		convertersList_1.addItem(" Milligram");
		convertersList_2.addItem(" Milligram");

		convertersList_1.addItem(" Metricton");
		convertersList_2.addItem(" Metricton");

		convertersList_1.addItem(" Pound");
		convertersList_2.addItem(" Pound");

		btnConvert = new JButton("Convert");
		btnConvert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConvert.setBounds(177, 245, 85, 30);
		btnConvert.setFocusable(false);
		contentPane.add(btnConvert);

		JLabel lblMassConverter = new JLabel("Mass Converter");
		lblMassConverter.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblMassConverter.setBounds(147, 27, 176, 30);
		contentPane.add(lblMassConverter);

		btnConvert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				massUnitType1 = String.valueOf(convertersList_1.getSelectedItem());
				massUnitType2 = String.valueOf(convertersList_2.getSelectedItem());
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
					JOptionPane.showMessageDialog(null, "Input Value is Too High", "Alert", JOptionPane.OK_OPTION);
					textField_2.setText(" ");

				} else {

					boxOneValue = Double.parseDouble(textField_1.getText());

					if (boxOneValue == 0.0) {
						JOptionPane.showMessageDialog(null, "Input Value is Too Small", "Alert", JOptionPane.OK_OPTION);
						textField_2.setText(" ");
					}
					// Gram
					else if (massUnitType1.equalsIgnoreCase(" Gram")) {

						if (massUnitType2.equalsIgnoreCase(" Gram")) {
							boxTwoValue = massConverter.GramToGram(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Kilogram")) {
							boxTwoValue = massConverter.GramToKilogram(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Milligram")) {
							boxTwoValue = massConverter.GramToMilligram(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Metricton")) {
							boxTwoValue = massConverter.GramToMetricton(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Pound")) {
							boxTwoValue = massConverter.GramToPound(boxOneValue);

						}

					}

					// Kilogram

					else if (massUnitType1.equalsIgnoreCase(" Kilogram")) {

						if (massUnitType2.equalsIgnoreCase(" Kilogram")) {
							boxTwoValue = massConverter.KilogramToKilogram(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Gram")) {
							boxTwoValue = massConverter.KilogramToGram(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Milligram")) {
							boxTwoValue = massConverter.KilogramToMilligram(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Metricton")) {
							boxTwoValue = massConverter.KilogramToMetricton(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Pound")) {
							boxTwoValue = massConverter.KilogramToPound(boxOneValue);

						}

					}

					// Milligram

					else if (massUnitType1.equalsIgnoreCase(" Milligram")) {

						if (massUnitType2.equalsIgnoreCase(" Milligram")) {
							boxTwoValue = massConverter.MilligramToMilligram(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Gram")) {
							boxTwoValue = massConverter.MilligramToGram(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Kilogram")) {
							boxTwoValue = massConverter.MilligramToKilogram(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Metricton")) {
							boxTwoValue = massConverter.MilligramToMetricton(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Pound")) {
							boxTwoValue = massConverter.MilligramToPound(boxOneValue);

						}

					}

					// Metricton

					else if (massUnitType1.equalsIgnoreCase(" Metricton")) {

						if (massUnitType2.equalsIgnoreCase(" Metricton")) {
							boxTwoValue = massConverter.MetrictonToMetricton(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Gram")) {
							boxTwoValue = massConverter.MetrictonToGram(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Kilogram")) {
							boxTwoValue = massConverter.MetrictonToKilogram(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Milligram")) {
							boxTwoValue = massConverter.MetrictonToMilligram(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Pound")) {
							boxTwoValue = massConverter.MetrictonToPound(boxOneValue);

						}

					}

					// Pound

					else if (massUnitType1.equalsIgnoreCase(" Pound")) {

						if (massUnitType2.equalsIgnoreCase(" Pound")) {
							boxTwoValue = massConverter.PoundToPound(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Gram")) {
							boxTwoValue = massConverter.PoundToGram(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Kilogram")) {
							boxTwoValue = massConverter.PoundToKilogram(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Milligram")) {
							boxTwoValue = massConverter.PoundToMilligram(boxOneValue);
						}

						else if (massUnitType2.equalsIgnoreCase(" Metricton")) {
							boxTwoValue = massConverter.PoundToMetricton(boxOneValue);

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
