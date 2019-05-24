package length.converter.service;

public class LengthConverterServiceImpl implements LengthConverterService {

	//Meter to km,cm,mm,inch
	
			public double MeterToMeter(double length) {
				return length*1 ;	
			}
			
			public double MeterToKilometer(double length) {
				return length*0.001 ;	
			}
			
			public double MeterToCentimeter(double length) {
				return length*100;
			}
			
			public double MeterToMillimeter(double length) {
				return length*1000;	
			}
			
			public double MeterToInch(double length) {
				return length*39.37007874;
			}
			
		
			
			//Kilometer to m,am,mm,inch
			
			public double KilometerToKilometer(double length) {
				return length*1 ;	
			}
			
			public double KilometerToMeter(double length) {
				return length*1000 ;	
			}
			
			public double KilometerToCentimeter(double length) {
				return length*100000 ;	
			}
			
			public double KilometerToMillimeter(double length) {
				return length*1000000 ;	
			}
			
			public double KilometerToInch(double length) {
				return length*39370.07874 ;	
			}
			
		

			//Centimeter to m,km,mm,inch
			
			public double CentimeterToCentimeter(double length) {
				return length*1 ;	
			}
			
			public double CentimeterToMeter(double length) {
				return length*0.01 ;	
			}
			
			public double CentimeterToKilometer(double length) {
				return length*0.00001 ;	
			}
			
			public double CentimeterToMillimeter(double length) {
				return length*10 ;	
			}
			
			public double CentimeterToInch(double length) {
				return length*0.3937007874 ;	
			}
			
		
			
			//Millimeter to m,km,cm,inch
			
			public double MillimeterToMillimeter(double length) {
				return length*1 ;	
			}
			
			public double MillimeterToMeter(double length) {
				return length*0.001 ;	
			}
			
			public double MillimeterToKilometer(double length) {
				return length*0.000001 ;	
			}
			
			public double MillimeterToCentimeter(double length) {
				return length*0.1 ;	
			}
			
			public double MillimeterToInch(double length) {
				return length*0.0393700787 ;	
			}
			
		
			
			//Inch to m,km,cm,mm
			
			public double InchToInch(double length) {
				return length*1 ;	
			}
			
			public double InchToMeter(double length) {
				return length*0.0254 ;	
			}
			
			public double InchToKilometer(double length) {
				return length*0.0000254 ;	
			}
			
			public double InchToCentimeter(double length) {
				return length*2.54 ;	
			}
			
			public double InchToMillimeter(double length) {
				return length*25.4 ;	
			}
			
			
			
			

}
