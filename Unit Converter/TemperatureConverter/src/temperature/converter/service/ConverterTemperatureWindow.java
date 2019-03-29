package temperature.converter.service;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;

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

/**
 * @author PraveenKumar
 *
 */
public class ConverterTemperatureWindow extends JDialog {

	private JPanel contentPane;
	private JButton btnConvert;
	private JTextField textField_1, textField_2;
	public String tempUnitType1, tempUnitType2;
	public JComboBox convertersList_1, convertersList_2;
	private TemperatureConverterService tempConverter;
	public double boxOneValue, boxTwoValue;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterTemperatureWindow frame = new ConverterTemperatureWindow();
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
	public ConverterTemperatureWindow() {
		tempConverter = new TemperatureConverterServiceImpl();
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
		textField_1.setColumns(10);
		contentPane.add(textField_1);

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

		convertersList_1.addItem(" Celsius");
		convertersList_2.addItem(" Celsius");

		convertersList_1.addItem(" Fahrenheit");
		convertersList_2.addItem(" Fahrenheit");

		convertersList_1.addItem(" Kelvin");
		convertersList_2.addItem(" Kelvin");

		btnConvert = new JButton("Convert");
		btnConvert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConvert.setBounds(177, 245, 85, 30);
		btnConvert.setFocusable(false);
		contentPane.add(btnConvert);

		JLabel lblTempConverter = new JLabel("Temperature Converter");
		lblTempConverter.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTempConverter.setBounds(106, 27, 260, 30);
		contentPane.add(lblTempConverter);

		btnConvert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tempUnitType1 = String.valueOf(convertersList_1.getSelectedItem());
				tempUnitType2 = String.valueOf(convertersList_2.getSelectedItem());
				String fieldValue1 = textField_1.getText();

				// textfield validation + get boxTwo Value
				String PATTERN = "^[+-]?([0-9]*[.])?[0-9]+$";
				Pattern pat = Pattern.compile(PATTERN);
				Matcher match = pat.matcher(fieldValue1);

				boolean result = !match.matches();

				if (fieldValue1.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert", JOptionPane.OK_OPTION);

				} else if (result) {
					JOptionPane.showMessageDialog(null, "Input Valid Numbers Only ", "Alert", JOptionPane.OK_OPTION);

				} else if (fieldValue1.length() > 10) {
					JOptionPane.showMessageDialog(null, "Input Value is Too High");
					textField_2.setText(" ");

				} else {
					boxOneValue = Double.parseDouble(textField_1.getText());

					// celsius conversion
					if (tempUnitType1.equalsIgnoreCase(" Celsius")) {

						if (tempUnitType2.equalsIgnoreCase(" Celsius")) {
							boxTwoValue = tempConverter.CelsiusToCelsius(boxOneValue);

						} else if (tempUnitType2.equalsIgnoreCase(" Fahrenheit")) {
							boxTwoValue = tempConverter.CelsiusToFahrenheit(boxOneValue);

						} else if (tempUnitType2.equalsIgnoreCase(" Kelvin")) {
							boxTwoValue = tempConverter.CelsiusToKelvin(boxOneValue);
						}

					}

					// fahrenheit conversion
					else if (tempUnitType1.equalsIgnoreCase(" Fahrenheit")) {

						if (tempUnitType2.equalsIgnoreCase(" Fahrenheit")) {
							boxTwoValue = tempConverter.FahrenheitToFahrenheit(boxOneValue);

						} else if (tempUnitType2.equalsIgnoreCase(" Celsius")) {
							boxTwoValue = tempConverter.FahrenheitToCelsius(boxOneValue);

						} else if (tempUnitType2.equalsIgnoreCase(" Kelvin")) {
							boxTwoValue = tempConverter.FahrenheitToKelvin(boxOneValue);
						}

					}

					// kelvin conversion
					else if (tempUnitType1.equalsIgnoreCase(" Kelvin")) {

						if (tempUnitType2.equalsIgnoreCase(" Kelvin")) {
							boxTwoValue = tempConverter.KelvinToKelvin(boxOneValue);

						} else if (tempUnitType2.equalsIgnoreCase(" Celsius")) {
							boxTwoValue = tempConverter.KelvinToCelsius(boxOneValue);

						} else if (tempUnitType2.equalsIgnoreCase(" Fahrenheit")) {
							boxTwoValue = tempConverter.KelvinToFahrenheit(boxOneValue);
						}

					}
				}

				// modify digit value
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
