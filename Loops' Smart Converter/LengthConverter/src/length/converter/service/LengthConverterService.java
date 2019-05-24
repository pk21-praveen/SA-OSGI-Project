package length.converter.service;

public interface LengthConverterService {
	
	
	//Meter to km,cm,mm,inch
	
	public double MeterToMeter(double length);
	public double MeterToKilometer(double length);
	public double MeterToCentimeter(double length);
	public double MeterToMillimeter(double length);
	public double MeterToInch(double length);

	
	//Kilometer to m,am,mm,inch
	
	public double KilometerToKilometer(double length);
	public double KilometerToMeter(double length);
	public double KilometerToCentimeter(double length);
	public double KilometerToMillimeter(double length);
	public double KilometerToInch(double length);
	

	//Centimeter to m,km,mm,inch
	
	public double CentimeterToCentimeter(double length);
	public double CentimeterToMeter(double length);
	public double CentimeterToKilometer(double length);
	public double CentimeterToMillimeter(double length);
	public double CentimeterToInch(double length);

	
	//Millimeter to m,km,cm,inch
	
	public double MillimeterToMillimeter(double length);
	public double MillimeterToMeter(double length);
	public double MillimeterToKilometer(double length);
	public double MillimeterToCentimeter(double length);
	public double MillimeterToInch(double length);
	
	
	//Inch to m,km,cm,mm
	
	public double InchToInch(double length);
	public double InchToMeter(double length);
	public double InchToKilometer(double length);
	public double InchToCentimeter(double length);
	public double InchToMillimeter(double length);
	
	

	
	

}
