package temperature.converter.service;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * @author PraveenKumar
 *
 */
public class TemperatureConverterActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Temperature Converter Service Started !!!");
		TemperatureConverterService converterService = new TemperatureConverterServiceImpl();
		publishServiceRegistration = bundleContext.registerService(TemperatureConverterService.class.getName(), converterService,null);

	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Temperature Converter Service Stoped !!!");
		publishServiceRegistration.unregister();

	}
}
