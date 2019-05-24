package converter.displayer.service;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

import area.converter.service.AreaConverterService;
import datastorage.converter.service.DataStorageConverterService;
import estimator.EstimatorDisplayer;
import length.converter.service.LengthConverterService;
import mass.converter.service.MassConverterActivator;
import mass.converter.service.MassConverterService;
import pressure.converter.service.PressureConverterService;
import pressure.estimater.service.estimatorpressure.PressureEstimaterService;
import speed.converter.service.SpeedConverterService;
import temperature.converter.service.TemperatureConverterService;
import time.converter.service.TimeConverterService;
import travel.estimator.service.TravelEstimatorService;
import volume.estimator.service.VolumeEstimatorService;

/**
 * @author PraveenKumar
 *
 */
public class ServiceActivator implements BundleActivator {

	public ServiceRegistration publishServiceRegistration;
	public static ServiceTracker speedServiceTracker, temperatureServiceTracker, massServiceTracker, timeServiceTracker,
			areaServiceTracker, lengthServiceTracker, pressureServiceTracker, dataServiceTracker,travelServiceTracker,realServiceTracker,
			volumeServiceTracker,forceServiceTracker;

	public static SpeedConverterService speedConverterService;
	public static TemperatureConverterService temperatureConverterService;
	public static AreaConverterService areaConverterService;
	public static TimeConverterService timeConverterService;
	public static LengthConverterService lengthConverterService;
	public static MassConverterService massConverterService;
	public static PressureConverterService pressureConverterService;
	public static DataStorageConverterService dataConverterService;
	public static VolumeEstimatorService volumeConverterService;
	public static TravelEstimatorService travelConverterService;
	public static EstimatorDisplayer realConverterService;
	public static PressureEstimaterService forceConverterService;

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
		travelServiceTracker= new ServiceTracker(bundleContext, TravelEstimatorService.class.getName(), null);
		volumeServiceTracker= new ServiceTracker(bundleContext, VolumeEstimatorService.class.getName(), null);
		realServiceTracker= new ServiceTracker(bundleContext, EstimatorDisplayer.class.getName(), null);
		forceServiceTracker= new ServiceTracker(bundleContext, PressureEstimaterService.class.getName(), null);
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
	
	public static boolean travelTrackerChecker() {
		travelServiceTracker.open();
		travelConverterService = (TravelEstimatorService) travelServiceTracker.getService();

		if (travelConverterService != null)
			return true;
		else
			return false;
	}
	
	public static boolean volumeTrackerChecker() {
		volumeServiceTracker.open();
		volumeConverterService = (VolumeEstimatorService) volumeServiceTracker.getService();

		if (volumeConverterService != null)
			return true;
		else
			return false;
	}
	
	public static boolean realTrackerChecker() {
		realServiceTracker.open();
		realConverterService = (EstimatorDisplayer) realServiceTracker.getService();

		if (realConverterService != null)
			return true;
		else
			return false;
	}

	public static boolean forceTrackerChecker() {
		forceServiceTracker.open();
		forceConverterService = (PressureEstimaterService) forceServiceTracker.getService();

		if (forceConverterService != null)
			return true;
		else
			return false;
	}

}
