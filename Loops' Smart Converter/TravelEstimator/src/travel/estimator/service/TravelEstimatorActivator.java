package travel.estimator.service;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * @author PraveenKumar
 *
 */
public class TravelEstimatorActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Started Travel Estimater Service !!!");
		TravelEstimatorService estimaterService = new TravelEstimatorServiceImpl();
		publishServiceRegistration = bundleContext.registerService(TravelEstimatorService.class.getName(), estimaterService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Travel Estimater Service Stopped !!!");
		publishServiceRegistration.unregister();

	}

}
