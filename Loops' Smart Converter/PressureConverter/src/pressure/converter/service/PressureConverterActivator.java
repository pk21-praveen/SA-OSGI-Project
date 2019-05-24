package pressure.converter.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class PressureConverterActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Pressure Converter Service Started !!!");	
		PressureConverterService converterService = new PressureConverterServiceImpl();
		publishServiceRegistration = bundleContext.registerService(PressureConverterService.class.getName(),converterService, null);

	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Pressure Converter Service Stoped !!!");
		publishServiceRegistration.unregister();
	}

}
