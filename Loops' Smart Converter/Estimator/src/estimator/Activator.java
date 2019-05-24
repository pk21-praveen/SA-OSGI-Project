package estimator;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;




/**
 * @author Shriram
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Real Estate Estimator Service Started !!!");	
		EstimatorDisplayer estimaterService = new EstimatorDisplayerImpl();
		publishServiceRegistration = bundleContext.registerService(EstimatorDisplayer.class.getName(), estimaterService, null);
	
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Real Estate Estimator Service Stopped !!!");
		publishServiceRegistration.unregister();
	}
}
