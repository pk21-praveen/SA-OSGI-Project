package time.converter.service;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import time.converter.service.TimeConverterService;
import time.converter.service.TimeConverterServiceImpl;

public class TimeConverterActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Time Converter Service Started !!!");
		TimeConverterService converterService = new TimeConverterServiceImpl();
		publishServiceRegistration = bundleContext.registerService(TimeConverterService.class.getName(), converterService,null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Time Converter Service Stoped !!!");
		publishServiceRegistration.unregister();

	}

}
