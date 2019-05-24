package estimator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

/**
 * @author Shriram
 *
 */
public class EstimatorWindow extends JDialog {

	private JPanel contentPane;
	private JTextField AreaInSize;
	private JTextField Price;

	/**
	 * @author Shriram
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstimatorWindow frame = new EstimatorWindow();
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
	public EstimatorWindow() {
		setSize(new Dimension(789, 500));
		setMaximumSize(new Dimension(800, 500));
		setBounds(100, 100, 799, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(800, 500));
		contentPane.setBackground(new Color(255, 255, 255));
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
		
		JLabel lblNewLabel = new JLabel("Input Land Area Size");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel.setBounds(77, 107, 137, 24);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("Select Area Unit");
		label.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		label.setBounds(77, 53, 125, 24);
		panel.add(label);
		
		JLabel lblSelectCurrencyUnit = new JLabel("Select Currency Unit");
		lblSelectCurrencyUnit.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblSelectCurrencyUnit.setBounds(77, 161, 137, 24);
		panel.add(lblSelectCurrencyUnit);
		
		JLabel lblPricePerUnit = new JLabel("Price per Unit Area ");
		lblPricePerUnit.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblPricePerUnit.setBounds(77, 212, 125, 24);
		panel.add(lblPricePerUnit);
		
		JComboBox AreaIn = new JComboBox();
		AreaIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		AreaIn.setBounds(248, 50, 170, 30);
		panel.add(AreaIn);
		
		//Setting Area Values
		AreaIn.addItem(" Square Feets");
		AreaIn.addItem(" Square Meters");
		AreaIn.addItem(" Acres");
		AreaIn.addItem(" Hectares");
		AreaIn.addItem(" Square Kilometers");
		AreaIn.addItem(" Square Miles");
		
		JComboBox CurrencyIn = new JComboBox();
		CurrencyIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CurrencyIn.setBounds(248, 158, 170, 30);
		panel.add(CurrencyIn);
		
		//Setting Values
		CurrencyIn.addItem(" SriLankan Rupees");
		CurrencyIn.addItem(" US Dollars");
		CurrencyIn.addItem(" Great Britain Pounds");
		CurrencyIn.addItem(" Euro");
		CurrencyIn.addItem(" Australian Dollars");
		
		AreaInSize = new JTextField();
		AreaInSize.setBounds(248, 102, 171, 36);
		panel.add(AreaInSize);
		AreaInSize.setColumns(10);
		
		Price = new JTextField();
		Price.setColumns(10);
		Price.setBounds(248, 200, 171, 36);
		panel.add(Price);
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(20, 2));
		separator.setBounds(60, 266, 400, 13);
		panel.add(separator);
		
		JLabel lblOutputParametersRequired = new JLabel("Required Output Parameters");
		lblOutputParametersRequired.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblOutputParametersRequired.setBounds(174, 280, 194, 24);
		panel.add(lblOutputParametersRequired);
		
		JComboBox AreaOut = new JComboBox();
		AreaOut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		AreaOut.setBounds(208, 317, 170, 30);
		panel.add(AreaOut);
		
		//Setting Area Values
		AreaOut.addItem(" Square Feets");
		AreaOut.addItem(" Square Meters");
		AreaOut.addItem(" Acres");
		AreaOut.addItem(" Hectares");
		AreaOut.addItem(" Square Kilometers");
		AreaOut.addItem(" Square Miles");
		
		JComboBox CurrencyOut = new JComboBox();
		CurrencyOut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CurrencyOut.setBounds(208, 372, 170, 30);
		panel.add(CurrencyOut);
		
		
		//Setting Values
		CurrencyOut.addItem(" SriLankan Rupees");
		CurrencyOut.addItem(" US Dollars");
		CurrencyOut.addItem(" Great Britain Pounds");
		CurrencyOut.addItem(" Euro");
		CurrencyOut.addItem(" Australian Dollars");
		
		JLabel lblSelectOutputArea = new JLabel("Select Output Area Unit");
		lblSelectOutputArea.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblSelectOutputArea.setBounds(12, 320, 155, 24);
		panel.add(lblSelectOutputArea);
		
		JLabel lblSelectOutputPrice = new JLabel("Select Output Currency Unit");
		lblSelectOutputPrice.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblSelectOutputPrice.setBounds(12, 375, 190, 24);
		panel.add(lblSelectOutputPrice);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setForeground(new Color(255, 255, 204));
		btnCalculate.setBorderPainted(false);
		btnCalculate.setBorder(null);
		btnCalculate.setBackground(new Color(51, 51, 102));
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!AreaInSize.getText().isEmpty() && !Price.getText().isEmpty()) {
					
					try {
						String areaIn = String.valueOf(AreaIn.getSelectedItem());
						Double areaSize = Double.parseDouble(AreaInSize.getText());
						String currencyIn = String.valueOf(CurrencyIn.getSelectedItem());
						Double unitPrice = Double.parseDouble(Price.getText());
						String areaOut = String.valueOf(AreaOut.getSelectedItem());
						String currencyOut = String.valueOf(CurrencyOut.getSelectedItem());
						
						Estimates estimates = new Estimates(areaIn, areaSize, currencyIn, unitPrice, areaOut, currencyOut);
						
						EstimatorResult obj= new EstimatorResult(estimates);
			            obj.setVisible(true);
			            obj.setLocationRelativeTo(null);
			            dispose();
					}
					catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Invalid Numeric Input");
					}
					catch(Exception exception) {}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Field Cannot be Empty");
				}
				
				
			}
		});
		btnCalculate.setBounds(391, 405, 97, 25);
		panel.add(btnCalculate);
		
		JLabel lblInputParameters = new JLabel("Input Parameters ");
		lblInputParameters.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblInputParameters.setBounds(174, 13, 194, 24);
		panel.add(lblInputParameters);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 102));
		panel_1.setBounds(2, 0, 270, 462);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCurrencyConverter = new JLabel("Real Estate Estimator");
		lblCurrencyConverter.setToolTipText("");
		lblCurrencyConverter.setForeground(new Color(255, 255, 255));
		lblCurrencyConverter.setFont(new Font("Century Gothic", Font.PLAIN, 23));
		lblCurrencyConverter.setBounds(12, 193, 236, 28);
		panel_1.add(lblCurrencyConverter);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(EstimatorWindow.class.getResource("/estimator/finance.png")));
		label_1.setBounds(-184, -11, 454, 466);
		panel_1.add(label_1);
	}
}
