package converter.displayer.service;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

import area.converter.service.AreaConverterService;
import datastorage.converter.service.DataStorageConverterService;
import length.converter.service.LengthConverterService;
import mass.converter.service.MassConverterActivator;
import mass.converter.service.MassConverterService;
import pressure.converter.service.PressureConverterService;
import speed.converter.service.SpeedConverterService;
import temperature.converter.service.TemperatureConverterService;
import time.converter.service.TimeConverterService;

/**
 * @author PraveenKumar
 *
 */
public class ServiceActivator implements BundleActivator {

	public ServiceRegistration publishServiceRegistration;
	public static ServiceTracker speedServiceTracker, temperatureServiceTracker, massServiceTracker, timeServiceTracker,
			areaServiceTracker, lengthServiceTracker, pressureServiceTracker, dataServiceTracker;

	public static SpeedConverterService speedConverterService;
	public static TemperatureConverterService temperatureConverterService;
	public static AreaConverterService areaConverterService;
	public static TimeConverterService timeConverterService;
	public static LengthConverterService lengthConverterService;
	public static MassConverterService massConverterService;
	public static PressureConverterService pressureConverterService;
	public static DataStorageConverterService dataConverterService;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Started Displayer Service !!!");
		ServiceDisplayer serviceDisplayer = new ServiceDisplayerImpl();
		publishServiceRegistration = bundleContext.registerService(ServiceDisplayer.class.getName(), serviceDisplayer,
				null);

		speedServiceTracker = new ServiceTracker(bundleContext, SpeedConverterService.class.getName(), null);
		temperatureServiceTracker = new ServiceTracker(bundleContext, TemperatureConverterService.class.getName(), null);
		areaServiceTracker = new ServiceTracker(bundleContext, AreaConverterService.class.getName(), null);
		timeServiceTracker = new ServiceTracker(bundleContext, TimeConverterService.class.getName(), null);
		massServiceTracker = new ServiceTracker(bundleContext, MassConverterService.class.getName(), null);
		lengthServiceTracker = new ServiceTracker(bundleContext, LengthConverterService.class.getName(), null);
		pressureServiceTracker = new ServiceTracker(bundleContext, PressureConverterService.class.getName(), null);
		dataServiceTracker = new ServiceTracker(bundleContext, DataStorageConverterService.class.getName(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopped Displayer Service !!!");
		publishServiceRegistration.unregister();
	}

	public static boolean speedTrackerChecker() {
		speedServiceTracker.open();

		speedConverterService = (SpeedConverterService) speedServiceTracker.getService();

		if (speedConverterService != null)
			return true;
		else
			return false;
	}

	public static boolean temperatureTrackerChecker() {
		temperatureServiceTracker.open();
		temperatureConverterService = (TemperatureConverterService) temperatureServiceTracker.getService();

		if (temperatureConverterService != null)
			return true;
		else
			return false;
	}

	public static boolean areaTrackerChecker() {
		areaServiceTracker.open();
		areaConverterService = (AreaConverterService) areaServiceTracker.getService();

		if (areaConverterService != null)
			return true;
		else
			return false;
	}

	public static boolean timeTrackerChecker() {
		timeServiceTracker.open();
		timeConverterService = (TimeConverterService) timeServiceTracker.getService();

		if (timeConverterService != null)
			return true;
		else
			return false;
	}

	public static boolean massTrackerChecker() {
		massServiceTracker.open();
		massConverterService = (MassConverterService) massServiceTracker.getService();

		if (massConverterService != null)
			return true;
		else
			return false;
	}

	public static boolean lengthTrackerChecker() {
		lengthServiceTracker.open();
		lengthConverterService = (LengthConverterService) lengthServiceTracker.getService();

		if (lengthConverterService != null)
			return true;
		else
			return false;
	}

	public static boolean pressureTrackerChecker() {
		pressureServiceTracker.open();
		pressureConverterService = (PressureConverterService) pressureServiceTracker.getService();

		if (pressureConverterService != null)
			return true;
		else
			return false;
	}

	public static boolean dataTrackerChecker() {
		dataServiceTracker.open();
		dataConverterService = (DataStorageConverterService) dataServiceTracker.getService();

		if (dataConverterService != null)
			return true;
		else
			return false;
	}

}
