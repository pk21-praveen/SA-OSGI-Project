package pressure.estimater.service.estimatorpressure;

public interface PressureEstimaterService {

	//getter and setters
	public double getPressureVal();
	public double getForceVal();
	public double getAreaVal();
	public void setPressureVal(double val);
	public void setForceVal(double val);
	public void setAreaVal(double val);
	
	public String getPressureType();
	public String getForceType();
	public String getAreaType();
	public void setPressureType(String type);
	public void setForceType(String type);
	public void setAreaType(String type);
	
	//methods for results calculation
	public String getPressureResult(String type);
	public String getForceResult(String type);
	public String getAreaResult(String type);
	
}
