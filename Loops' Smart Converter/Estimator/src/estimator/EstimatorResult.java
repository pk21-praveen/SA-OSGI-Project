package estimator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import area.converter.service.AreaConverterService;
import area.converter.service.AreaConverterServiceImpl;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * @author Shriram
 *
 */
public class EstimatorResult extends JDialog {

	private JPanel contentPane;
	private JTextField CurrencyUnit;
	private JTextField AreaTotal;
	private JTextField AreaUnit;
	private JTextField PriceTotal;
	private JTextField PriceUnit_In;
	
	private static Estimates estimates;
	private JTextField PriceUnit_Out;

	/**
	 * @author Shriram
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstimatorResult frame = new EstimatorResult(estimates);
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
	public EstimatorResult(Estimates estimates){
		
		this.estimates=estimates;
		
		setSize(new Dimension(800, 500));
		setMaximumSize(new Dimension(800, 500));
		setBounds(100, 100, 799, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(800, 500));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(276, 0, 507, 462);
		panel.setPreferredSize(new Dimension(500, 300));
		panel.setMinimumSize(new Dimension(10, 200));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Currency Unit");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel.setBounds(77, 107, 137, 24);
		panel.add(lblNewLabel);
		
		JLabel lblAreaUnit = new JLabel("Area Unit");
		lblAreaUnit.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblAreaUnit.setBounds(77, 53, 125, 24);
		panel.add(lblAreaUnit);
		
		JLabel lblSelectCurrencyUnit = new JLabel("Total Area");
		lblSelectCurrencyUnit.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblSelectCurrencyUnit.setBounds(36, 196, 174, 24);
		panel.add(lblSelectCurrencyUnit);
		
		JLabel lblPricePerUnit = new JLabel("Total Price");
		lblPricePerUnit.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblPricePerUnit.setBounds(36, 250, 174, 24);
		panel.add(lblPricePerUnit);
		
		CurrencyUnit = new JTextField();
		CurrencyUnit.setEditable(false);
		CurrencyUnit.setBounds(248, 107, 171, 36);
		panel.add(CurrencyUnit);
		CurrencyUnit.setColumns(10);
		//Setting Currency Unit
		CurrencyUnit.setText(this.estimates.getCurrencyOut());
		
		AreaTotal = new JTextField();
		AreaTotal.setEditable(false);
		AreaTotal.setColumns(10);
		AreaTotal.setBounds(272, 196, 171, 36);
		panel.add(AreaTotal);
		
		AreaConverterService areaConverter = new AreaConverterServiceImpl();
		String AreaIn = this.estimates.getAreaIn();
		String AreaOut = this.estimates.getAreaOut();
		
		Double AreaInSize = this.estimates.getAreaSize();
		Double TotArea=0.0;
		
		Double ConvertedUnitPrice_Out=0.0;
		
		if (AreaIn.equalsIgnoreCase(" Square Feets")){
			
			if(AreaOut.equalsIgnoreCase(" Square Feets")) {
				TotArea = areaConverter.SquareFeetsToSquareFeets(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareFeetsToSquareFeets(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Square Meters")) {
				TotArea = areaConverter.SquareFeetsToSquareMeters(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareFeetsToSquareMeters(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Acres")) {
				TotArea = areaConverter.SquareFeetsToAcres(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareFeetsToAcres(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Hectares")) {
				TotArea = areaConverter.SquareFeetsToHectares(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareFeetsToHectares(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Square Kilometers")) {
				TotArea = areaConverter.SquareFeetsToSquareKilometers(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareFeetsToSquareKilometers(1);

			}
			else if(AreaOut.equalsIgnoreCase(" Square Miles")) {
				TotArea = areaConverter.SquareFeetsToSquareMiles(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareFeetsToSquareMiles(1);

			}

		}
		
		else if (AreaIn.equalsIgnoreCase(" Square Meters")){
			
			if(AreaOut.equalsIgnoreCase(" Square Feets")) {
				TotArea = areaConverter.SquareMetersToSquareFeets(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareMetersToSquareFeets(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Square Meters")) {
				TotArea = areaConverter.SquareMetersToSquareMeters(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareMetersToSquareMeters(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Acres")) {
				TotArea = areaConverter.SquareMetersToAcres(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareMetersToAcres(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Hectares")) {
				TotArea = areaConverter.SquareMetersToHectares(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareMetersToHectares(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Square Kilometers")) {
				TotArea = areaConverter.SquareMetersToSquareKilometers(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareMetersToSquareKilometers(1);

			}
			else if(AreaOut.equalsIgnoreCase(" Square Miles")) {
				TotArea = areaConverter.SquareMetersToSquareMiles(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareMetersToSquareMiles(1);

			}

		}
		
		else if (AreaIn.equalsIgnoreCase(" Acres")){
			
			if(AreaOut.equalsIgnoreCase(" Square Feets")) {
				TotArea = areaConverter.AcresToSquareFeets(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.AcresToSquareFeets(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Square Meters")) {
				TotArea = areaConverter.AcresToSquareMeters(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.AcresToSquareMeters(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Acres")) {
				TotArea = areaConverter.AcresToAcres(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.AcresToAcres(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Hectares")) {
				TotArea = areaConverter.AcresToHectares(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.AcresToHectares(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Square Kilometers")) {
				TotArea = areaConverter.AcresToSquareKilometers(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.AcresToSquareKilometers(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Square Miles")) {
				TotArea = areaConverter.AcresToSquareMiles(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.AcresToSquareMiles(1);

			}

		}
		
		else if (AreaIn.equalsIgnoreCase(" Hectares")){
			
			if(AreaOut.equalsIgnoreCase(" Square Feets")) {
				TotArea = areaConverter.HectaresToSquareFeets(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.HectaresToSquareFeets(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Square Meters")) {
				TotArea = areaConverter.HectaresToSquareMeters(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.HectaresToSquareMeters(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Acres")) {
				TotArea = areaConverter.HectaresToAcres(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.HectaresToAcres(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Hectares")) {
				TotArea = areaConverter.HectaresToHectares(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.HectaresToHectares(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Square Kilometers")) {
				TotArea = areaConverter.HectaresToSquareKilometers(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.HectaresToSquareKilometers(1);

			}
			else if(AreaOut.equalsIgnoreCase(" Square Miles")) {
				TotArea = areaConverter.HectaresToSquareMiles(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.HectaresToSquareMiles(1);

			}

		}
		
		else if (AreaIn.equalsIgnoreCase(" Square Kilometers")){
			
			if(AreaOut.equalsIgnoreCase(" Square Feets")) {
				TotArea = areaConverter.SquareKilometersToSquareFeets(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareKilometersToSquareFeets(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Square Meters")) {
				TotArea = areaConverter.SquareKilometersToSquareMeters(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareKilometersToSquareMeters(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Acres")) {
				TotArea = areaConverter.SquareKilometersToAcres(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareKilometersToAcres(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Hectares")) {
				TotArea = areaConverter.SquareKilometersToHectares(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareKilometersToHectares(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Square Kilometers")) {
				TotArea = areaConverter.SquareKilometersToSquareKilometers(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareKilometersToSquareKilometers(1);

			}
			else if(AreaOut.equalsIgnoreCase(" Square Miles")) {
				TotArea = areaConverter.SquareKilometersToSquareMiles(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareKilometersToSquareMiles(1);

			}

		}
		
		else if (AreaIn.equalsIgnoreCase(" Square Miles")){
			
			if(AreaOut.equalsIgnoreCase(" Square Feets")) {
				TotArea = areaConverter.SquareMilesToSquareFeets(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareMilesToSquareFeets(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Square Meters")) {
				TotArea = areaConverter.SquareMilesToSquareMeters(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareMilesToSquareMeters(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Acres")) {
				TotArea = areaConverter.SquareMilesToAcres(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareMilesToAcres(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Hectares")) {
				TotArea = areaConverter.SquareMilesToHectares(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareMilesToHectares(1);
			}
			
			else if(AreaOut.equalsIgnoreCase(" Square Kilometers")) {
				TotArea = areaConverter.SquareMilesToSquareKilometers(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareMilesToSquareKilometers(1);

			}
			else if(AreaOut.equalsIgnoreCase(" Square Miles")) {
				TotArea = areaConverter.SquareMilesToSquareMiles(AreaInSize);
				ConvertedUnitPrice_Out = this.estimates.getUnitPrice()/areaConverter.SquareMilesToSquareMiles(1);

			}

		}
		
		if (TotArea != 0.0) {
//			TotArea=Math.round(TotArea*10000)/10000.0;
			AreaTotal.setText(String.valueOf(BigDecimal.valueOf(TotArea).setScale(3,BigDecimal.ROUND_HALF_DOWN)));
			
		}
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(20, 2));
		separator.setBounds(60, 170, 400, 13);
		panel.add(separator);
		
		JLabel lbl_In = new JLabel("Unit Price per ");
		lbl_In.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lbl_In.setBounds(36, 349, 200, 24);
		lbl_In.setText(lbl_In.getText()+this.estimates.getAreaIn());
		panel.add(lbl_In);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 255, 204));
		btnBack.setBackground(new Color(51, 51, 102));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EstimatorWindow obj= new EstimatorWindow();
	            obj.setVisible(true);
	            obj.setLocationRelativeTo(null);
	            dispose();
			}
		});
		btnBack.setBounds(212, 405, 97, 25);
		panel.add(btnBack);
		
		JLabel lblInputParameters = new JLabel("Input Parameters ");
		lblInputParameters.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblInputParameters.setBounds(174, 13, 194, 24);
		panel.add(lblInputParameters);
		
		AreaUnit = new JTextField();
		AreaUnit.setEditable(false);
		AreaUnit.setColumns(10);
		AreaUnit.setBounds(247, 55, 171, 36);
		panel.add(AreaUnit);
		//Setting Area Unit
		AreaUnit.setText(this.estimates.getAreaOut());
		
		PriceTotal = new JTextField();
		PriceTotal.setEditable(false);
		PriceTotal.setColumns(10);
		PriceTotal.setBounds(272, 250, 171, 36);
		panel.add(PriceTotal);
		
		
		//Fetching real time Values
		URL url;
		HashMap<String, Double> hm  = new HashMap<>();
		try {
			url = new URL("http://www.apilayer.net/api/live?access_key=ad22bd4f0a8c094965e4433ad875e948&currencies=AUD,EUR,GBP,LKR");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        String line = reader.readLine();
	        line = line.substring(1, line.length()-1);
	        int index = line.indexOf("{");
	        line = line.substring(index+1,line.length()-1);
	        String[] keys=line.split(",");
	        
	        
	        for(int i=0;i<keys.length;i++) {
	        	Double value = Double.parseDouble(keys[i].substring(keys[i].indexOf(":")+1));
	        	hm.put(keys[i].substring(1,keys[i].indexOf(":")-1), value);
	        	System.out.println(value);
	        }

	        System.out.println(hm);
	        for (int i=0;i<keys.length;i++) {
	        	System.out.println(keys[i]);
	        }
	        
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Check your Internet Connection!");
		}
		
		//Manipulating
		String CurrencyIn= this.estimates.getCurrencyIn();
		String CurrencyOut= this.estimates.getCurrencyOut();
		
		Double UnitPrice = this.estimates.getUnitPrice();
		Double ConvertedUnitPrice_In = 0.0;
		
		if(" SriLankan Rupees".equals(CurrencyIn)) {
			
			switch(CurrencyOut) {
				case " SriLankan Rupees":
					ConvertedUnitPrice_In=UnitPrice;
					ConvertedUnitPrice_Out=UnitPrice;
					break;
					
				case " US Dollars":
					ConvertedUnitPrice_In=UnitPrice/hm.get("USDLKR");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out/hm.get("USDLKR");
					break;
					
				case " Great Britain Pounds":
					ConvertedUnitPrice_In=UnitPrice*hm.get("USDGBP")/hm.get("USDLKR");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out*hm.get("USDGBP")/hm.get("USDLKR");
					break;
					
				case " Euro":
					ConvertedUnitPrice_In=UnitPrice*hm.get("USDEUR")/hm.get("USDLKR");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out*hm.get("USDEUR")/hm.get("USDLKR");
					break;
				
				case " Australian Dollars":
					ConvertedUnitPrice_In=UnitPrice*hm.get("USDAUD")/hm.get("USDLKR");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out*hm.get("USDAUD")/hm.get("USDLKR");
					break;
	
			}
		}
		
		else if(" US Dollars".equals(CurrencyIn)) {
			
			switch(CurrencyOut) {
				case " SriLankan Rupees":
					ConvertedUnitPrice_In=UnitPrice*hm.get("USDLKR");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out*hm.get("USDLKR");
					break;
					
				case " US Dollars":
					ConvertedUnitPrice_In=UnitPrice;
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out;
					break;
					
				case " Great Britain Pounds":
					ConvertedUnitPrice_In=UnitPrice*hm.get("USDGBP");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out*hm.get("USDGBP");
					break;
					
				case " Euro":
					ConvertedUnitPrice_In=UnitPrice*hm.get("USDEUR");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out*hm.get("USDEUR");
					break;
				
				case " Australian Dollars":
					ConvertedUnitPrice_In=UnitPrice*hm.get("USDAUD");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out*hm.get("USDAUD");
					break;
	
			}
		}
		
		else if(" Great Britain Pounds".equals(CurrencyIn)) {
			
			switch(CurrencyOut) {
				case " SriLankan Rupees":
					ConvertedUnitPrice_In=UnitPrice*hm.get("USDLKR")/hm.get("USDGBP");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out*hm.get("USDLKR")/hm.get("USDGBP");
					break;
					
				case " US Dollars":
					ConvertedUnitPrice_In=UnitPrice/hm.get("USDGBP");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out/hm.get("USDGBP");
					break;
					
				case " Great Britain Pounds":
					ConvertedUnitPrice_In=UnitPrice;
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out;
					break;
					
				case " Euro":
					ConvertedUnitPrice_In=UnitPrice*hm.get("USDEUR")/hm.get("USDGBP");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out*hm.get("USDEUR")/hm.get("USDGBP");
					break;
				
				case " Australian Dollars":
					ConvertedUnitPrice_In=UnitPrice*hm.get("USDAUD")/hm.get("USDGBP");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out*hm.get("USDAUD")/hm.get("USDGBP");
					break;
	
			}
		}
		
		else if(" Euro".equals(CurrencyIn)) {
			
			switch(CurrencyOut) {
				case " SriLankan Rupees":
					ConvertedUnitPrice_In=UnitPrice*hm.get("USDLKR")/hm.get("USDEUR");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out*hm.get("USDLKR")/hm.get("USDEUR");
					break;
					
				case " US Dollars":
					ConvertedUnitPrice_In=UnitPrice/hm.get("USDEUR");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out/hm.get("USDEUR");
					break;
					
				case " Great Britain Pounds":
					ConvertedUnitPrice_In=UnitPrice*hm.get("USDGBP")/hm.get("USDEUR");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out*hm.get("USDGBP")/hm.get("USDEUR");
					break;
					
				case " Euro":
					ConvertedUnitPrice_In=UnitPrice;
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out;
					break;
				
				case " Australian Dollars":
					ConvertedUnitPrice_In=UnitPrice*hm.get("USDAUD")/hm.get("USDEUR");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out*hm.get("USDAUD")/hm.get("USDEUR");
					break;
	
			}
		}
		
		else if(" Australian Dollars".equals(CurrencyIn)) {
			
			switch(CurrencyOut) {
				case " SriLankan Rupees":
					ConvertedUnitPrice_In=UnitPrice*hm.get("USDLKR")/hm.get("USDAUD");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out*hm.get("USDLKR")/hm.get("USDAUD");
					break;
					
				case " US Dollars":
					ConvertedUnitPrice_In=UnitPrice/hm.get("USDAUD");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out/hm.get("USDAUD");
					break;
					
				case " Great Britain Pounds":
					ConvertedUnitPrice_In=UnitPrice*hm.get("USDGBP")/hm.get("USDAUD");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out*hm.get("USDGBP")/hm.get("USDAUD");
					break;
					
				case " Euro":
					ConvertedUnitPrice_In=UnitPrice*hm.get("USDEUR")/hm.get("USDAUD");
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out*hm.get("USDEUR")/hm.get("USDAUD");
					break;
				
				case " Australian Dollars":
					ConvertedUnitPrice_In=UnitPrice;
					ConvertedUnitPrice_Out=ConvertedUnitPrice_Out;
					break;
	
			}
		}
		
		
		PriceUnit_In = new JTextField();
		PriceUnit_In.setEditable(false);
		PriceUnit_In.setColumns(10);
		PriceUnit_In.setBounds(272, 349, 171, 36);
		panel.add(PriceUnit_In);
		
		//Setting Unit Price(IN)
		PriceUnit_In.setText(String.valueOf(BigDecimal.valueOf(ConvertedUnitPrice_In).setScale(3,BigDecimal.ROUND_HALF_DOWN)));

		
		//Setting Total Price     
		PriceTotal.setText(String.valueOf(BigDecimal.valueOf(ConvertedUnitPrice_Out*TotArea).setScale(3,BigDecimal.ROUND_HALF_DOWN)));

		
		JLabel lbl_Out = new JLabel("Unit Price per ");
		lbl_Out.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lbl_Out.setBounds(36, 299, 200, 24);
		lbl_Out.setText(lbl_Out.getText()+this.estimates.getAreaOut());
		panel.add(lbl_Out);
		
		PriceUnit_Out = new JTextField();
		PriceUnit_Out.setText("0.0");
		PriceUnit_Out.setEditable(false);
		PriceUnit_Out.setColumns(10);
		PriceUnit_Out.setBounds(272, 299, 171, 36);
		panel.add(PriceUnit_Out);
		
		//Setting Unit Price(OUT)
		PriceUnit_Out.setText(String.valueOf(BigDecimal.valueOf(ConvertedUnitPrice_Out).setScale(3,BigDecimal.ROUND_HALF_DOWN)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(51, 51, 102));
		panel_1.setBounds(2, 0, 270, 462);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Currency Converter");
		label.setToolTipText("");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		label.setBounds(36, 202, 222, 28);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(EstimatorResult.class.getResource("/estimator/finance.png")));
		label_1.setBounds(-176, 0, 446, 454);
		panel_1.add(label_1);
	}
}
