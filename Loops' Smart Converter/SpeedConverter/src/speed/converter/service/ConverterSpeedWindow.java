package speed.converter.service;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import speed.converter.service.SpeedConverterService;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author PraveenKumar
 *
 */
public class ConverterSpeedWindow extends JDialog {

	private JPanel contentPane;
	private JButton btnConvert;
	private JTextField textField_1, textField_2;
	private String speedUnitType1, speedUnitType2;
	private JComboBox convertersList_1, convertersList_2;
	private SpeedConverterService speedConverter;
	private double boxOneValue, boxTwoValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterSpeedWindow frame = new ConverterSpeedWindow();
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
	public ConverterSpeedWindow() {
		speedConverter = new SpeedConverterServiceImpl();
		setResizable(false);
		setTitle("Unit Converter");
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

		convertersList_1.addItem(" Meter Per Second");
		convertersList_2.addItem(" Meter Per Second");

		convertersList_1.addItem(" Foot Per Second");
		convertersList_2.addItem(" Foot Per Second");

		convertersList_1.addItem(" Km Per Hour");
		convertersList_2.addItem(" Km Per Hour");

		convertersList_1.addItem(" Miles Per Hour");
		convertersList_2.addItem(" Miles Per Hour");

		convertersList_1.addItem(" Knot");
		convertersList_2.addItem(" Knot");

		btnConvert = new JButton("Convert");
		btnConvert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConvert.setBounds(177, 245, 85, 30);
		btnConvert.setFocusable(false);
		contentPane.add(btnConvert);

		JLabel lblSpeedConverter = new JLabel("Speed Converter");
		lblSpeedConverter.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblSpeedConverter.setBounds(147, 27, 176, 30);
		contentPane.add(lblSpeedConverter);

		btnConvert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				speedUnitType1 = String.valueOf(convertersList_1.getSelectedItem());
				speedUnitType2 = String.valueOf(convertersList_2.getSelectedItem());
				String fieldValue1 = textField_1.getText();

				// textfield validation + get boxTwo Value 
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

					// meter conversion
					else if (speedUnitType1.equalsIgnoreCase(" Meter Per Second")) {

						if (speedUnitType2.equalsIgnoreCase(" Meter Per Second")) {
							boxTwoValue = speedConverter.MeterPerSecondToMeterPerSecond(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Foot Per Second")) {
							boxTwoValue = speedConverter.MeterPerSecondToFootPerSecond(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Km Per Hour")) {
							boxTwoValue = speedConverter.MeterPerSecondToKmPerHour(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Miles Per Hour")) {
							boxTwoValue = speedConverter.MeterPerSecondToMilesPerHour(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Knot")) {
							boxTwoValue = speedConverter.MeterPerSecondToKnot(boxOneValue);
						}

					}

					// foot conversion
					else if (speedUnitType1.equalsIgnoreCase(" Foot Per Second")) {

						if (speedUnitType2.equalsIgnoreCase(" Foot Per Second")) {
							boxTwoValue = speedConverter.FootPerSecondToFootPerSecond(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Meter Per Second")) {
							boxTwoValue = speedConverter.FootPerSecondToMeterPerSecond(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Km Per Hour")) {
							boxTwoValue = speedConverter.FootPerSecondToKmPerHour(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Miles Per Hour")) {
							boxTwoValue = speedConverter.FootPerSecondToMilesPerHour(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Knot")) {
							boxTwoValue = speedConverter.FootPerSecondToKnot(boxOneValue);
						}

					}

					// km conversion
					else if (speedUnitType1.equalsIgnoreCase(" Km Per Hour")) {

						if (speedUnitType2.equalsIgnoreCase(" Km Per Hour")) {
							boxTwoValue = speedConverter.KmPerHourToKmPerHour(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Meter Per Second")) {
							boxTwoValue = speedConverter.KmPerHourToMeterPerSecond(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Foot Per Second")) {
							boxTwoValue = speedConverter.KmPerHourToFootPerSecond(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Miles Per Hour")) {
							boxTwoValue = speedConverter.KmPerHourToMilesPerHour(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Knot")) {
							boxTwoValue = speedConverter.KmPerHourToKnot(boxOneValue);

						}

					}

					// mile conversion
					else if (speedUnitType1.equalsIgnoreCase(" Miles Per Hour")) {

						if (speedUnitType2.equalsIgnoreCase(" Miles Per Hour")) {
							boxTwoValue = speedConverter.MilesPerHourToMilesPerHour(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Meter Per Second")) {
							boxTwoValue = speedConverter.MilesPerHourToMeterPerSecond(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Foot Per Second")) {
							boxTwoValue = speedConverter.MilesPerHourToFootPerSecond(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Km Per Hour")) {
							boxTwoValue = speedConverter.MilesPerHourToKmPerHour(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Knot")) {
							boxTwoValue = speedConverter.MilesPerHourToKnot(boxOneValue);
						}

					}
					// knot conversion
					else if (speedUnitType1.equalsIgnoreCase(" Knot")) {

						if (speedUnitType2.equalsIgnoreCase(" Knot")) {
							boxTwoValue = speedConverter.KnotToKnot(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Meter Per Second")) {
							boxTwoValue = speedConverter.KnotToMeterPerSecond(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Foot Per Second")) {
							boxTwoValue = speedConverter.KnotToFootPerSecond(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Km Per Hour")) {
							boxTwoValue = speedConverter.KnotToKmPerHour(boxOneValue);

						} else if (speedUnitType2.equalsIgnoreCase(" Miles Per Hour")) {
							boxTwoValue = speedConverter.KnotToMilesPerHour(boxOneValue);
						}

					}

					// modify digit value
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
			}
		});
	}

}
