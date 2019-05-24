package converter.displayer.service;

import area.converter.service.ConverterAreaWindow;


import datastorage.converter.service.ConverterDataStorageWindow;
import estimator.EstimatorWindow;

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
import pressure.estimater.service.estimatorpressure.EstimaterPressureWindow;
import speed.converter.service.ConverterSpeedWindow;
import temperature.converter.service.ConverterTemperatureWindow;
import time.converter.service.ConverterTimeWindow;
import travel.estimator.service.EstimatorTravelWindow;
import volume.estimator.service.EstimatorVolumeWindow;

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
public class ConverterMenuWindow extends JFrame {

	private JPanel contentPane;
	private JButton REButton, FRButton, TravelButton, UnitButton,
			ForceButton;
	private static boolean SpeedButtonClick = false;
	private static boolean TempButtonClick = false;
	private static boolean AreaButtonClick = false;
	private static boolean TimeButtonClick = false;
	private static boolean MassButtonClick = false;
	private static boolean UnitButtonClick = false;
	private static boolean PressureButtonClick = false;
	private static boolean DataStorageButtonClick = false;

	private static boolean volumeButtonClick = false;
	private static boolean travelButtonClick = false;
	private static boolean realButtonClick = false;
	private static boolean forceButtonClick = false;

	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterMenuWindow frame = new ConverterMenuWindow();
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
	public ConverterMenuWindow() {
		setResizable(false);
		setTitle("Converter");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 363);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// RealEstate Estimator Button Activity
		REButton = new JButton("RealEstate Estimator");
		REButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		REButton.setFocusable(false);
		REButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realButtonClick = ServiceActivator.realTrackerChecker();
				if (realButtonClick == true) {
					EstimatorWindow obj = new EstimatorWindow();
					obj.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(null, "Please Start RealEstate Estimater Service",
							"Estimator Service Not Found", JOptionPane.OK_OPTION);
				}

			}
		});
		REButton.setBounds(23, 80, 225, 60);
		contentPane.add(REButton);

		// Flow Rate Estimator Button Activity
		FRButton = new JButton("Flow Rate Estimator");
		FRButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		FRButton.setFocusable(false);
		FRButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				volumeButtonClick = ServiceActivator.volumeTrackerChecker();
				if (volumeButtonClick == true) {
					EstimatorVolumeWindow obj = new EstimatorVolumeWindow();
					obj.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please Start Flow Rate Estimater Service",
							"Estimator Service Not Found", JOptionPane.OK_OPTION);
				}

			}
		});
		FRButton.setBounds(23, 251, 225, 60);
		contentPane.add(FRButton);

		// Travel Estimator Button Activity
		TravelButton = new JButton("Travel Estimator");
		TravelButton.setFocusable(false);
		TravelButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TravelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				travelButtonClick = ServiceActivator.travelTrackerChecker();
				if (travelButtonClick == true) {
					EstimatorTravelWindow obj = new EstimatorTravelWindow();
					obj.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please Start Travel Estimater Service",
							"Estimator Service Not Found", JOptionPane.OK_OPTION);
				}

			}
		});
		TravelButton.setBounds(273, 80, 225, 60);
		contentPane.add(TravelButton);

		// Unit Converter Button Activity
		UnitButton = new JButton("Unit Converter");
		UnitButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		UnitButton.setFocusable(false);
		UnitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConverterUnitWindow obj = new ConverterUnitWindow();
				obj.setVisible(true);

			}
		});
		UnitButton.setBounds(143, 165, 225, 60);
		contentPane.add(UnitButton);

		// Force Rate Estimator Button Activity
		ForceButton = new JButton("Force Rate Estimator");
		ForceButton.setFocusable(false);
		ForceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				forceButtonClick= ServiceActivator.forceTrackerChecker();
				if (forceButtonClick == true) {
					EstimaterPressureWindow obj = new EstimaterPressureWindow();
					obj.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please Start Force Rate Estimater Service",
							"Estimator Service Not Found", JOptionPane.OK_OPTION);
				}

			}
		});
		ForceButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ForceButton.setBounds(273, 251, 225, 60);
		contentPane.add(ForceButton);

		JLabel lblUnitConverter = new JLabel("Loops' Smart Convertor");
		lblUnitConverter.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblUnitConverter.setBounds(132, 23, 284, 33);
		contentPane.add(lblUnitConverter);

	}
}
