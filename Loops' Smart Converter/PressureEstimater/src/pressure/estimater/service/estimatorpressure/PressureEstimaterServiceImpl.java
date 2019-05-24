package pressure.estimater.service.estimatorpressure;

public class PressureEstimaterServiceImpl implements PressureEstimaterService{

	private double pressureVal;
	private double forceVal;
	private double areaVal;
	private String pressureType;
	private String forceType;
	private String areaType;
		
	
	//getters and setters
	@Override
	public double getPressureVal() {
		
		return this.pressureVal;
	}
	
	@Override
	public double getForceVal() {
		
		return this.forceVal;
	}
	
	@Override
	public double getAreaVal() {
		
		return this.areaVal;
	}

	@Override
	public void setPressureVal(double val) {
		
		this.pressureVal = val;
	}

	@Override
	public void setForceVal(double val) {
		
		this.forceVal = val;
	}

	@Override
	public void setAreaVal(double val) {
		
		this.areaVal = val;
	}

	@Override
	public String getPressureType() {
		
		return this.pressureType;
	}

	@Override
	public String getForceType() {
		
		return this.forceType;
	}

	@Override
	public String getAreaType() {
		
		return this.areaType;
	}

	@Override
	public void setPressureType(String type) {
		
		this.pressureType = type;
	}

	@Override
	public void setForceType(String type) {
		
		this.forceType = type;
	}

	@Override
	public void setAreaType(String type) {
		
		this.areaType = type;
	}

	
	//metho for calculating Pressure..
	@Override
	public String getPressureResult(String type) {
		
		if(areaType.equalsIgnoreCase("Meter * Meter")) {
			
		}else if(areaType.equalsIgnoreCase("Centimeter * Centimeter")) {
			
			areaVal = areaVal / 10000;
			
		}else if(areaType.equalsIgnoreCase("Millimeter * Millimeter")) {
			
			areaVal = areaVal / 10000000;
		}
		
		
		pressureVal = forceVal / areaVal;
		
		
		if(type.equalsIgnoreCase("Pascal")) {
			
		}else if(type.equalsIgnoreCase("Decipascal")) {
			
			pressureVal = pressureVal / 10;
			
		}else if(type.equalsIgnoreCase("Centipascal")) {
			
			pressureVal = pressureVal * 100;
		}
		
		String ans = String.valueOf(Math.round(pressureVal * 1000) / 1000.0);
		
		
		return ans;
	}

	
	//method for calculating Force..
	@Override
	public String getForceResult(String type) {
		
		if(areaType.equalsIgnoreCase("Meter  * Meter")) {
			
		}else if(areaType.equalsIgnoreCase("Centimeter * Centimeter")) {
			
			areaVal = areaVal / 10000;
			
		}else if(areaType.equalsIgnoreCase("Millimeter * Millimeter")) {
			
			areaVal = areaVal / 10000000;
		}
		
		if(pressureType.equalsIgnoreCase("Pascal")) {
			
		}else if(areaType.equalsIgnoreCase("Decipascal")) {
			
			areaVal = areaVal * 10;
			
		}else if(areaType.equalsIgnoreCase("Centipascal")) {
			
			areaVal = areaVal / 100;
		}
		
		forceVal = pressureVal * areaVal;
		
		
		
		String ans = String.valueOf(Math.round(forceVal * 1000) / 1000.0);
		
		return ans;
	}

	
	//method for area calculation
	@Override
	public String getAreaResult(String type) {
		
		if(pressureType.equalsIgnoreCase("Pascal")) {
			
		}else if(pressureType.equalsIgnoreCase("Decipascal")) {
			
			pressureVal = pressureVal * 10;
			
		}else if(pressureType.equalsIgnoreCase("Centipascal")) {
			
			pressureVal = pressureVal / 100;
		}
		
		
		areaVal = forceVal / pressureVal;
		
		if(type.equalsIgnoreCase("Meter * Meter")) {
			
		}else if(type.equalsIgnoreCase("Centimeter * Centimeter")) {
			
			areaVal = areaVal * 10000;
			
		}else if(type.equalsIgnoreCase("Millimeter * Millimeter")) {
			
			areaVal = areaVal * 10000000;
		}
		
		String ans = String.valueOf(Math.round(areaVal * 1000) / 1000.0);
		
		return ans;
	}
	

}
