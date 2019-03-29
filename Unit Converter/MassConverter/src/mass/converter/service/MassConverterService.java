package mass.converter.service;

public interface MassConverterService {

	//Gram to kg,mg,metric-ton,pound
	
	public double GramToGram(double mass);
	public double GramToKilogram(double mass);
	public double GramToMilligram(double mass);
	public double GramToMetricton(double mass);
	public double GramToPound(double mass);
	
	//Killogram to gram,mg,metric-ton,pound
	
	public double KilogramToKilogram(double mass);
	public double KilogramToGram(double mass);
	public double KilogramToMilligram(double mass);
	public double KilogramToMetricton(double mass);
	public double KilogramToPound(double mass);
	
	//Milligram to gram,kg,metric-ton,pound
	
	public double MilligramToMilligram(double mass);
	public double MilligramToGram(double mass);
	public double MilligramToKilogram(double mass);
	public double MilligramToMetricton(double mass);
	public double MilligramToPound(double mass);
	
	//Metricton to gram,kg,mg,pound
	
	public double MetrictonToMetricton(double mass);
	public double MetrictonToGram(double mass);
	public double MetrictonToKilogram(double mass);
	public double MetrictonToMilligram(double mass);
	public double MetrictonToPound(double mass);
	
	//Pound to gram,kg,mgmmetric-ton,
	
	public double PoundToPound(double mass);
	public double PoundToGram(double mass);
	public double PoundToKilogram(double mass);
	public double PoundToMilligram(double mass);
	public double PoundToMetricton(double mass);
	
	
}
