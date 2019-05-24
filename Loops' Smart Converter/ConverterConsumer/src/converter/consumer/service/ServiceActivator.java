package converter.consumer.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import converter.displayer.service.ServiceDisplayer;

/**
 * @author PraveenKumar
 *
 */
public class ServiceActivator implements BundleActivator {

	ServiceReference serviceReference;
	ServiceDisplayer serviceDisplayer;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Started Consumer Service !!!");
		serviceReference = bundleContext.getServiceReference(ServiceDisplayer.class.getName());
		serviceDisplayer = (ServiceDisplayer) bundleContext.getService(serviceReference); 
		serviceDisplayer.publishService();
	}


	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopped Consumer Service !!!");
		bundleContext.ungetService(serviceReference);
		serviceDisplayer.disposeService();
	}

}
