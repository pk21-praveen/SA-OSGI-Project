package converter.displayer.service;

/**
 * @author PraveenKumar
 *
 */
public class ServiceDisplayerImpl implements ServiceDisplayer {
	ConverterWindow cw;
	
	@Override
	public void publishService() {
		cw = new ConverterWindow();
		cw.setVisible(true);
	}

	@Override
	public void disposeService() {
		cw.dispose();		
	}
	
	

}
