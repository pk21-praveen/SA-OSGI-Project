package travel.estimator.service;

/**
 * @author PraveenKumar
 *
 */
public interface TravelEstimatorService {
	
	public String getTimeType();
	public String getSpeedType();
	public String getDistanceType();
	
	public void setTimeType(String timeType);
	public void setSpeedType(String speedType);
	public void setDistanceType(String distanceType);
		
	public double getSpeedValue();
	public double getTimeValue();
	public double getDistanceValue();

	public void setTimeValue(double timeValue);
	public void setSpeedValue(double speedValue);
	public void setDistanceValue(double distanceValue);
	
	public String displayDistanceAnswer();
	public String displaySpeedAnswer();
	public String displayTimeAnswer();

	
}
