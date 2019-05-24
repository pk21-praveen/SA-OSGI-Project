package temperature.converter.service;

/**
 * @author PraveenKumar
 *
 */
public class TemperatureConverterServiceImpl implements TemperatureConverterService {
	
	//Celsius to Fahrenheit & Kelvin
	@Override
	public double CelsiusToCelsius(double temp) {
		return temp;
	}
	
	@Override
	public double CelsiusToFahrenheit(double temp) {
		return (temp * 9/5) + 32;
	}
	
	@Override
	public double CelsiusToKelvin(double temp) {
		return (temp + 273.15);
	}
	
	//Fahrenheit to Celsius & Kelvin	
	@Override
	public double FahrenheitToFahrenheit(double temp) {
		return temp;
	}
	
	@Override
	public double FahrenheitToCelsius(double temp) {
		return (temp - 32) * 5/9;
	}
	
	@Override
	public double FahrenheitToKelvin(double temp) {
		return FahrenheitToCelsius(temp) + 273.15;
	}
	
	//Kelvin to Celsius & Fahrenheit 	
	@Override
	public double KelvinToKelvin(double temp) {
		return temp;
	}
	
	@Override
	public double KelvinToCelsius(double temp) {
		return (temp - 273.15);
	}
	
	@Override
	public double KelvinToFahrenheit(double temp) {
		return ((temp - 273.15) * 9/5) + 32;
	}

}
