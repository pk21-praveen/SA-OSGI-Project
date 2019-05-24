package travel.estimator.service;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;

/**
 * @author PraveenKumar
 *
 */
public class EstimatorTravelWindow extends JDialog {

	private JPanel contentPane;
	private JButton btnEstimate, btnClear;
	public JComboBox comboBoxSpeed, comboBoxTime, comboBoxDistance, comboBoxChooser;
	private JLabel lblTravelEstimater, lblChoose, lblDistance, lblSpeed, lblDuration, lblAnswser;
	private JTextField textSpeed, textTime, textAnswer, textDistance;
	private TravelEstimatorService estimaterService;
	private String chooseValue = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstimatorTravelWindow frame = new EstimatorTravelWindow();
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
	public EstimatorTravelWindow() {
		estimaterService = new TravelEstimatorServiceImpl();
		setResizable(false);
		setTitle("Travel Estimater");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 603, 420);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTravelEstimater = new JLabel("Travel Estimator");
		lblTravelEstimater.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTravelEstimater.setBounds(230, 15, 176, 30);
		contentPane.add(lblTravelEstimater);

		lblChoose = new JLabel("Choose a Calculation :-");
		lblChoose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChoose.setBounds(26, 60, 170, 28);
		contentPane.add(lblChoose);

		lblDistance = new JLabel("Distance    =");
		lblDistance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDistance.setBounds(96, 123, 100, 15);
		contentPane.add(lblDistance);

		lblSpeed = new JLabel("Speed       =");
		lblSpeed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSpeed.setBounds(96, 171, 100, 20);
		contentPane.add(lblSpeed);

		lblDuration = new JLabel("Time         =");
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDuration.setBounds(96, 220, 100, 20);
		contentPane.add(lblDuration);

		textSpeed = new JTextField();
		textSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		textSpeed.setFont(new Font("Tahoma", Font.BOLD, 20));
		textSpeed.setColumns(10);
		textSpeed.setBounds(217, 166, 170, 30);
		contentPane.add(textSpeed);

		textTime = new JTextField();
		textTime.setHorizontalAlignment(SwingConstants.CENTER);
		textTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		textTime.setColumns(10);
		textTime.setBounds(217, 214, 170, 30);
		contentPane.add(textTime);

		textAnswer = new JTextField();
		textAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		textAnswer.setFont(new Font("Tahoma", Font.BOLD, 24));
		textAnswer.setColumns(10);
		textAnswer.setBounds(217, 309, 350, 50);
		contentPane.add(textAnswer);

		textDistance = new JTextField();
		textDistance.setHorizontalAlignment(SwingConstants.CENTER);
		textDistance.setFont(new Font("Tahoma", Font.BOLD, 20));
		textDistance.setColumns(10);
		textDistance.setBounds(217, 115, 170, 30);
		contentPane.add(textDistance);

		comboBoxSpeed = new JComboBox();
		comboBoxSpeed.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxSpeed.setBounds(397, 166, 170, 30);
		comboBoxSpeed.addItem("Meter Per Second (m/s)");
		comboBoxSpeed.addItem("Km Per Hour (kph)");
		comboBoxSpeed.addItem("Mile Per Hour (mph)");
		contentPane.add(comboBoxSpeed);

		comboBoxTime = new JComboBox();
		comboBoxTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxTime.setBounds(397, 214, 170, 30);
		comboBoxTime.addItem(" Seconds");
		comboBoxTime.addItem(" Minutes");
		comboBoxTime.addItem(" Hour");
		contentPane.add(comboBoxTime);

		comboBoxChooser = new JComboBox();
		comboBoxChooser.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBoxChooser.setBounds(217, 60, 350, 30);
		comboBoxChooser.addItem("--Choose a Method of Calculation--");
		comboBoxChooser.addItem(" Distance");
		comboBoxChooser.addItem(" Speed");
		comboBoxChooser.addItem(" Time");
		contentPane.add(comboBoxChooser);

		comboBoxChooser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String calType = String.valueOf(comboBoxChooser.getSelectedItem());

