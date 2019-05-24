package volume.estimator.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class VolumeEstimatorActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Started Flow Rate Estimater Service !!!");
		VolumeEstimatorService estimaterService = new VolumeEstimatorServiceImpl();
		publishServiceRegistration = bundleContext.registerService(VolumeEstimatorService.class.getName(), estimaterService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Flow Rate Estimater Service Stopped !!!");
		publishServiceRegistration.unregister();

	}

}

