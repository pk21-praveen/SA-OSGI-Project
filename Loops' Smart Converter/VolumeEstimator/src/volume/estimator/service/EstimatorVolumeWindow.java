package volume.estimator.service;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;


public class EstimatorVolumeWindow extends JDialog {

	private JPanel contentPane;
	private JButton btnEstimate, btnClear;
	public JComboBox comboBoxRate, comboBoxTime, comboBoxVolume, comboBoxChooser;
	private JLabel lblVolumeEstimater, lblChoose, lblVolume, lblRate, lblDuration, lblAnswser;
	private JTextField textRate, textTime, textAnswer, textVolume;
	private VolumeEstimatorService estimaterService;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstimatorVolumeWindow frame = new EstimatorVolumeWindow();
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
	public EstimatorVolumeWindow() {
		estimaterService = new VolumeEstimatorServiceImpl();
		setResizable(false);
		setTitle("Volume Estimater");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 603, 420);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblVolumeEstimater = new JLabel("Flow Rate Estimator");
		lblVolumeEstimater.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblVolumeEstimater.setBounds(193, 20, 221, 30);
		contentPane.add(lblVolumeEstimater);

		lblChoose = new JLabel("Choose a Calculation :-");
		lblChoose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChoose.setBounds(26, 60, 170, 28);
		contentPane.add(lblChoose);

		lblVolume = new JLabel("Volume    =");
		lblVolume.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVolume.setBounds(96, 123, 100, 15);
		contentPane.add(lblVolume);

		lblRate = new JLabel("Rate       =");
		lblRate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRate.setBounds(96, 171, 100, 20);
		contentPane.add(lblRate);

		lblDuration = new JLabel("Time         =");
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDuration.setBounds(96, 220, 100, 20);
		contentPane.add(lblDuration);

		textRate = new JTextField();
		textRate.setHorizontalAlignment(SwingConstants.CENTER);
		textRate.setFont(new Font("Tahoma", Font.BOLD, 20));
		textRate.setColumns(10);
		textRate.setBounds(217, 166, 170, 30);
		contentPane.add(textRate);

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

		textVolume = new JTextField();
		textVolume.setHorizontalAlignment(SwingConstants.CENTER);
		textVolume.setFont(new Font("Tahoma", Font.BOLD, 20));
		textVolume.setColumns(10);
		textVolume.setBounds(217, 115, 170, 30);
		contentPane.add(textVolume);

		comboBoxRate = new JComboBox();
		comboBoxRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxRate.setBounds(397, 166, 170, 30);
		comboBoxRate.addItem(" Cubic centimeters/second");
		comboBoxRate.addItem(" Cubic centimeters/minute");
		comboBoxRate.addItem(" Cubic centimeters/hour");
		contentPane.add(comboBoxRate);

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
		comboBoxChooser.addItem(" Volume");
		comboBoxChooser.addItem(" Rate");
		comboBoxChooser.addItem(" Time");
		contentPane.add(comboBoxChooser);

		comboBoxChooser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String calType = String.valueOf(comboBoxChooser.getSelectedItem());

				textAnswer.setText("");
				textRate.setText("");
				textVolume.setText("");
				textTime.setText("");

