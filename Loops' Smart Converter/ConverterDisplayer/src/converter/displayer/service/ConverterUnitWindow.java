package converter.displayer.service;

import area.converter.service.ConverterAreaWindow;

import datastorage.converter.service.ConverterDataStorageWindow;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import length.converter.service.ConverterLengthWindow;
import mass.converter.service.ConverterMassWindow;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import pressure.converter.service.ConverterPressureWindow;
import speed.converter.service.ConverterSpeedWindow;
import temperature.converter.service.ConverterTemperatureWindow;
import time.converter.service.ConverterTimeWindow;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;

/**
 * @author PraveenKumar
 *
 */
public class ConverterUnitWindow extends JFrame {

	private JPanel contentPane;
	private JButton SpeedButton, TempButton, AreaButton, TimeButton, MassButton, LengthButton, PressureButton,
			DataStorageButton;
	private static boolean SpeedButtonClick = false;
	private static boolean TempButtonClick = false;
	private static boolean AreaButtonClick = false;
	private static boolean TimeButtonClick = false;
	private static boolean MassButtonClick = false;
	private static boolean LengthButtonClick = false;
	private static boolean PressureButtonClick = false;
	private static boolean DataStorageButtonClick = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterUnitWindow frame = new ConverterUnitWindow();
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
	public ConverterUnitWindow() {
		setResizable(false);
		setTitle("Converter");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 394);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Speed Converter Button Activity
		SpeedButton = new JButton("Speed Converter");
		SpeedButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		SpeedButton.setFocusable(false);
		SpeedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpeedButtonClick = ServiceActivator.speedTrackerChecker();
				if (SpeedButtonClick == true) {
					ConverterSpeedWindow obj = new ConverterSpeedWindow();
					obj.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please Start the Speed Converter Service",
							"Converter Service Not Found", JOptionPane.OK_OPTION);
				}
			}
		});
		SpeedButton.setBounds(22, 73, 225, 60);
		contentPane.add(SpeedButton);

		// Temperature Converter Button Activity
		TempButton = new JButton("Temperature Converter");
		TempButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TempButton.setFocusable(false);
		TempButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TempButtonClick = ServiceActivator.temperatureTrackerChecker();
				if (TempButtonClick == true) {
					ConverterTemperatureWindow obj = new ConverterTemperatureWindow();
					obj.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please Start the Temperature Converter Service",
							"Converter Service Not Found", JOptionPane.OK_OPTION);
				}
			}
		});
		TempButton.setBounds(22, 143, 225, 60);
		contentPane.add(TempButton);

		// Area Converter Button Activity
		AreaButton = new JButton("Area Converter");
		AreaButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		AreaButton.setFocusable(false);
		AreaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AreaButtonClick = ServiceActivator.areaTrackerChecker();
				if (AreaButtonClick == true) {
					ConverterAreaWindow obj = new ConverterAreaWindow();
					obj.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please Start the Area Converter Service",
							"Converter Service Not Found", JOptionPane.OK_OPTION);
				}
			}
		});
		AreaButton.setBounds(22, 213, 225, 60);
		contentPane.add(AreaButton);

		// Time Converter Button Activity
		TimeButton = new JButton("Time Converter");
		TimeButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TimeButton.setFocusable(false);
		TimeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimeButtonClick = ServiceActivator.timeTrackerChecker();
				if (TimeButtonClick == true) {
					ConverterTimeWindow obj = new ConverterTimeWindow();
					obj.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please Start the Time Converter Service",
							"Converter Service Not Found", JOptionPane.OK_OPTION);
				}

			}
		});
		TimeButton.setBounds(22, 283, 225, 60);
		contentPane.add(TimeButton);

		// Mass Converter Button Activity
		MassButton = new JButton("Mass Converter");
		MassButton.setFocusable(false);
		MassButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MassButtonClick = ServiceActivator.massTrackerChecker();
				if (MassButtonClick == true) {
					ConverterMassWindow obj = new ConverterMassWindow();
					obj.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please Start the Mass Converter Service",
							"Converter Service Not Found", JOptionPane.OK_OPTION);
				}
			}
		});
		MassButton.setBounds(272, 73, 225, 60);
		contentPane.add(MassButton);

		// Length Converter Button Activity
		LengthButton = new JButton("Length Converter");
		LengthButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LengthButton.setFocusable(false);
		LengthButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LengthButtonClick = ServiceActivator.lengthTrackerChecker();
				if (LengthButtonClick == true) {
					ConverterLengthWindow obj = new ConverterLengthWindow();
					obj.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please Start the Length Converter Service",
							"Converter Service Not Found", JOptionPane.OK_OPTION);
				}
			}
		});
		LengthButton.setBounds(272, 143, 225, 60);
		contentPane.add(LengthButton);

		// Pressure Converter Button Activity
		PressureButton = new JButton("Pressure Converter");
		PressureButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		PressureButton.setFocusable(false);
		PressureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PressureButtonClick = ServiceActivator.pressureTrackerChecker();
				if (PressureButtonClick == true) {
					ConverterPressureWindow obj = new ConverterPressureWindow();
					obj.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please Start the Pressure Converter Service",
							"Converter Service Not Found", JOptionPane.OK_OPTION);
				}
			}
		});
		PressureButton.setBounds(272, 213, 225, 60);
		contentPane.add(PressureButton);

		// DataStorage Converter Button Activity
		DataStorageButton = new JButton("DataStorage Converter");
		DataStorageButton.setFocusable(false);
		DataStorageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataStorageButtonClick = ServiceActivator.dataTrackerChecker();
				if (DataStorageButtonClick == true) {
					ConverterDataStorageWindow obj = new ConverterDataStorageWindow();
					obj.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please Start the DataStorage Converter Service",
							"Converter Service Not Found", JOptionPane.OK_OPTION);
				}
			}
		});
		DataStorageButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		DataStorageButton.setBounds(272, 283, 225, 60);
		contentPane.add(DataStorageButton);

		JLabel lblUnitConverter = new JLabel("Unit Converter");
		lblUnitConverter.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblUnitConverter.setBounds(192, 22, 176, 30);
		contentPane.add(lblUnitConverter);

	}
}
