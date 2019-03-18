package temperature.converter.service;

/**
 * @author PraveenKumar
 *
 */
public interface TemperatureConverterService {
	// Celsius to Fahrenheit & Kelvin
	public double CelsiusToCelsius(double temp);
	public double CelsiusToFahrenheit(double temp);
	public double CelsiusToKelvin(double temp);

	// Fahrenheit to Celsius & Kelvin
	public double FahrenheitToFahrenheit(double temp);
	public double FahrenheitToCelsius(double temp);
	public double FahrenheitToKelvin(double temp);

	// Kelvin to Celsius & Fahrenheit
	public double KelvinToKelvin(double temp);
	public double KelvinToCelsius(double temp);
	public double KelvinToFahrenheit(double temp);
}