				if (calType.equalsIgnoreCase(" Volume")) {
					textTime.setEditable(true);
					textRate.setEditable(true);
					textVolume.setEditable(false);

				} else if (calType.equalsIgnoreCase(" Rate")) {
					textTime.setEditable(true);
					textRate.setEditable(false);
					textVolume.setEditable(true);

				} else if (calType.equalsIgnoreCase(" Time")) {
					textTime.setEditable(false);
					textRate.setEditable(true);
					textVolume.setEditable(true);
				}

			}
		});

		comboBoxVolume = new JComboBox();
		comboBoxVolume.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxVolume.setBounds(397, 115, 170, 30);
		comboBoxVolume.addItem(" Centimeter");
		comboBoxVolume.addItem(" Meter");
		comboBoxVolume.addItem(" Feet"); 
		contentPane.add(comboBoxVolume);


		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.setBounds(431, 264, 92, 30);
		btnClear.setFocusable(false);
		contentPane.add(btnClear);

		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textAnswer.setText(" ");
				textRate.setText(" ");
				textVolume.setText(" ");
				textTime.setText(" ");

				textTime.setEditable(true);
				textRate.setEditable(true);
				textVolume.setEditable(true);

				comboBoxRate.setEnabled(true);
				comboBoxTime.setEnabled(true);
				comboBoxVolume.setEnabled(true);

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
				String calType = String.valueOf(comboBoxChooser.getSelectedItem());

				if (calType.equalsIgnoreCase("--Choose a Method of Calculation--")) {
					JOptionPane.showMessageDialog(null, "Please Select Method Type", "Alert", JOptionPane.OK_OPTION);

				} else if (calType.equalsIgnoreCase(" Volume")) {
					CheckDistance();

				} else if (calType.equalsIgnoreCase(" Rate")) {
					CheckSpeed();

				} else if (calType.equalsIgnoreCase(" Time")) {
					CheckTime();
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
		String rateValue = textRate.getText();

		System.out.println(timeValue.isEmpty() + " " + rateValue.isEmpty());

		String PATTERN = "^[+]?([0-9]*[.])?[0-9]+$";
		Pattern pat = Pattern.compile(PATTERN);
		Matcher match1 = pat.matcher(timeValue);
		Matcher match2 = pat.matcher(rateValue);

		boolean result1 = !match1.matches();
		boolean result2 = !match2.matches();

		System.out.println(result1 + " " + result2);

		if (timeValue.isEmpty() || rateValue.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert", JOptionPane.OK_OPTION);

		
		} else {
			estimaterService.setTimeType(String.valueOf(comboBoxTime.getSelectedItem()));
			estimaterService.setRateType(String.valueOf(comboBoxRate.getSelectedItem()));
			estimaterService.setVolumeType(String.valueOf(comboBoxVolume.getSelectedItem()));
			estimaterService.setTimeValue(Double.parseDouble(timeValue));
			estimaterService.setRateValue(Double.parseDouble(rateValue));
			textAnswer.setText(estimaterService.displayVolumeAnswer());

		}

	}

	public void CheckSpeed() {
		String timeValue = textTime.getText();
		String volumeValue = textVolume.getText();

		String PATTERN1 = "^[0-9]+$";
		Pattern pat1 = Pattern.compile(PATTERN1);
		Matcher match1 = pat1.matcher(timeValue);

		String PATTERN2 = "^([0-9]*[.])?[0-9]+$";
		Pattern pat2 = Pattern.compile(PATTERN2);
		Matcher match2 = pat2.matcher(volumeValue);

		boolean result1 = !match1.matches();
		boolean result2 = !match2.matches();

		if (timeValue.isEmpty() || volumeValue.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert", JOptionPane.OK_OPTION);

		
		} else {

			estimaterService.setTimeType(String.valueOf(comboBoxTime.getSelectedItem()));
			estimaterService.setRateType(String.valueOf(comboBoxRate.getSelectedItem()));
			estimaterService.setVolumeType(String.valueOf(comboBoxVolume.getSelectedItem()));
			estimaterService.setTimeValue(Double.parseDouble(timeValue));
			estimaterService.setVolumeValue(Double.parseDouble(volumeValue));
			textAnswer.setText(estimaterService.displayRateAnswer());

		}

	}

	public void CheckTime() {
		String rateValue = textRate.getText();
		String volumeValue = textVolume.getText();

		String PATTERN1 = "^([0-9]*[.])?[0-9]+$";
		Pattern pat1 = Pattern.compile(PATTERN1);
		Matcher match1 = pat1.matcher(rateValue);

		String PATTERN2 = "^([0-9]*[.])?[0-9]+$";
		Pattern pat2 = Pattern.compile(PATTERN2);
		Matcher match2 = pat2.matcher(volumeValue);

		boolean result1 = !match1.matches();
		boolean result2 = !match2.matches();

		if (rateValue.isEmpty() || volumeValue.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert", JOptionPane.OK_OPTION);

		} else {
			estimaterService.setTimeType(String.valueOf(comboBoxTime.getSelectedItem()));
			estimaterService.setVolumeType(String.valueOf(comboBoxVolume.getSelectedItem()));
			estimaterService.setRateType(String.valueOf(comboBoxRate.getSelectedItem()));
			estimaterService.setVolumeValue(Double.parseDouble(volumeValue));
			estimaterService.setRateValue(Double.parseDouble(rateValue));
			textAnswer.setText(estimaterService.displayTimeAnswer());

		}

	}

}

