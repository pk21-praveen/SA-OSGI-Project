package converter.displayer.service;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * @author PraveenKumar
 *
 */
public class ServiceDisplayerImpl implements ServiceDisplayer {
	ConverterUnitWindow cw;
	
	@Override
	public void publishService() {
//		JFrame.setDefaultLookAndFeelDecorated(true);
//		JDialog.setDefaultLookAndFeelDecorated(true);

		cw = new ConverterUnitWindow();
		cw.setVisible(true);
	}

	@Override
	public void disposeService() {
		cw.dispose();		
	}

}
