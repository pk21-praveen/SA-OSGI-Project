package converter.displayer.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * @author PraveenKumar
 *
 */
public class ServiceActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Started Displayer Service !!!");
		ServiceDisplayer serviceDisplayer = new ServiceDisplayerImpl();
		publishServiceRegistration = bundleContext.registerService(ServiceDisplayer.class.getName(), serviceDisplayer,null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopped Displayer Service !!!");
		publishServiceRegistration.unregister();
	}

}
