package pressure.estimater.service.estimatorpressure;

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

public class EstimaterPressureWindow extends JDialog{

	private JPanel contentPane;
	private JButton btnEstimate, btnClear;
	public JComboBox comboBoxArea, comboBoxForce, comboBoxPressure, comboBoxChooser;
	private JLabel lblTravelEstimater, lblChoose, lblArea, lblForce, lblPressure, lblAnswser;
	private JTextField textArea, textForce, textAnswer, textPressure;

	
	//main method
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					EstimaterPressureWindow frame = new EstimaterPressureWindow();
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
	public EstimaterPressureWindow() {
		setResizable(false);
		setTitle("Travel Estimater");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 603, 420);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTravelEstimater = new JLabel("Force Rate Estimator");
		lblTravelEstimater.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTravelEstimater.setBounds(201, 20, 230, 30);
		contentPane.add(lblTravelEstimater);

		lblChoose = new JLabel("Choose a Calculation :-");
		lblChoose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChoose.setBounds(26, 60, 170, 28);
		contentPane.add(lblChoose);

		lblArea = new JLabel("Pressure    =");
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArea.setBounds(96, 123, 100, 15);
		contentPane.add(lblArea);

		lblForce = new JLabel("Area       =");
		lblForce.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblForce.setBounds(96, 171, 100, 20);
		contentPane.add(lblForce);

		lblPressure = new JLabel("Force         =");
		lblPressure.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPressure.setBounds(96, 220, 100, 20);
		contentPane.add(lblPressure);

		textArea = new JTextField();
		textArea.setHorizontalAlignment(SwingConstants.CENTER);
		textArea.setFont(new Font("Tahoma", Font.BOLD, 20));
		textArea.setColumns(10);
		textArea.setBounds(217, 166, 170, 30);
		contentPane.add(textArea);

		textForce = new JTextField();
		textForce.setHorizontalAlignment(SwingConstants.CENTER);
		textForce.setFont(new Font("Tahoma", Font.BOLD, 20));
		textForce.setColumns(10);
		textForce.setBounds(217, 214, 170, 30);
		contentPane.add(textForce);

		textAnswer = new JTextField();
		textAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		textAnswer.setFont(new Font("Tahoma", Font.BOLD, 24));
		textAnswer.setColumns(10);
		textAnswer.setBounds(217, 309, 350, 50);
		contentPane.add(textAnswer);

		textPressure = new JTextField();
		textPressure.setHorizontalAlignment(SwingConstants.CENTER);
		textPressure.setFont(new Font("Tahoma", Font.BOLD, 20));
		textPressure.setColumns(10);
		textPressure.setBounds(217, 115, 170, 30);
		contentPane.add(textPressure);

		comboBoxArea = new JComboBox();
		comboBoxArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxArea.setBounds(397, 166, 170, 30);
		comboBoxArea.addItem("Meter * Meter");
		comboBoxArea.addItem("Centimeter * Centimeter");
		comboBoxArea.addItem("Millimeter * Millimeter");
		contentPane.add(comboBoxArea);

		comboBoxForce = new JComboBox();
		comboBoxForce.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxForce.setBounds(397, 214, 170, 30);
		comboBoxForce.addItem("Newton");
		contentPane.add(comboBoxForce);

		comboBoxChooser = new JComboBox();
		comboBoxChooser.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBoxChooser.setBounds(217, 60, 350, 30);
		comboBoxChooser.addItem("--Choose a Method of Calculation--");
		comboBoxChooser.addItem("Pressure");
		comboBoxChooser.addItem("Area");
		comboBoxChooser.addItem("Force");
		contentPane.add(comboBoxChooser);

		comboBoxChooser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String calType = String.valueOf(comboBoxChooser.getSelectedItem());
				
				PressureEstimaterService estimaterService = new PressureEstimaterServiceImpl();

