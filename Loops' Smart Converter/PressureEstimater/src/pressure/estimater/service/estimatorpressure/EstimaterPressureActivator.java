package pressure.estimater.service.estimatorpressure;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class EstimaterPressureActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Force Rate Estimater Service Started !!!");	
		PressureEstimaterService converterService = new PressureEstimaterServiceImpl();
		publishServiceRegistration = bundleContext.registerService(PressureEstimaterService.class.getName(),converterService, null);

	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Force Rate Estimater Service Stoped !!!");
		publishServiceRegistration.unregister();
	}
}
