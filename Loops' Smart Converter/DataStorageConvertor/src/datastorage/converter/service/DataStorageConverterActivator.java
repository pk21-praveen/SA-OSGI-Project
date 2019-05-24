package datastorage.converter.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class DataStorageConverterActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("DataStorage Converter Service Started !!!");	
		DataStorageConverterService converterService = new DataStorageConverterServiceImpl();
		publishServiceRegistration = bundleContext.registerService(DataStorageConverterService.class.getName(),converterService, null);

	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("DataStorage Converter Service Stoped !!!");
		publishServiceRegistration.unregister();
	}

}