				if (calType.equalsIgnoreCase("Pressure")) {
					textForce.setEditable(true);
					textArea.setEditable(true);
					textPressure.setEditable(false);

				} else if (calType.equalsIgnoreCase("Area")) {
					textForce.setEditable(true);
					textArea.setEditable(false);
					textPressure.setEditable(true);

				} else if (calType.equalsIgnoreCase("Force")) {
					textForce.setEditable(false);
					textArea.setEditable(true);
					textPressure.setEditable(true);
				}

			}
		});

		comboBoxPressure = new JComboBox();
		comboBoxPressure.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxPressure.setBounds(397, 115, 170, 30);
		comboBoxPressure.addItem("Pascal");
		comboBoxPressure.addItem("Centipascal");
		comboBoxPressure.addItem("Decipascal");
		contentPane.add(comboBoxPressure);

		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.setBounds(431, 264, 92, 30);
		btnClear.setFocusable(false);
		contentPane.add(btnClear);

		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textAnswer.setText("");
				textArea.setText("");
				textPressure.setText("");
				textForce.setText("");

				textForce.setEditable(true);
				textArea.setEditable(true);
				textPressure.setEditable(true);

				comboBoxArea.setEnabled(true);
				comboBoxForce.setEnabled(true);
				comboBoxPressure.setEnabled(true);

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
				
				PressureEstimaterService estimaterService = new PressureEstimaterServiceImpl();

				if (calType.equalsIgnoreCase("--Choose a Method of Calculation--")) {
					JOptionPane.showMessageDialog(null, "Please Select Method Type", "Alert",
							JOptionPane.OK_OPTION);

				} else if (calType.equalsIgnoreCase("Pressure")) {

					String forceVal = textForce.getText();
					String areaVal = textArea.getText();

					String PATTERN1 = "^[0-9]+$";
					Pattern pat1 = Pattern.compile(PATTERN1);
					Matcher match1 = pat1.matcher(forceVal);

					String PATTERN2 = "^([0-9]*[.])?[0-9]+$";
					Pattern pat2 = Pattern.compile(PATTERN1);
					Matcher match2 = pat2.matcher(areaVal);

					boolean result1 = !match1.matches();
					boolean result2 = !match2.matches();

					if (forceVal.isEmpty() || areaVal.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert",
								JOptionPane.OK_OPTION);

					} else if (result1 == true || result2 == true) {
						JOptionPane.showMessageDialog(null, "Input Valid Numbers Only ", "Alert",
								JOptionPane.OK_OPTION);

					} else {
						
						estimaterService.setForceType(String.valueOf(comboBoxForce.getSelectedItem()));
						estimaterService.setAreaType(String.valueOf(comboBoxArea.getSelectedItem()));
						estimaterService.setForceVal(Double.parseDouble(forceVal));
						estimaterService.setAreaVal(Double.parseDouble(areaVal));
						textAnswer.setText(estimaterService.getPressureResult(String.valueOf(comboBoxPressure.getSelectedItem())));

					}


				} else if (calType.equalsIgnoreCase("Area")) {

					String forceVal = textForce.getText();
					String pressureVal = textPressure.getText();

					String PATTERN1 = "^[0-9]+$";
					Pattern pat1 = Pattern.compile(PATTERN1);
					Matcher match1 = pat1.matcher(forceVal);

					String PATTERN2 = "^([0-9]*[.])?[0-9]+$";
					Pattern pat2 = Pattern.compile(PATTERN1);
					Matcher match2 = pat2.matcher(pressureVal);

					boolean result1 = !match1.matches();
					boolean result2 = !match2.matches();

					if (forceVal.isEmpty() || pressureVal.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert",
								JOptionPane.OK_OPTION);

					} else if (result1 == true || result2 == true) {
						JOptionPane.showMessageDialog(null, "Input Valid Numbers Only ", "Alert",
								JOptionPane.OK_OPTION);

					} else {

						estimaterService.setForceType(String.valueOf(comboBoxForce.getSelectedItem()));
						estimaterService.setPressureType(String.valueOf(comboBoxPressure.getSelectedItem()));
						estimaterService.setForceVal(Double.parseDouble(forceVal));
						estimaterService.setPressureVal(Double.parseDouble(pressureVal));
						textAnswer.setText(estimaterService.getAreaResult(String.valueOf(comboBoxArea.getSelectedItem())));

					}


				} else if (calType.equalsIgnoreCase("Force")) {

					String areaVal = textArea.getText();
					String pressureVal = textPressure.getText();

					String PATTERN1 = "^([0-9]*[.])?[0-9]+$";
					Pattern pat1 = Pattern.compile(PATTERN1);
					Matcher match1 = pat1.matcher(areaVal);

					String PATTERN2 = "^([0-9]*[.])?[0-9]+$";
					Pattern pat2 = Pattern.compile(PATTERN1);
					Matcher match2 = pat2.matcher(pressureVal);

					boolean result1 = !match1.matches();
					boolean result2 = !match2.matches();

					if (areaVal.isEmpty() || pressureVal.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert",
								JOptionPane.OK_OPTION);

					} else if (result1 == true || result2 == true) {
						JOptionPane.showMessageDialog(null, "Input Valid Numbers Only ", "Alert",
								JOptionPane.OK_OPTION);

					} else {
						
						
						estimaterService.setAreaType(String.valueOf(comboBoxArea.getSelectedItem()));
						estimaterService.setPressureType(String.valueOf(comboBoxPressure.getSelectedItem()));
						estimaterService.setAreaVal(Double.parseDouble(areaVal));
						estimaterService.setPressureVal(Double.parseDouble(pressureVal));
						textAnswer.setText(estimaterService.getForceResult(String.valueOf(comboBoxForce.getSelectedItem())));
					}


				}
			}
		});

		lblAnswser = new JLabel("Answser    =");
		lblAnswser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAnswser.setBounds(96, 318, 100, 20);
		contentPane.add(lblAnswser);

	}
}
