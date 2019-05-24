package area.converter.service;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import area.converter.service.AreaConverterService;

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

public class ConverterAreaWindow extends JDialog {

	private JPanel contentPane;
	private JButton btnConvert;
	private JTextField textField_1, textField_2;
	public String areaUnitType1, areaUnitType2;
	public double boxOneValue, boxTwoValue;
	public JComboBox convertersList_1, convertersList_2;
	AreaConverterService areaConverter;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterAreaWindow frame = new ConverterAreaWindow();
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
	public ConverterAreaWindow() {
		areaConverter = new AreaConverterServiceImpl();
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

		convertersList_1.addItem(" Square Feets");
		convertersList_2.addItem(" Square Feets");

		convertersList_1.addItem(" Square Meters");
		convertersList_2.addItem(" Square Meters");

		convertersList_1.addItem(" Acres");
		convertersList_2.addItem(" Acres");

		convertersList_1.addItem(" Hectares");
		convertersList_2.addItem(" Hectares");

		convertersList_1.addItem(" Square Kilometers");
		convertersList_2.addItem(" Square Kilometers");

		convertersList_1.addItem(" Square Miles");
		convertersList_2.addItem(" Square Miles");

		btnConvert = new JButton("Convert");
		btnConvert.setFocusable(false);
		btnConvert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConvert.setBounds(177, 245, 85, 30);
		contentPane.add(btnConvert);

		JLabel lblSpeedConverter = new JLabel("Area Converter");
		lblSpeedConverter.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblSpeedConverter.setBounds(147, 27, 176, 30);
		contentPane.add(lblSpeedConverter);

		btnConvert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				areaUnitType1 = String.valueOf(convertersList_1.getSelectedItem());
				areaUnitType2 = String.valueOf(convertersList_2.getSelectedItem());
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
					
					else if (areaUnitType1.equalsIgnoreCase(" Square Feets")) {

						if (areaUnitType2.equalsIgnoreCase(" Square Feets")) {
							boxTwoValue = areaConverter.SquareFeetsToSquareFeets(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Square Meters")) {
							boxTwoValue = areaConverter.SquareFeetsToSquareMeters(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Acres")) {
							boxTwoValue = areaConverter.SquareFeetsToAcres(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Hectares")) {
							boxTwoValue = areaConverter.SquareFeetsToHectares(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Square Kilometers")) {
							boxTwoValue = areaConverter.SquareFeetsToSquareKilometers(boxOneValue);

						} else if (areaUnitType2.equalsIgnoreCase(" Square Miles")) {
							boxTwoValue = areaConverter.SquareFeetsToSquareMiles(boxOneValue);
						}

					}

					else if (areaUnitType1.equalsIgnoreCase(" Square Meters")) {

						if (areaUnitType2.equalsIgnoreCase(" Square Feets")) {
							boxTwoValue = areaConverter.SquareMetersToSquareFeets(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Square Meters")) {
							boxTwoValue = areaConverter.SquareMetersToSquareMeters(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Acres")) {
							boxTwoValue = areaConverter.SquareMetersToAcres(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Hectares")) {
							boxTwoValue = areaConverter.SquareMetersToHectares(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Square Kilometers")) {
							boxTwoValue = areaConverter.SquareMetersToSquareKilometers(boxOneValue);

						} else if (areaUnitType2.equalsIgnoreCase(" Square Miles")) {
							boxTwoValue = areaConverter.SquareMetersToSquareMiles(boxOneValue);
						}

					}

					else if (areaUnitType1.equalsIgnoreCase(" Acres")) {

						if (areaUnitType2.equalsIgnoreCase(" Square Feets")) {
							boxTwoValue = areaConverter.AcresToSquareFeets(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Square Meters")) {
							boxTwoValue = areaConverter.AcresToSquareMeters(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Acres")) {
							boxTwoValue = areaConverter.AcresToAcres(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Hectares")) {
							boxTwoValue = areaConverter.AcresToHectares(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Square Kilometers")) {
							boxTwoValue = areaConverter.AcresToSquareKilometers(boxOneValue);

						} else if (areaUnitType2.equalsIgnoreCase(" Square Miles")) {
							boxTwoValue = areaConverter.AcresToSquareMiles(boxOneValue);
						}

					}

					else if (areaUnitType1.equalsIgnoreCase(" Hectares")) {

						if (areaUnitType2.equalsIgnoreCase(" Square Feets")) {
							boxTwoValue = areaConverter.HectaresToSquareFeets(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Square Meters")) {
							boxTwoValue = areaConverter.HectaresToSquareMeters(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Acres")) {
							boxTwoValue = areaConverter.HectaresToAcres(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Hectares")) {
							boxTwoValue = areaConverter.HectaresToHectares(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Square Kilometers")) {
							boxTwoValue = areaConverter.HectaresToSquareKilometers(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Square Miles")) {
							boxTwoValue = areaConverter.HectaresToSquareMiles(boxOneValue);
						}
					}

					else if (areaUnitType1.equalsIgnoreCase(" Square Kilometers")) {

						if (areaUnitType2.equalsIgnoreCase(" Square Feets")) {
							boxTwoValue = areaConverter.SquareKilometersToSquareFeets(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Square Meters")) {
							boxTwoValue = areaConverter.SquareKilometersToSquareMeters(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Acres")) {
							boxTwoValue = areaConverter.SquareKilometersToAcres(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Hectares")) {
							boxTwoValue = areaConverter.SquareKilometersToHectares(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Square Kilometers")) {
							boxTwoValue = areaConverter.SquareKilometersToSquareKilometers(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Square Miles")) {
							boxTwoValue = areaConverter.SquareKilometersToSquareMiles(boxOneValue);
						}
					}

					else if (areaUnitType1.equalsIgnoreCase(" Square Miles")) {

						if (areaUnitType2.equalsIgnoreCase(" Square Feets")) {
							boxTwoValue = areaConverter.SquareMilesToSquareFeets(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Square Meters")) {
							boxTwoValue = areaConverter.SquareMilesToSquareMeters(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Acres")) {
							boxTwoValue = areaConverter.SquareMilesToAcres(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Hectares")) {
							boxTwoValue = areaConverter.SquareMilesToHectares(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Square Kilometers")) {
							boxTwoValue = areaConverter.SquareMilesToSquareKilometers(boxOneValue);
						}
						else if (areaUnitType2.equalsIgnoreCase(" Square Miles")) {
							boxTwoValue = areaConverter.SquareMilesToSquareMiles(boxOneValue);
						}

					}

				}
				
				if (!fieldValue1.isEmpty() && fieldValue1.length() <= 10 ) {

					boxTwoValue = Math.round(boxTwoValue * 100) / 100.0;
					String fieldValue2 = String.valueOf(boxTwoValue);
					
					if (boxTwoValue == 0.0) {
						JOptionPane.showMessageDialog(null, "Input Value is Too Small", "Alert", JOptionPane.OK_OPTION);
						textField_2.setText(" ");
					}

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
