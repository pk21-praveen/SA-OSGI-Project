package volume.estimator.service;

public interface VolumeEstimatorService {
	
	public String getTimeType();
	public String getRateType();
	public String getVolumeType();
	
	public void setTimeType(String timeType);
	public void setRateType(String rateType);
	public void setVolumeType(String volumeType);
		
	public double getRateValue();
	public double getTimeValue();
	public double getVolumeValue();

	public void setTimeValue(double timeValue);
	public void setRateValue(double rateValue);
	public void setVolumeValue(double volumeValue);
	
	public String displayVolumeAnswer();
	public String displayRateAnswer();
	public String displayTimeAnswer();

	
}