				if (calType.equalsIgnoreCase("--Choose a Method of Calculation--")) {
					chooseValue = "--Choose a Method of Calculation--";

				} else if (calType.equalsIgnoreCase(" Distance")) {
					chooseValue = " Distance";
					textTime.setEditable(true);
					textSpeed.setEditable(true);
					textDistance.setEditable(false);

				} else if (calType.equalsIgnoreCase(" Speed")) {
					chooseValue = " Speed";
					textTime.setEditable(true);
					textSpeed.setEditable(false);
					textDistance.setEditable(true);

				} else if (calType.equalsIgnoreCase(" Time")) {
					chooseValue = " Time";
					textTime.setEditable(false);
					textSpeed.setEditable(true);
					textDistance.setEditable(true);
				}

			}
		});

		comboBoxDistance = new JComboBox();
		comboBoxDistance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxDistance.setBounds(397, 115, 170, 30);
		comboBoxDistance.addItem(" Meter");
		comboBoxDistance.addItem(" Kilometer");
		comboBoxDistance.addItem(" Mile");
		contentPane.add(comboBoxDistance);

		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.setBounds(431, 264, 92, 30);
		btnClear.setFocusable(false);
		contentPane.add(btnClear);

		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textAnswer.setText("");
				textSpeed.setText("");
				textDistance.setText("");
				textTime.setText("");

				textTime.setEditable(true);
				textSpeed.setEditable(true);
				textDistance.setEditable(true);

				comboBoxSpeed.setEnabled(true);
				comboBoxTime.setEnabled(true);
				comboBoxDistance.setEnabled(true);

				comboBoxChooser.setSelectedIndex(0);

			}
		});

		btnEstimate = new JButton(" Estimate");
		btnEstimate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEstimate.setFocusable(false);
		btnEstimate.setBounds(248, 264, 92, 30);
		contentPane.add(btnEstimate);

		btnEstimate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (chooseValue != null) {
					if (chooseValue.equalsIgnoreCase(" Distance")) {
						CheckDistance();

					} else if (chooseValue.equalsIgnoreCase(" Speed")) {
						CheckSpeed();

					} else if (chooseValue.equalsIgnoreCase(" Time")) {
						CheckTime();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please Select Method Type", "Alert", JOptionPane.OK_OPTION);
				}
			}
		});

		lblAnswser = new JLabel("Answser    =");
		lblAnswser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAnswser.setBounds(96, 318, 100, 20);
		contentPane.add(lblAnswser);

	}

	public void CheckDistance() {
		String timeValue = textTime.getText();
		String speedValue = textSpeed.getText();

		String PATTERN = "^[+]?([0-9]*[.])?[0-9]+$";
		Pattern pat = Pattern.compile(PATTERN);
		Matcher match1 = pat.matcher(timeValue);
		Matcher match2 = pat.matcher(speedValue);

		boolean result1 = !match1.matches();
		boolean result2 = !match2.matches();

		if (timeValue.isEmpty() || speedValue.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert", JOptionPane.OK_OPTION);

		} else if (result1 == true || result2 == true) {
			JOptionPane.showMessageDialog(null, "Input Valid Numbers Only ", "Alert", JOptionPane.OK_OPTION);

		} else {
			estimaterService.setTimeType(String.valueOf(comboBoxTime.getSelectedItem()));
			estimaterService.setSpeedType(String.valueOf(comboBoxSpeed.getSelectedItem()));
			estimaterService.setDistanceType(String.valueOf(comboBoxDistance.getSelectedItem()));
			estimaterService.setTimeValue(Double.parseDouble(timeValue));
			estimaterService.setSpeedValue(Double.parseDouble(speedValue));
			textAnswer.setText(estimaterService.displayDistanceAnswer());
		}
	}

	public void CheckSpeed() {
		String timeValue = textTime.getText();
		String distanceValue = textDistance.getText();

		String PATTERN1 = "^[0-9]+$";
		Pattern pat1 = Pattern.compile(PATTERN1);
		Matcher match1 = pat1.matcher(timeValue);

		String PATTERN2 = "^([0-9]*[.])?[0-9]+$";
		Pattern pat2 = Pattern.compile(PATTERN2);
		Matcher match2 = pat2.matcher(distanceValue);

		boolean result1 = !match1.matches();
		boolean result2 = !match2.matches();

		if (timeValue.isEmpty() || distanceValue.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert", JOptionPane.OK_OPTION);

		} else if (result1 == true || result2 == true) {
			JOptionPane.showMessageDialog(null, "Input Valid Numbers Only ", "Alert", JOptionPane.OK_OPTION);

		} else {

			estimaterService.setTimeType(String.valueOf(comboBoxTime.getSelectedItem()));
			estimaterService.setSpeedType(String.valueOf(comboBoxSpeed.getSelectedItem()));
			estimaterService.setDistanceType(String.valueOf(comboBoxDistance.getSelectedItem()));
			estimaterService.setTimeValue(Double.parseDouble(timeValue));
			estimaterService.setDistanceValue(Double.parseDouble(distanceValue));
			textAnswer.setText(estimaterService.displaySpeedAnswer());
		}

	}

	public void CheckTime() {
		String speedValue = textSpeed.getText();
		String distanceValue = textDistance.getText();

		String PATTERN1 = "^([0-9]*[.])?[0-9]+$";
		Pattern pat1 = Pattern.compile(PATTERN1);
		Matcher match1 = pat1.matcher(speedValue);

		String PATTERN2 = "^([0-9]*[.])?[0-9]+$";
		Pattern pat2 = Pattern.compile(PATTERN2);
		Matcher match2 = pat2.matcher(distanceValue);

		boolean result1 = !match1.matches();
		boolean result2 = !match2.matches();

		if (speedValue.isEmpty() || distanceValue.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert", JOptionPane.OK_OPTION);

		} else if (result1 == true || result2 == true) {
			JOptionPane.showMessageDialog(null, "Input Valid Numbers Only ", "Alert", JOptionPane.OK_OPTION);

		} else {
			estimaterService.setTimeType(String.valueOf(comboBoxTime.getSelectedItem()));
			estimaterService.setDistanceType(String.valueOf(comboBoxDistance.getSelectedItem()));
			estimaterService.setSpeedType(String.valueOf(comboBoxSpeed.getSelectedItem()));
			estimaterService.setDistanceValue(Double.parseDouble(distanceValue));
			estimaterService.setSpeedValue(Double.parseDouble(speedValue));
			textAnswer.setText(estimaterService.displayTimeAnswer());
		}

	}

}
